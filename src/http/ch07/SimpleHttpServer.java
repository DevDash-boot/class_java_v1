package http.ch07;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

/*
 * 순수 자바로 만드는 HTTP 서버
 * [등장 클래스]
 * HttpServer : 포트를 열고 연결을 받는 것을 담당
 * HttpHandler : 특정 경로의 처리 로직을 담당
 * HttpExchange : 요청 하나의 내용과 응답 처리를 담당하는 클래스
 * 요청이 들어올 때마다 서버가 새로 만들어 handle()에게 넘겨주고 끝난다.
 *
 *     Socket     vs    HttpExchange
 * -----------------------------------
 * getInputStream()    getRequestBody()
 * getOutputSream()    getResponseBody()
 * (직접 파싱해야 했다.)  getRequestMethod()
 * (직접 파싱해야 했다.)  getRequestURI()
 *
 * Socket은 바이트가 왔다 까지만 알려줌.
 * HttpExchange는 그 바이트를 HTTP 규칙대로 해석해 둔 결과까지 들고옴.
 */

public class SimpleHttpServer {
    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 10; // 미리 생성해두는 스레드 개수를 의미

    static final String TYPE_HTML = "text/html; charset=UTF-8";
    static final String TYPE_TEXT = "text/plain; charset=UTF-8";
    static final String TYPE_JSON = "application/json; charset=UTF-8";

    public static void main(String[] args) throws IOException {
        // 1. HttpServer 객체 생성
        /*
         * 지금까지 사용하던 ServerSocket(8080) 과 같은 일을 한다
         * HttpServer.create(new InetSocketAddress(PORT), 0);
         * : 둘 다 이 포트로 들어오는 연결을 내가 받겠다. 라고 운영체제에 등록하는 일
         * 차이는 받는 바이트를 누가 해석하느냐 뿐이다.
         *
         * 첫 번째 인자 : InetSocketAddress = 주소 + 포트
         * InetSocketAddress("127.0.0.1", 8080) 주소로 들어온 요청만 받는다.
         * 즉 외부에서 오는 요청은 안 받는다.
         *
         * 두 번째 인자 : 블로킹, 대기 큐 크기
         * 서버가 아직 처리하지 못한 연결이 줄 서서 기다리는 자리 수다.
         * 0이나 음수를 주면 현재 코드에서는 아마 내부적으로 기본값 50으로 바꿔서 처리를 한다.
         */
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // 2. 경로와 담당 핸들러 연결
        /*
         * /signup - 이러한 (약속)경로가 들어오면 어떤 메서드(핸들러), 객체를 실행해 라고 미리 정의하는 것이 필요하다.
         * 등록 순서는 상관이 없다. 요청이 오면 가장 길게 일치하는 경로가 선택된다.
         * 즉, /api/users 요청이 들어오면 "/"와 "/api/users" 둘 다 걸리지만 더 긴 쪽이 이긴다.
         */

        // 접근 경로 예시 : http://localhost:8080/
        server.createContext("/", new HomeHandler());
        // 접근 경로 예시 : http://localhost:8080/health
        server.createContext("/health", new HealthHandler());
        // 접근 경로 예시 : http://localhost:8080/api/users
        server.createContext("/api/users", new UserApiHandler());
        // 접근 경로 예시 : http://localhost:8080/api/time
        server.createContext("/api/time", new TimeHandler());
        // 접근 경로 예시 : http://localhost:8080/api/h11
        server.createContext("/api/h11", new H11Handler());

        // 3. 요청을 처리할 스레드 풀 지정 (http 서버는 멀티 스레드 프로그램이라서 미리 생성할 스레드를 지정한다.
        server.setExecutor(Executors.newFixedThreadPool(THREAD_POOL_SIZE));

        // 4. 서버 시작(main은 여기서 끝나고, 서버는 별도 스레드에서 계속 돈다)
        // main 이 끝나도 프로그램이 종료되지 않는 이유는 HttpServer가 만든 스레드가 살아 있기 때문이다.
        // 멈추려면 종료 버튼을 누른다.
        server.start();

        System.out.println(">> HTTP 서버 시작 <<");

    }   // end of main

    //----------------------
    // 공통 메서드 정의
    //----------------------

    // 응답을 내보낸다.
    static void sendResponse(HttpExchange exchange, int statusCode, String contentType, String bodyText) throws IOException {
        // 1. 보낼 데이터 (매개변수 bodyText)

        // 2. 문자열을 바이트 배열로 바꾼다.
        byte[] bodyBytes = bodyText.getBytes(StandardCharsets.UTF_8);

        // 3. 응답의 종류를 헤더에 적는다. 응답 HTTP 메시지)
        exchange.getResponseHeaders().set("Content-Type", contentType);

        // 4. 상태 코드와 본문 길이를 설정하며 헤더를 실제로 내보낸다.
        exchange.sendResponseHeaders(statusCode, bodyBytes.length);

        // 5. 헤더가 나간 다음에야 본문 통로가 열린다.
        // getResponseBody() 는 OutputStream이므로 문자열이 아니라 바이트를 사용하고 있다.
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bodyBytes);
        }
    }

    // JSON 으로 응답하는 경우는 다른 핸들러에서도 사용할 수 있어서 여기서 로직을 작성한다.
    static void sendJson(HttpExchange exchange, int statusCode, Object data) throws IOException {
        // new Gson().toJson(data) : 자바 객체를 JSON 문자열로 변환
        sendResponse(exchange, statusCode, TYPE_JSON, new Gson().toJson(data));
    }

    // 요청 본문(body)을 문자열로 읽는 기능
    /*
     * {
     * "name":"짱구",
     * "email":"jjang9@gmail.com"
     * }
     */
    static String readRequestBody(HttpExchange exchange) throws IOException {
        StringBuffer requestBody = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }
        return requestBody.toString();
    }

}   // end of class
