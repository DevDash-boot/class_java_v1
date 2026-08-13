package io.ch06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

public class FileCopy2 {

    // 1. 파일 위치 지정(원본 경로, 복사될 경로)
    // 2. 스트림 - 파일 기반
    // 3. 소요시간 측정

    public static void main(String[] args) {
        String sourceFilePath = "assets/employees.zip";
        String destinationFilePath = "src/io/ch06/employees_copy.zip";
        long startTime = System.nanoTime(); //  나노초로 현재 시간 측정

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {
            int data;
            while((data=fis.read()) !=-1 ){
                fos.write(data);
            }
            System.out.println("파일 복사 완료");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("소요 시간 : " + duration + "ns");
        System.out.println("소요 시간 : " + duration / 1000000000.0 + "초");

    }
}
