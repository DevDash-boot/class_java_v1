package client_socket.ch05_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class AbstractClient {
    private String name;
    private Socket socket;
    private PrintWriter socketWriterStream;
    private BufferedReader socketReaderStream;
    private BufferedReader keyboardReaderStream;

    public AbstractClient(String name) {
        this.name = name;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public final void run() {
        try {
            connectToServer();
            setupStreams();
            startCommunication();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    protected abstract void connectToServer();

    private void setupStreams() throws IOException {
        socketWriterStream = new PrintWriter(socket.getOutputStream(), true);
        socketReaderStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        keyboardReaderStream = new BufferedReader(new InputStreamReader(System.in));
    }

    private void startCommunication() throws InterruptedException {
        Thread readThread = new Thread(() -> {
            String msg;
            try {
                while ((msg = socketReaderStream.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(msg)) {
                        System.out.println("채팅창 종료");
                        break;
                    } else if ("/angry".equals(msg)) {
                        System.out.println("😡");
                    } else if ("/happy".equals(msg)) {
                        System.out.println("🙂");
                    } else if ("/sad".equals(msg)) {
                        System.out.println("😭");
                    } else if ("/board".equals(msg)) {
                        System.out.println("😑");
                    } else if ("hello".equalsIgnoreCase(msg) || "hi".equalsIgnoreCase(msg)) {
                        System.out.println("🖐️");
                    }else{
                        System.out.println(msg);
                    }
                }
            } catch (Exception e) {
                System.err.println("서버와의 연결이 끊겼습니다.");
            }
        });

        Thread writeThread = new Thread(() -> {
            String input;
            try {
                while ((input = keyboardReaderStream.readLine()) != null) {
                    if ("/angry".equals(input)) {
                        socketWriterStream.println("[" + name + "] 응답 메시지 : 😡");
                    } else if ("/happy".equals(input)) {
                        socketWriterStream.println("[" + name + "] 응답 메시지 : 🙂");
                    } else if ("/sad".equals(input)) {
                        socketWriterStream.println("[" + name + "] 응답 메시지 : 😭");
                    } else if ("/board".equals(input)) {
                        socketWriterStream.println("[" + name + "] 응답 메시지 : 😑");
                    } else if ("hello".equalsIgnoreCase(input) || "hi".equalsIgnoreCase(input)) {
                        socketWriterStream.println("[" + name + "] 응답 메시지 : 🖐️");
                    } else if ("exit".equalsIgnoreCase(input)) {
                        socketWriterStream.println("exit");
                        System.out.println("클라이언트가 종료했습니다.");
                        break;
                    } else {
                        socketWriterStream.println("[" + name + "] " + input);
                    }
                }
            } catch (Exception e) {
                System.err.println("메시지 전송 중 오류 발생");
            }
        });

        readThread.start();
        writeThread.start();

        readThread.join();
        writeThread.join();
    }
}