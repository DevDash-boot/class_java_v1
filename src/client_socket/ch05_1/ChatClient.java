package client_socket.ch05_1;

import java.io.IOException;
import java.net.Socket;

public class ChatClient extends AbstractClient {
    public ChatClient(String name) {
        super(name);
    }
    @Override
    protected void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 5002);
            System.out.println("[Client] 채팅방에 입장하셨습니다.");
            setSocket(socket);
        } catch (IOException e) {
            System.err.println(
                    "클라이언트 측 연결 도중 예외 발생(IP 또는 포트 주소 확인)"
            );
        }
    }
    public static void main(String[] args) {
        new ChatClient("홍길동").run();
    }
}