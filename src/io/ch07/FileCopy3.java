package io.ch07;

import java.io.*;

public class FileCopy3 {
    public static void main(String[] args) {
        String sourceFilePath = "assets/employees.zip";
        String destinationFilePath = "src/io/ch07/employees_copy.zip";
        long startTime = System.nanoTime(); //  나노초로 현재 시간 측정

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = new byte[1024];
            int data;
            while ((data = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, data);  //읽은 수 만큼만
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
