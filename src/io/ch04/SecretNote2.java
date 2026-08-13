package io.ch04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class SecretNote2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 비밀 메모장 ===");
        System.out.println("1. 메모 암호화 저장");
        System.out.println("2. 메모 복호화 읽기");
        System.out.print("선택 : ");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveEncrypted(sc);
        } else if (choice.equals("2")) {
            readDecrypted();
        }

        sc.close();
    }

    static void saveEncrypted(Scanner sc) {
        System.out.print("저장할 메모를 입력하세요 : ");
        String input = sc.nextLine();

        try (FileOutputStream fos = new FileOutputStream("assets/secretNote.txt", true)) {
            byte[] original  = input.getBytes();
            byte[] encrypted = new byte[original.length];

            for (int i = 0; i < original.length; i++) {
                encrypted[i] = (byte) (original[i] + 3);
            }

            fos.write(encrypted);
            System.out.println("암호화 저장 완료!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void readDecrypted() {
        System.out.println("\n=== 복호화된 메모 ===");

        try (FileInputStream fis = new FileInputStream("assets/secretNote.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) (data - 3));
            }
            System.out.println();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}