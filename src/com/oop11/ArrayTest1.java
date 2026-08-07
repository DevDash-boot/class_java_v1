package com.oop11;

import com.oop6.Bank;

import java.util.Arrays;

public class ArrayTest1 {
    public static void main(String[] args) {
        // 배열 Array: 연관된 데이터를 모아서 통으로 고나리하기 위한 데이터 타입
        // 변수가 하나의 데이터를 저장하기 위한 것이라면,
        // 배열은 여러개의 데이터를 하나의 변수에 저장하기 위한 것

        // 배열 사용방법 1
        int[] intArr1 = new int[3]; // 많이 쓰는 형식
        int intArr2[] = new int[3];
        // 배열을 선언하면서 동시에 생성할 경우에는 배열의 길이(크기)를 반드시 지정해야 한다.

        intArr1[0] = 10;
        intArr1[1] = 20;
        intArr1[2] = 30;
        // intArr1[3] = 40;  오류 발생! 배열의 길이를 벗어남

        // 배열 사용방법 2
        // 배열 선언과 동시에 값 초기화
        int[] gradArray = new int[]{1, 2, 3};   // [1][2][3]
        int[] gradArray2 = {2, 3, 4}; // new int[] 생략 가능  [2][3][4]

        // 5개의 길이를 가지는 double 타입의 배열 선언
        double[] dArr1 = new double[5]; // [][][][][]
        dArr1[0] = 0.1; // [0.1][][][][]
        dArr1[1] = 0.2; // [0.1][0.2][][][]

        // tip. 배열의 길이와 인덱스의 크기는 다르다.
        // 인덱스의 크기는 n-1이다. 0부터 시작
        // 배열의 길이가 30, 인덱스의 크기는 29

        // 문제1. char 배열 길이 3개 선언해서 초기화
        char[] cArr1 = new char[]{'a', 'b', 'c'};
        char[] cArr2 = {'안', '녕', '하', '세', '요'};
        String[] sArr1 = {"안녕하세요", "반갑습니다."};

        // 문제2. boolean 배열 3개 선언해서 초기화
        boolean[] bArr1 = new boolean[]{true, true, false};
        boolean[] bArr2 = {false, false, true};
        boolean[] bArr3 = new boolean[2];
        bArr3[0] = true;
        bArr3[1] = false;

        System.out.println(Arrays.toString(intArr1));
        System.out.println(Arrays.toString(intArr2));
        System.out.println(Arrays.toString(cArr1));
        System.out.println(Arrays.toString(cArr2));
        System.out.println(Arrays.toString(sArr1));
        System.out.println(Arrays.toString(bArr1));
        System.out.println(Arrays.toString(bArr2));
        System.out.println(Arrays.toString(bArr3));

    }
}
