package io.ch03;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;

public class FileInputTest3_1 {

    public static void main(String[] args) {
        byte[] buffer = new byte[255];

        int readCount;
        LocalTime start = LocalTime.now();

        try(FileInputStream in = new FileInputStream("assets/b.txt")){
            while((readCount = in.read(buffer)) != -1){
                for(int i=0; i< readCount;i++){
                    System.out.print((char)buffer[i]);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // close() 자동 호출됨
        LocalTime end = LocalTime.now();

        Duration result = Duration.between(start, end);
        System.out.println();
        System.out.println("시작 시간: " + start);
        System.out.println("종료 시간: " + end);
        System.out.println("소요 시간: " + result.toNanos() + " ns");

    }
}
