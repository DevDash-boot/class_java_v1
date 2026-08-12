package io.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest2 {

    public static void main(String[] args) {
        // 파일을 열면 반드시 닫아 주는 것이 좋다.
        // 하지만 반복적 코드가 매번 발생해서 불편함이 있다.
        // 이 불편함을 해결하기 이해서 try-with-resources 문법을 제공
        // try( 스트림을 생성하면 자동으로 close()를 호출}

        try(FileInputStream in = new FileInputStream("assets/a.txt")){
            int readData;
            while((readData = in.read()) != -1){
                System.out.print((char)readData);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // close() 자동 호출됨
    }
}
