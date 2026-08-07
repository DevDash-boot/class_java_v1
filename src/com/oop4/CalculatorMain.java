package com.oop4;

public class CalculatorMain {
    // 함수
    // 1. 두 숫자를 더하는 함수
    static int add(int n1, int n2) {
        return n1 + n2;
    }

    // 2. 두 숫자를  빼는 함수
    static int sub(int n1, int n2) {
        return n1 - n2;
    }

    // 3. 두 숫자를 곱하는 함수
    static int mul(int n1, int n2) {
        return n1 * n2;
    }

    // 4. 두 숫자를 나누는 함수
    static double div(int n1, int n2) {
        // 방어적 코드
        if (n2 == 0) {
            System.out.println("0으로 나눌수 없습니다.");
            return 0;
        }
        // 둘 중 하나라도 실수 데이터 타입이어야 소수점을 반환한다.
        return (double) n1 / n2;
    }

    // 5. 짝수 판별 함수
    static String even(int n1) {
        return n1 % 2 == 0 ? "네" : "아니오";
    }

    // 6. 홀수 판별 함수
    static String odd(int n1) {
        return n1 % 2 != 0 ? "네" : "아니오";
    }

    public static void main(String[] args) {
        int a = 9, b= 4;

        System.out.println("두 수 더하기: " + add(a, b));
        System.out.println("두 수 빼기: " + sub(a, b));
        System.out.println("두 수 곱하기: " + mul(a, b));
        System.out.println("두 수 나누기: " + div(a, b));
        System.out.println(a + "는 짝수인가요?: " + even(a));
        System.out.println(b + "는 짝수인가요?: " + even(b));
        System.out.println(a + "는 홀수인가요?: " + odd(a));
        System.out.println(b + "는 홀수인가요?: " + odd(b));
    }

}
