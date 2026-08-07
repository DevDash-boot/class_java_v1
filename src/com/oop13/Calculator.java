package com.oop13;

// 메서드 오버로딩: 같은 이름의 메서드를 여러개 정의하는 것

public class Calculator {
    // 정수형 덧셈 메서드
    public int add(int a, int b) {
        return a + b;
    }

    // 실수형 덧셈 메서드
    public double add(double a, double b) {
        return a + b;
    }

    // 세 정수의 덧셈 메서드
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        // println도 메서드 오버로딩 기법이다.
        System.out.println(1);
        System.out.println(1.0);
        System.out.println(true);
        System.out.println("String");
        System.out.println('c');
        System.out.println((1.0 + 1));  // ( ) 연산 후 double로 들어감

        // 메소드 오버로딩 기법이 없다면 아마 이렇게 호출해야 되었을 것
        // printlnInt(), printlnDouble(), printlnBoolean, printlnString()
    }
}
