package socket.ch02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile2_3 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("===== 서버 =====");
            Socket socket = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            String message = bufferedReader.readLine();
            System.out.println("클라이언트 측 메시지 " + message);

            printWriter.println("서버가 전달하는 메시지 내용");

            FileOutputStream fos = new FileOutputStream("assets/a.txt");
            fos.write(message.getBytes());
            fos.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
