package com.oop11;

import java.util.Random;

public class ArrayTest5 {

    public static int[] makeNumber() {
        // 1, 10, 11, 42, 34, 25 처럼 6자리 반환
        Random random = new Random();
        int[] numbers = new int[6];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(45) + 1;
        }
        return numbers;
    } // end of makeNumber

    public static void main(String[] args) {
        int[] lotto = makeNumber();
        for (int i = 0; i < lotto.length; i++) {
            System.out.print(lotto[i] + "\t");
        }

        // 초기화 for 문
        // for(int a : lotto){} : 처음부터 끝까지 전부 출력하는 경우에 사용

    } // end of main
}
