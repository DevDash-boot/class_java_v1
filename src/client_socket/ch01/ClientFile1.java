package client_socket.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile1 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5000)) {
            System.out.println("클라이언트 : 서버에 연결했습니다.");

            // 서버측으로 메시지를 보내기 위한 출력 스트림 사용
            socket.getOutputStream();

            // socket + PrintWriter
            // PrintWriter --> autoFlush 필요
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("안녕하세요");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
