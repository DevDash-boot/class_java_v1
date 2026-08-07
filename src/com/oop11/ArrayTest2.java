package com.oop11;

public class ArrayTest2 {
    public static void main(String[] args) {
        String s1 = "안녕";
        String s2 = new String("안녕");

        String[] names = new String[5];

        // 인덱스 연산자를 활용하여 값 초기화
        names[0] = "김씨";
        names[1] = "이씨";
        names[2] = "최씨";

        System.out.println(names);  // 주소값 출력
        System.out.print(names[0]);
        System.out.print(" " +names[1]);
        System.out.println(" " +names[2]);

        // 인덱스 연산자를 통해서 값을 수정
        names[0] = "Mr.Kim";
        names[1] = "Mr.Lee";
        names[2] = "Mr.Choi";
        System.out.print(names[0]);
        System.out.print(" " +names[1]);
        System.out.println(" " +names[2]);

        // 삭제 <- 값이 없는 경우 null
        names[0] = null;
        names[1] = null;
        names[2] = null;
        System.out.print(names[0]);
        System.out.print(" " +names[1]);
        System.out.println(" " +names[2]);

        // 배열의 길이, 인덱스 크기 확인
        System.out.println("배열의 길이: " + names.length);  // length는 변수
        System.out.println("배열의 인덱스 크기: " + (names.length -1));

    }
}
