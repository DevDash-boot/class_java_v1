package com.oop11;

public class ArrayTest3 {
    public static void main(String[] args) {
        char[] alphabets = new char[26];
        char ch1 = 'A';
        alphabets[0] = ch1;

        char ch2 = 'B';
        alphabets[1] = ch2;

        char ch3 = 'C';
        alphabets[2] = ch3;

        char ch26 = 'Z';
        alphabets[25] = ch26;

//        System.out.print(alphabets[0] + " ");
//        System.out.print(alphabets[1] + " ");
//        System.out.print(alphabets[2] + " ");
//        System.out.println(alphabets[25] + " ");

        // 배열은 반복문과 함께 많이 사용된다.
        for (int i = 0; i < alphabets.length; i++) {
            System.out.print(alphabets[i] + " ");
        }

    }
}
