package socket.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 내 ip 주소 : 192.168.5.16
public class ServerFile1 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("서버 측 프로그램 시작 - 포트 번호 : 5000 에서 대기중...");

            // 클라이언트가 내 ip 주소와 포트번호를 사용해서 연결할 때까지 이 줄에서 멈춤(블로킹)
            Socket socket = serverSocket.accept();

            // I/O에서 배웟던 스트림을 사용
            InputStream in = socket.getInputStream();
            // 스트림 체이닝 연결 socket + 브릿지(InputStreamReader) + BufferedReader
            BufferedReader br =  new BufferedReader(new InputStreamReader(in));

            // 클라이언트가 보낸 데이터를 한 줄에 읽어보자.
            String message = br.readLine();
            System.out.println("클라이언트가 보낸 메시지 : " + message);

            System.out.println("클라이언트가 연결 되었습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
