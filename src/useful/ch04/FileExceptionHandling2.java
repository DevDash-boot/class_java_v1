package useful.ch04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileExceptionHandling2 {
    public static void main(String[] args) {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream("test1.txt");
            byte[] data = fis.readAllBytes();   // 파일 전체를 읽어온다.
            String content = new String(data, StandardCharsets.UTF_8); // 바이트로 읽은 값을 문자열로 변환

            System.out.println("-----------------파일 내용 시작----------------------");
            System.out.println("-----------------파일 내용 끝!-----------------------");
            System.out.println(content);    // test1.txt의 내용이 출력된다.

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();    // 메모리 누수 방지를 위해 닫기
                } catch (Exception e) {
                    System.out.println("파일을 닫는 도중 문제가 발생");
                }
            }
        }
    }
}
