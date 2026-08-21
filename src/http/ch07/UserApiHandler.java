package http.ch07;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * /api/users
 * GET : 목록 조회
 * POST : 새 사용자 등록
 */
public class UserApiHandler implements HttpHandler {
    // 실제로는 DB에 저장한다. 지금은 메모리 리스트로 대신한다.
    // 즉, 서버를 껏다 켜면 내용이 다 사라진다.
    private static final List<User> userList = new ArrayList();

    // 다음에 부여할 id
    private static int nextId = 1;

    // static 초기화 블럭 : 클래스가 메모리에 처음 올라갈 떄 딱 한 번만 실행되는 코드 묶음
    // 이름도 없고, 우리가 직접 호출하지도 않는다. JVM이 알아서 실행한다.
    static {
        addUser(new User("홍길동", "a@naver.com"));
        addUser(new User("김철수", "b@naver.com"));
    }

    private static synchronized int addUser(User user) {
        user.setId(nextId);
        ; // 최초 1이 들어감
        nextId++;
        userList.add(user);
        return user.getId();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            // /api/users 경로 + Method(동작 정의 - GET, POST)
            // 경로가 같아도 Method가 다르면 하는 일이 다르다.
            // 그래서 이 핸들러 안에서 메서드로 한번 더 걸러준다.
            String method = exchange.getRequestMethod();

            if (method.equals("GET")) {
                Thread.sleep(2000); // 요청이 들어왔을 때 2초 대기 -> 3개의 요청이 들어와도 2초만 걸림
                handleGet(exchange);
            } else if (method.equals("POST")) {
                handlePost(exchange);
            } else {
                // 지원하지 않는 요청이 들어왔다면 405 호출
                // 405를 보낼 때는 어떤 메서드가 되는지 Allow 헤더로 알려주는 것이 규칙이다.
                exchange.getResponseHeaders().set("Allow", "GET,POST");
                SimpleHttpServer.sendResponse(exchange, 405, SimpleHttpServer.TYPE_TEXT, "지원하지 않는 메서드 입니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }

    // 목록을 복사해서 다시 돌려준다.
    // 왜 복사 하는가? : 원본을 그대로 넘기면 Gson이 JSON으로 객체를 바꾼다. 순회 도중에 다른 스레드가 POST로 add 요청을 한다면 예외가 발생
    // 즉, 순회 도중에 ArrayList의 크기가 바뀌면 예외를 던지는 증상이 있다.
    private ArrayList<User> copyUserList() {
        return new ArrayList<>(userList);
    }

    // GET : 사용자 목록을 조회(요청 HTTP 메시지 body가 없다.)
    // List<User>를 그대로 넘기면 Gson이 JSON 배열로 바꿔준다.
    private void handleGet(HttpExchange exchange) throws IOException {
        SimpleHttpServer.sendJson(exchange, 200, copyUserList());
    }

    // POST : 요청 본문이 있다. (요청 HTTP 메시지 body가 있다.)
    private void handlePost(HttpExchange exchange) throws IOException {
        // 1. HTTP 요청 body를 읽어야 한다.
        String requestBody = SimpleHttpServer.readRequestBody(exchange);
        System.out.println("POST 요청 [api/users]에서 받은 본문 확인 : " + requestBody);

        // 2. JSON 문자열을 User 객체로 변환
        // 주의 : 예외처리 필요(JSON 형식이 아닌 다른 형식으로 들어올 수 있다.)
        User user;
        try {
            user = new Gson().fromJson(requestBody, User.class);
        } catch (JsonSyntaxException e) {
            SimpleHttpServer.sendResponse(exchange, 400, SimpleHttpServer.TYPE_TEXT, "JSON 형식이 올바르지 않습니다.");
            return;
        }

        // 3. 검증
        if (user == null || user.getName() == null || user.getName().isBlank()) {
            SimpleHttpServer.sendResponse(exchange, 400, SimpleHttpServer.TYPE_TEXT, "name은 반드시 있어야 합니다.");
            return;
        }
        if (user.getEmail() == null) {
            user.setEmail("");
        }

        // 4. 저장 처리 - id값은 고정값이 아니라서 저장 결과를 다시 돌려준다.
        int newId = addUser(user);

        // 5. 등록 성공은 200 대신 201 created로 응답 한다.
        SimpleHttpServer.sendJson(exchange, 201, user);
    }
} // end of class

