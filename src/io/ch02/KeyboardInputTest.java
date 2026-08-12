package io.ch02;

import java.io.IOException;

public class KeyboardInputTest {
    public static void main(String[] args) throws IOException {
        // 표준 출력 스트림 -OutputStream -> print()
        System.out.print("문자를 입력하세요 :");

        // 표준 입력 스트림 - InputStream (키보드)
        int keyCode = System.in.read(); // 한 바이트씩 읽는다.

        System.out.println("반환된 정수값 : " + keyCode);
        System.out.println("문자로 변환(char) : " + (char)keyCode);

        System.err.println("한글은 깨져서 표준 입출력만으로 처리가 힘들다");
    }
}
