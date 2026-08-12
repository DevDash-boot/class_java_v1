package io.ch04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TypingRecord1 {
    public static void main(String[] args) {
        // 키보드에서 값을 입력받아서 내가 정의한 파일에 그대로 저장시키는 기능

        Scanner sc = new Scanner(System.in);

        System.out.println("===== 타자 연습 기록기 =====");
        System.out.print("연습한 문장 입력 : ");
        String input = sc.nextLine();
        FileOutputStream fos;

        // 도전과제 1 - 입력받은 문자열을 assets/typing.txt 파일에 바로 기록
        // 도전과제 2 - 파일에 한 단어를 입력할 때 소요시간도 함께 표시
        LocalDateTime start = LocalDateTime.now();
        try {
            fos = new FileOutputStream("assets/typing.txt", true);
            fos.write(input.getBytes());

            fos.flush();
            sc.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LocalDateTime end = LocalDateTime.now();

        Duration timeResult = Duration.between(start, end);
        System.out.println("소요시간 : " + timeResult.toNanos() + " ns");

        byte[] buf = new byte[255];
        try (FileInputStream fis = new FileInputStream("assets/typing.txt")) {
            fis.read(buf);
            System.out.println("입력된 내용 : " + new String(buf));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
