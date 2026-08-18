package socket.ch05_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class AbstractServer {
    private String name;
    public ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter socketWriterStream;
    private BufferedReader socketReaderStream;
    private BufferedReader keyboardReaderStream;

    public AbstractServer(String name) {
        this.name = name;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public final void run() {
        try {
            connectToClient();
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

    protected abstract void connectToClient();

    private void setupStreams() throws IOException {
        socketWriterStream = new PrintWriter(socket.getOutputStream(), true);
        socketReaderStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        keyboardReaderStream = new BufferedReader(new InputStreamReader(System.in));
    }

    private void startCommunication() throws InterruptedException {
        // 1. 클라이언트에서 보낸 데이터를 받기
        Thread readThread = new Thread(() -> {
            String msg;
            try {
                while ((msg = socketReaderStream.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (Exception e) {
                System.err.println("서버와의 연결이 끊겼습니다.");
            }
        });

        // 2. 키보드에서 값을 받아서 메시지 전송
        Thread writeThread = new Thread(() -> {
            String input;
            try {
                while ((input = keyboardReaderStream.readLine()) != null) {
                    socketWriterStream.println("[" + name + "]" + input);
                }
            } catch (Exception e) {
                System.err.println("메세지 전송 중 오류 발생");
            }
        });

        readThread.start();
        writeThread.start();
        readThread.join();
        writeThread.join();
    }
}
