package socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer3 {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("====== 서버 실행 ======");
            Socket socket = serverSocket.accept();
            System.out.println("====== 클라이언트 연결 됨 ======");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 읽기 쓰레드 : 클라이언트에서 온 메시지만 수신
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
                        if ("clean".equalsIgnoreCase(clientMessage)) {
                            System.out.print("\n".repeat(10));
                            System.out.println("=============== 채팅 청소 ===============");
                        }
                    }
                } catch (IOException e) {
                    System.err.println("클라이언트가 강제로 연결을 끊었습니다.");
                }
            });

            // 쓰기 스레드 : 키보드에서 값을 입력받아서 클라이언트로 전송
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String serverMessage;
                    try {
                        while ((serverMessage = keyboardReader.readLine()) != null) {
                            if ("exit".equalsIgnoreCase(serverMessage)) {
                                writer.println(serverMessage);
                                System.out.println("서버가 종료했습니다.");
                                break;
                            }
                            if("ㅠㅠ".equalsIgnoreCase(serverMessage)){
                                writer.println(serverMessage);
                                continue;
                            }
                            writer.println("[Server] 응답 메시지 : " + serverMessage);
                            if ("clean".equalsIgnoreCase(serverMessage)) {
                                writer.println(serverMessage);
                                System.out.print("\n".repeat(10));
                                System.out.println("=============== 채팅 청소 ===============");
                            }

                        }
                    } catch (IOException e) {
                        System.err.println("서버가 강제로 연결을 끊었습니다.");
                    }
                }
            });

            readThread.start();
            writeThread.start();

            // 메인 스레드에게 내가 종료될 때까지 기다려
            readThread.join();
            writeThread.join();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}