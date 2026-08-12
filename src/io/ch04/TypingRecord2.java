package io.ch04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TypingRecord2 {
    public static void main(String[] args) {
        // 키보드에서 값을 입력받아서 내가 정의한 파일에 그대로 저장시키는 기능

        Scanner sc = new Scanner(System.in);

        System.out.println("===== 타자 연습 기록기 =====");
        System.out.print("연습한 문장 입력 : ");

        // 도전과제 1 - 입력받은 문자열을 assets/typing.txt 파일에 바로 기록
        // 도전과제 2 - 파일에 한 단어를 입력할 때 소요시간도 함께 표시
        LocalDateTime start = LocalDateTime.now();
        String input = sc.nextLine();

        LocalDateTime end = LocalDateTime.now();

        Duration result = Duration.between(start, end);
        long ms = result.toMillis();
        double sec = ms / 1000.0;

        String record = input + " | 소요시간 : " + sec + "초 " + ms + "ms";

        FileOutputStream fos;
        try {
            fos = new FileOutputStream("assets/typing.txt", true);
            fos.write(record.getBytes());
            fos.write("\n".getBytes());

            fos.flush();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}
