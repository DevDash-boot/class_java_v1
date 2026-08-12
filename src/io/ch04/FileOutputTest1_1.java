package io.ch04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest1_1 {
    public static void main(String[] args) {
        String data = "Hello, Java FileOutputStream ";

        // new FileOutputStream("assets/c.txt");   // 파일 만들기
        // true : 기존 파일에 있는 데이터에 덮어쓰지 말고, 추가
        // false : 기존 파일에 있는 데이터에 덮어쓰기(기본 false)
        // new FileOutputStream("assets/c.txt", true);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("assets/c.txt");
            fos.write("97".getBytes());
            fos.write(data.getBytes());
            fos.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
