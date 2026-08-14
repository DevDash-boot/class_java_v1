package socket.ch03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WhileServer {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("=== 클라이언트의 연결 대기 중 ===");

            // 1. serverSocket.accept()  --> 2. socket
            Socket socket = serverSocket.accept();  // 블로킹
            System.out.println("클라이언트 연결 완료");

            // 2. 입력 / 출력 스트림 준비
            // socket.getInputStream() : 한 바이트씩 읽기
            // InputStreamReader : 브릿지 역할
            // BufferedReader(new InputStreamReader(socket.getInputStream()) : 데코레이터 방식
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);   // 출력

            // 3. 서버 측 프로그램 키보드에서 데이터를 받아서 클라이언트로 전송하기 위한 키보드 스트림 준비
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 4. 1) 클라이언트가 먼저 메시지를 보내면 ---> 2) 서버 측에서 데이터를 읽고
            // ---> 3) 답을 주기 위해 키보드에서 값 입력 ---> 4) 클라이언트에게 응답
            String line;
            while ((line = reader.readLine()) != null) {
                // 프로토콜 : exit 문자열에 들어오면 프로그램 종료
                // 키보드에서 받은 값이 exit 라면 키보드 입력 스트림 종료
                if ("exit".equalsIgnoreCase(line)) {  // equals() 대신 equalsIgnoreCase을 사용해 대소문자 구분 무시
                    break;
                }
                System.out.println("클라이언트 >> " + line);
            }
            // 서버 측에서 키보드의 값을 받아서 보내기
            System.out.println("=== 콘솔 로그 | 내용 입력 ===");
            // 키보드에서 값을 받기 위해 대기(블로킹)
            String serverKeyboardMessage = keyboardReader.readLine();  // = sc.nextLine() 과 같은 기능
            // 키보드에서 입력받은 값을 클라이언트와 연결되어 있는 출력 스트림을 통해서 보내기
            writer.println(serverKeyboardMessage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
