package io.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest1 {

    public static void main(String[] args) {

        // 파일을 한 바이트씩 읽는 스트림
        FileInputStream in = null;

        int readData;
        try {
            in = new FileInputStream("assets/a.txt");

            // 파일의 첫 번째 데이터를 한 바이트로 읽기
            readData = in.read();
            System.out.println("1: " + readData);
            System.out.println("1: " + (char)readData);

            // 파일의 두 번째 데이터를 한 바이트로 읽기
            readData = in.read();
            System.out.println("2: " + readData);
            System.out.println("2: " + (char)readData);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // 파일이 없어서 FileNotFoundException 실행 후 finally로 들어오면 NullPoint 에러 발생
                // 방어적 코드
                if(in != null){
                    in.close(); // 종료
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
