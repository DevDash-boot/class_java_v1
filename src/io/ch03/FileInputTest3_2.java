package io.ch03;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalTime;

public class FileInputTest3_2 {

    public static void main(String[] args) {

        byte[] buffer = new byte[255];

        int readCount;

        try(FileInputStream in = new FileInputStream("assets/a1.txt")){

            while((readCount = in.read(buffer)) != -1){
                for(int i=0; i< readCount;i++){
                    in.read(buffer);
                    System.out.println(new String(buffer));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
