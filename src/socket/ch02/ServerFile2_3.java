package socket.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile2_3 {
    public static void main(String[] args) {
        // 서버 측 준비물
        // ServerSocket
        // Socket
        // BufferedReader
        // PrintWriter

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("서버 측 시작");

            Socket socket = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);

            String message = bufferedReader.readLine();
            System.out.println("클라이언트에서 온 메시지 : " + message);

            printWriter.println("서버가 보내는 메시지 ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
