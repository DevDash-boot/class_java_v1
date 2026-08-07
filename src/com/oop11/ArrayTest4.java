package com.oop11;

public class ArrayTest4 {
    public static void main(String[] args) {
        String[] names = new String[10];

        // 인덱스 연산자를 활용하여 값 초기화
        names[0] = "김씨";
        names[1] = "이씨";
        names[2] = "박씨";
        names[9] = "최씨";

        // null 값이 출력되지 않고 요소만 출력되도록 코드 수정
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                System.out.print(names[i] + " ");
            }
        }
    }
}
