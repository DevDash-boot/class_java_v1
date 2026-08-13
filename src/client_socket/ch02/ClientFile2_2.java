package client_socket.ch02;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile2_2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5000)) {
            System.out.println("=====서버 연결 완료=====");

            // 쓰기 스트림, 클라이언트 ----> 서버
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // 읽기 스트림, 서버 ----> 클라이언트
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 서버측으로 보낼 메세지
            writer.println("안녕. 나는 클라이언트야");

            // 서버 응답 수신
            String responseMessage = reader.readLine(); // 블로킹(서버에서 데이터 보낼 때 까지)
            System.out.println("서버 측 응답 : " + responseMessage);

            // 저장된 응답 출력
            FileInputStream fis = new FileInputStream("assets/a.txt");
            // 파일 내용을 읽을 버퍼
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
