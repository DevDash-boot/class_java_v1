package com.oop4;

public class MainTest2 {
    public static void main(String[] args) {
        // Bus 클래스의 사용자 정의 생성자 2개를 이용해서 객체를 메모리에 직접 올려보자.
        Bus b1 = new Bus(12);
        Bus b2 = new Bus(87, 1000);
        b1.showInfo();
        b2.showInfo();

    }
}
