package client_socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class WhileClient {
    public static void main(String[] args) {

        // 1. 소켓 준비 (서버의 IP 주소, 포트 번호)
        try (Socket scoket = new Socket("localhost", 5000)) {

            // 2. 소켓과 연결된 입력 / 출력 스트림
            BufferedReader reader = new BufferedReader(new InputStreamReader(scoket.getInputStream())); // 입력
            PrintWriter writer = new PrintWriter(scoket.getOutputStream(), true);   // 출력

            // 3. 클라이언트 측 키보드 스트림
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 4. 데이터 전송
            String line;
            while (true) {
                System.out.println("[client]콘솔 로그 클라이언트 입력>>> ");
                String input = keyboardReader.readLine();  // 블로킹
                writer.println(input);  // 소켓과 연결된 출력 스트림을 사용해서 서버 측에 데이터 전송
                // 키보드에서 받은 값이 exit 라면 키보드 입력 스트림 종료
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                // 5. 서버 측에서 보낸 메시지를 받아서 클라이언트 콘솔창에 출력 및 종료
                String response = reader.readLine();
                if ("exit".equalsIgnoreCase(response)) {
                    break;
                }
                System.out.println("서버 측 응답 : " + response);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
