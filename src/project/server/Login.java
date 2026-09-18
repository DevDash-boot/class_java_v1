package project.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Login implements HttpHandler {

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

    // GET 시 - 로그인  페이지
    private void handleGet(HttpExchange exchange) throws IOException {
        String html = Files.readString(Path.of("src/html/login.html"));
        SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, html);
    }

    // POST 시 - 로그인 전송
    private void handlePost(HttpExchange exchange) throws IOException {
        // Http 요청 바디 읽기
        String requestBody = SimpleHttpServer.readRequestBody(exchange);
        System.out.println("로그인 : " + requestBody);

        // 아이디와 비밀번호 가져오기
        String[] data = requestBody.split("&");
        // URLDecoder를 사용하는 이유 : 이름에 한글을 입력하거나 이메일에 @를 사용하면 깨지는 문제가 있어서 사용한다.
        // id에는 딱히 사용할 필요는 없지만 통일감을 주기 위해 사용
        String id = URLDecoder.decode(data[0].split("=")[1], StandardCharsets.UTF_8);
        String pw = URLDecoder.decode(data[1].split("=")[1], StandardCharsets.UTF_8);

        // 검증
        if (id == null || pw == null || id.isBlank() || pw.isBlank()) {
            SimpleHttpServer.sendResponse(exchange, 400, SimpleHttpServer.TYPE_TEXT, "아이디와 비밀번호를 입력해주세요.");
            return;
        }

        // 로그인할 회원
        Users loginUser = null;

        // 회원 목록에서 아이디와 비밀번호 비교
        for (Users user : UserApiHandler.getUserList()) {
            if (user.getId().equals(id) && user.getPw().equals(pw)) {
                loginUser = user;
                break;
            }
        }
        // 로그인 실패
        if (loginUser == null) {
            String falls = """
                    <script>
                        alert("아이디 또는 비밀번호가 일치하지 않습니다.");
                        history.back();
                    </script>
                    """;

            SimpleHttpServer.sendResponse(exchange, 400, SimpleHttpServer.TYPE_HTML, falls);
            return;
        }

        // 로그인 성공 시
        String success = """
                <script>
                    alert("로그인 성공");
                </script>
                """;
        SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, success);

        // 로그인 성공하면 8080으로 이동
        exchange.getResponseHeaders().set("Location", "/");
        exchange.sendResponseHeaders(302, -1);
        exchange.close();
    }
}
