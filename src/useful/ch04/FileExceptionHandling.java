package useful.ch04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileExceptionHandling {
    public static void main(String[] args) {

        FileInputStream fis = null;

        // test1.txt 파일을 읽을 때 사용
        try {
            fis = new FileInputStream("test1.txt");
            return;
        } catch (FileNotFoundException e) { //  파일이 없는 경우 예외 처리
            System.out.println("test1.txt 파일을 찾을 수 없음");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 반드시 수행됨 (return을 만나도 수행)
            System.out.println("finally 수행");
        }
    }
}
