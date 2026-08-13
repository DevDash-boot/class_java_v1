package io.ch06;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
    public static byte[] memory = new byte[1024*1024*10];
    static int data;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Copy();
        Paste();

    }

    // 파일 복사
    // 파일을 memory에 복사해넣고
    public static void Copy(){
        try (FileInputStream fis = new FileInputStream("src/io/ch06/img1.zip")) {
            while((data = fis.read())!=-1){
                fis.read(memory);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }   // end of copy

    // 파일 붙여넣기
    // memory에서 꺼내기
    public static void Paste(){
        try (FileOutputStream fos = new FileOutputStream("src/io/ch06/img2.zip")) {
            fos.write(memory);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }   // end of paste
}
