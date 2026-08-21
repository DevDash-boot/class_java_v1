package http.ch07;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/*
 * 핸들러(handler)란?
 * 다루다, 처리하다 라는 뜻이며 핸들러는 처리하는 쪽이라는 뜻이다.
 * 프로그래밍에서 어떤 일이 발생했을 때 실행될 코드를 가리킬때 사용
 */

public class HealthHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_HTML, "OK");

            /*
            // 1. 보낼 내용을 준비한다.
            String bodyText = "OK";

            // 2. 문자열을 바이트 배열로 바꾼다.
            byte[] bodyBytes = bodyText.getBytes(StandardCharsets.UTF_8);

            // 3. 응답의 종류를 헤더에 적는다. 응답 HTTP 메시지)
            exchange.getResponseHeaders().set("Content-Type", SimpleHttpServer.TYPE_TEXT);

            // 4. 상태 코드와 본문 길이를 설정하며 헤더를 실제로 내보낸다.
            exchange.sendResponseHeaders(200, bodyBytes.length);

            // 5. 헤더가 나간 다음에야 본문 통로가 열린다.
            // getResponseBody() 는 OutputStream이므로 문자열이 아니라 바이트를 사용하고 있다.
            try (OutputStream out = exchange.getResponseBody()) {
                out.write(bodyBytes);
            }
            */
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            exchange.close();
        }
    }
}
