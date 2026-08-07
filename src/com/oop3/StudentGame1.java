package com.oop3;

public class StudentGame1 {
    public static void main(String[] args) {
        // 1. 객체 생성
        Student s1 = new Student();

        // 2. 참조 변수를 사용해서 객체에 접근하고 값 할당
        s1.studentID = 1;
        s1.name = "티모";
        s1.address = "탑";

        // 3. 생성된 객체의 동작을 호출
        s1.study();
        s1.breakTime();
        s1.test();
        s1.cleaning();
        s1.showInfo();
        System.out.println("-------------------");

        // 메서드: 객체의 기능을 구현하기 위해 해당 클래스 내부에 구현되는 함수
        // 메서드는 함수와 다르게 멤버 변수를 활용해서 기능을 구현

        Student s2 = new Student();
        s2.studentID = 2;
        s2.name = "전사";
        s2.address = "미드";
        s2.test();
        s2.cleaning();
        s2.showInfo();
    }
}
// 메서드

