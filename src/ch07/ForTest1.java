package ch07;

public class ForTest1 {

    public static void main(String[] args) {
        // 반복문 - 반복적인 패턴이 보인다면 반복문을 생각해보자.
        // 구구단
        int i, j;
        for (i = 1; i < 10; i++) {
            for (j = 1; j < 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println();
        }

    } // end of main

}   // end of class
