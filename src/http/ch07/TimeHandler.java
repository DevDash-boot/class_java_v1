package http.ch07;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeHandler implements HttpHandler {

    // 현재 시간 출력
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try{
            LocalDateTime start = LocalDateTime.now();
            DateTimeFormatter log = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            SimpleHttpServer.sendResponse(exchange,200,SimpleHttpServer.TYPE_TEXT, start.format(log));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            exchange.close();
        }
    }
}
