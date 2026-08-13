package io.exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Subject1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("입력할 내용 : ");
        String memo = sc.nextLine();

        // 사용자에게 메모 내용을 입력 받기
        try (FileWriter fw = new FileWriter("src/io/exercise/memo.txt")) {
            fw.write(memo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader fr = new FileReader("src/io/exercise/memo.txt")) {
            int readData;
            while((readData = fr.read())!=-1){
                System.out.print((char)readData);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.close();
    }
}
