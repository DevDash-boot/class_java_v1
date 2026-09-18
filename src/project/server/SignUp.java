package project.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

// 회원가입에서 필요한 기능
// 아이디, 비밀번호 작성 시 list에 저장
// 아이디 중복 방지(등록된 id가 있다면~)
// get으로 SimpleHttpServer의 list를 가져오고
// post로 id와 pw, name, email을 전송해준다.    UserApiHandler 참고

// 회원가입 완료 후 로그인 페이지로 이동

public class SignUp implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        // GET 요청
        if (method.equals("GET")) {
            handleGet(exchange);
        } else if (method.equals("POST")) {
            handlePost(exchange);
        } else {
            exchange.getResponseHeaders().set("Allow", "GET, POST");
            SimpleHttpServer.sendResponse(exchange, 405, SimpleHttpServer.TYPE_TEXT, "지원하지 않는 메서드 입니다");
        }
    }

    // GET 시 - 회원가입 페이지
    private void handleGet(HttpExchange exchange) throws IOException {
        String html = Files.readString(Path.of("src/html/signup.html"));
        SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, html);
    }

    // POST 시 - 회원가입 전송
    private void handlePost(HttpExchange exchange) throws IOException {
        // Http 요청 바디 읽기
        String requestBody = SimpleHttpServer.readRequestBody(exchange);

        // 이름, 아이디, 비밀번호, 이메일 가져오기
        String[] data = requestBody.split("&");
        // URLDecoder를 사용하는 이유 : 이름에 한글을 입력하거나 이메일에 @를 사용하면 깨지는 문제가 있어서 사용한다.
        // id에는 딱히 사용할 필요는 없지만 통일감을 주기 위해 사용
        String name = URLDecoder.decode(data[0].split("=")[1], StandardCharsets.UTF_8);
        String id = URLDecoder.decode(data[1].split("=")[1], StandardCharsets.UTF_8);
        String pw = URLDecoder.decode(data[2].split("=")[1], StandardCharsets.UTF_8);
        String email = URLDecoder.decode(data[3].split("=")[1], StandardCharsets.UTF_8);

        System.out.println("회원가입 요청");

        // 검증
        if (name == null || id == null || pw == null || email == null
                || name.isBlank() || id.isBlank() || pw.isBlank() || email.isBlank()) {

            SimpleHttpServer.sendResponse(exchange, 400, SimpleHttpServer.TYPE_TEXT, "모두 입력해주세요");
            return;
        }

        // 아이디 중복 검사
        if (UserApiHandler.existsId(id)) {
            SimpleHttpServer.sendResponse(exchange, 401, SimpleHttpServer.TYPE_TEXT, "이미 존재하는 아이디입니다.");
            return;
        }

        // 리스트에 정보 저장
        Users user = new Users(name, id, pw, email);
        UserApiHandler.addUser(user);
        System.out.println("회원가입 완료" + user);

        // 회원가입 완료 시
        String success = """
                <script>
                    alert("회원가입 완료");
                </script>
                """;

        // 회원가입 완료하면 로그인 페이지로 이동하기
        SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, success);
        exchange.getResponseHeaders().set("Location", "/api/login");
        exchange.close();
    }
}
