package io.ch04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest1 {
    public static void main(String[] args) {
        String data = "Hello, Java FileOutputStream ";

        // new FileOutputStream("assets/c.txt");   // 파일 만들기
        // true : 기존 파일에 있는 데이터에 덮어쓰지 말고, 추가
        // false : 기존 파일에 있는 데이터에 덮어쓰기(기본 false)
        // new FileOutputStream("assets/c.txt", true);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("assets/c.txt", true);
            fos.write(97);
            fos.write(98);
            fos.write(99);

            // getBytes()를 이용해 String으로 선언된 data의 내용을 넣을 수 있다.
            fos.write(data.getBytes());

            // 버퍼(Buffer)에 남아 있는 데이터를 강제로 비우고(출력하고) 파일로 밀어내는 메서드
            // fos.close()메서드를 호출하면 자동으로 flush() -> close 된다.
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
