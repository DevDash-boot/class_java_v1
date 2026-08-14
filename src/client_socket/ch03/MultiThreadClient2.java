package client_socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiThreadClient2 {
    public static void main(String[] args) {
        // 1. 소켓 준비(서버 측 IP 주소, 포트 번호)
        try (Socket socket = new Socket("localhost", 5001)) {
            System.out.println("====== 클라이언트 실행 ======");
            System.out.println("====== 서버 연결됨 ======");

            // 2. 입력 / 출력 / 키보드 스트림
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 3. 읽기 쓰레드
            Thread readThread = new Thread(() -> {
                String serverMessage;
                try {
                    while ((serverMessage = reader.readLine()) != null) {

                        if ("exit".equalsIgnoreCase(serverMessage)) {
                            System.out.println("서버가 종료했습니다.");
                            break;
                        }
                        System.out.println( serverMessage);
                        if ("clean".equalsIgnoreCase(serverMessage)) {
                            System.out.print("\n".repeat(30));
                            System.out.println("=============== 채팅 청소 ===============");

                        }
                    }
                } catch (Exception e) {
                    System.err.println("서버가 강제로 연결을 끊었습니다.");
                }
            });

            // 4. 쓰기 스레드 : 키보드에서 값을 입력받아서 서버로 전송
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String clientMessage;
                    try {
                        while ((clientMessage = keyboardReader.readLine()) != null) {
                            if ("exit".equalsIgnoreCase(clientMessage)) {
                                writer.println(clientMessage);
                                System.out.println("클라이언트가 종료했습니다.");
                                break;
                            }
                            writer.println("[Client] 응답 메시지 : " + clientMessage);
                            if ("clean".equalsIgnoreCase(clientMessage)) {
                                writer.println(clientMessage);
                                System.out.print("\n".repeat(30));
                                System.out.println("=============== 채팅 청소 ===============");
                            }

                        }
                    } catch (IOException e) {
                        System.err.println("클라이언트가 강제로 연결을 끊었습니다.");
                    }
                }
            });

            readThread.start();
            writeThread.start();

            // 메인 스레드에게 내가 종료될 때까지 기다려
            readThread.join();
            writeThread.join();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
