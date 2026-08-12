package io.ch04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SecretNote {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("===== 비밀 메모장 =====");
        System.out.print("저장할 메모를 입력하세요 : ");
        String input = sc.nextLine();

        // 비밀 메모장 기능을 구현
        try (FileOutputStream fos = new FileOutputStream("assets/SecretNote.txt")) {
            byte[] original = input.getBytes();
            byte[] encrypted = new byte[original.length];

            for(int i=0; i< original.length; i++){
                encrypted[i] = (byte) (original[i] + 3);
            }
            fos.write(encrypted);
            fos.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.close();
    }
}
