package client_socket.ch05;

import java.io.IOException;
import java.net.Socket;

public class ChatClient extends AbstractClient{
    public ChatClient(String name) {
        super(name);
    }

    @Override
    protected void connectToServer() {
        try {
            setSocket(new Socket("localhost", 5002));
        } catch (IOException e) {
            System.err.println("서버 측 연결 도중 예외 발생(IP 또는 포트 주소 확인)");
        }
    }

    public static void main(String[] args) {
        new ChatClient("홍길동").run();
    }
}
