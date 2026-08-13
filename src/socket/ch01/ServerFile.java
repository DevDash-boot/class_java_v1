package socket.ch01;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerFile {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("서버측 프로그램 시작 - 포트 번호 : 5000 에서 대기중...");

            // 클라이언트가 내 ip 주소와 포트번호를 사용해서 연결할 때까지 이 줄에서 멈춤(블로킹)
            serverSocket.accept();
            System.out.println("클라이언트가 연결 되었습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
