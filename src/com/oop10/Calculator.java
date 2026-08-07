package com.oop10;

import java.util.Random;

public class Calculator {

    // 일반 인스턴스 메서드(객체를 생성해야 사용 가능)
    // static 메서드로 만드는 것이 권장됨
    public int multiply(int n1, int n2) {
        return n1 * n2;
    }

    // static 메서드(객체 생성 없이도 '클래스이름.메서드이름()' 사용 가능)
    // 객체마다 결과가 달라질 이유가 없으므로 static 함수가 적합하다.
    public static int add(int n1, int n2) {
        return n1 + n2;
    }

    // 사실 우리는 이미 static을 사용하고 있었다.
    public static void main(String[] args) {
        System.out.println("여기에서 별도로 main함수 실행 가능");
        // 클래스이름.메서드이름();
        // 가능한 이유: static 메모리 영역에 위치하고 실행시킬 수 있다.
        System.out.println(Calculator.add(2, 3));

        // 자바 표준 API 사용해보기
        // 1. 클래스이름.메서드 라서 static 메서드이다,(굳이 객체를 생성할 필요가 없다)
        double ran = Math.random();
        System.out.println("ran: " + ran);

        // 자바 표준 API - Random 사용해보기
        Random random = new Random();

        int ranInt = random.nextInt();
        System.out.println("ranInt: " + ranInt);

        // 45까지 범위 지정
        int lottoNumber1 = random.nextInt(45); // 0 ~ 44까지 난수값 하나 발생
        int lottoNumber2 = random.nextInt(45) + 1; // 1 ~ 45까지 난수값 하나 발생
        System.out.println(lottoNumber2);

    } // end of main
}
