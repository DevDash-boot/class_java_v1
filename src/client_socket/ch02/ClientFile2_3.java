package client_socket.ch02;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile2_3 {
    public static void main(String[] args) {
        // 클라이언트 측 준비물
        // Socket
        // PrintWriter
        // BufferReader

        try (Socket socket = new Socket("localhost", 5000)) {

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.println("클라이언트에서 전송하는 메시지");

            String response = bufferedReader.readLine();
            System.out.println("서버 측 응답 메시지 : " + response);

            FileInputStream fis = new FileInputStream("assets/a.txt");
            byte[] buffer = new byte[1024*1024];
            int data;
            System.out.println("===== a.txt 내용 =====");
            while ((data = fis.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, data));
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
