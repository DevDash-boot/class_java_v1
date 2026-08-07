package com.oop4;

public class MainTest1 {
    public static void main(String[] args) {
        Student s1 = new Student(1, "빨간 망토", 2);
        s1.showInfo();
        // Student s1 = new Student(); 기본 생성자를 사용해서 객체가 생성됨
        // 단 하나의 사용자 정의 생성자를 만들었다면 기본 생성자는 자동으로 생성되지 않는다.
    }
}
