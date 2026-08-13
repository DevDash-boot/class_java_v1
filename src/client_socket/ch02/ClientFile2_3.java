package client_socket.ch02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

            printWriter.println("클라이언트가 보내는 메시지");

            String response = bufferedReader.readLine();
            System.out.println("서버에서 온 응답 : " + response);


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
