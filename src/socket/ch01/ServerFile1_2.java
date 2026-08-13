package socket.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile1_2 {
    public static void main(String[] args) {

        // 단방향 통신
        // 서버에서 필요한 것
        // ServerSocket
        // Socket
        // BufferedReader

        try (ServerSocket ss = new ServerSocket(5000)) {
            System.out.println("서버 측 프로그램 시작");
            // accept
            Socket s = ss.accept();

            InputStream in = s.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            String message = bufferedReader.readLine();
            System.out.println("클라이언트가 보낸 메시지 : " + message);

            System.out.println("클라이언트가 연결됨");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
