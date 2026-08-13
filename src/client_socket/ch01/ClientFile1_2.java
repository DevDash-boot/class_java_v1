package client_socket.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile1_2 {
    public static void main(String[] args) {
        // 준비물 socket, printWriter
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("클라이언트 연결 완료");

            socket.getOutputStream();

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("안녕하세요");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
