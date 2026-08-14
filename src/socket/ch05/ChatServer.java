package socket.ch05;


import socket.ch04.MultiChatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends AbstractServer{
    public ChatServer(String name) {
        super(name);
    }

    @Override
    protected void connectToClient() {
        try {
            setServerSocket(new ServerSocket(5002));
        } catch (IOException e) {
            System.err.println("서버 측 연결 도중 예외 발생(IP 또는 포트 주소 확인)");
        }
    }

    public static void main(String[] args) {
        new ChatServer("고길동").run();
    }
}
