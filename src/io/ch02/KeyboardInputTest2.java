package io.ch02;

import java.io.IOException;

public class KeyboardInputTest2 {
    public static void main(String[] args) throws IOException {
        // in - 한 번에 여러 데이터를 받을 수 있는 기능을 구현
        // Scanner <-- 표준 입출력 사용
        System.out.print("알파벳 여러개를 쓰고 enter를 누르세요 : ");

        int i;
        // 키보드 입력을 한 글자씩 읽어와서, 그 값이 줄바꿈(\n, 엔터)이 아닐 때까지 반복하겠다
        // \n 대신 -1을 사용하면 끝까지를 의미
        // i = System.in.read()) != '\n' ---> true
        while((i = System.in.read()) != '\n' ){
            //System.out.print("i : " + i);
            //System.out.println("\t문자로 변환 : " + (char)i);
            System.out.println("받은 결과 : " + (char)i);
        }
    }
}
