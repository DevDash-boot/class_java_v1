package socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer4 {
    public static void main(String[] args) {
        // 1. ServerSocket 준비
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println(" 서버 ---연결 대기중---> 클라이언트");
            // 2. 블로킹
            Socket socket = serverSocket.accept();
            System.out.println("클라이언트가 연결했습니다.");

            // 3. 입력 스트림, 출력 스트림, 키보드 스트림
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 읽기 스레드
            Thread readThread = new Thread(() -> {
                String clientMessage;
                try {
                    while ((clientMessage = reader.readLine()) != null) {
                        if ("exit".equalsIgnoreCase(clientMessage)) {
                            System.out.println("클라이언트가 종료했습니다.");
                            break;
                        }
                        if("ㅠㅠ".equalsIgnoreCase(clientMessage)){
                            System.out.println("😭");    // 메시지 보내기
                            continue;
                        }
                        System.out.println(clientMessage);
                    }
                } catch (IOException e) {
                    System.err.println("클라이언트가 강제로 연결을 끊었습니다.");
                }
            });

            // 쓰기 스레드
            Thread writeThread = new Thread(() -> {
                String serverMessage;
                try{
                    while((serverMessage = keyboardReader.readLine())!= null){
                        if ("exit".equalsIgnoreCase(serverMessage)) {
                            writer.println(serverMessage);
                            System.out.println("클라이언트가 종료했습니다.");
                            break;
                        }
                        if("ㅠㅠ".equalsIgnoreCase(serverMessage)){
                            writer.println(serverMessage);    // 메시지 보내기
                            continue;
                        }
                        System.out.println(serverMessage);
                    }
                } catch (Exception e) {
                    System.err.println("서버가 강제로 연결을 끊었습니다.");
                }
            });

            readThread.start();
            writeThread.start();
            readThread.join();
            writeThread.join();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
