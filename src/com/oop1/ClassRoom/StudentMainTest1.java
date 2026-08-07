package com.oop1.ClassRoom;

public class StudentMainTest1 {

    public static void main(String[] args) {
        // 내가 설계한 클래스를 메모리에 직접 올려보자.
        // JVM(자바 가상 머신) 메모리에 올릴 수 있다.

        // JVM 내부 heap영역에 s1, s2 할당
        Student s1 = new Student(); // 클래스를 메모리에 올려라.(인스턴스화)
        Student s2 = new Student();

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        int grade = 10;
        double height = 1.1;

        System.out.println("grade: " + grade);
        System.out.println("height: " + height);

        // 자바 변수는 크게 2가지가 존재
        // 기본 변수 : 실제 값이 담겨진다.
        // 참조 변수 : 변수에 실제 값이 아니라 주소값이 담긴다.

    } // end of main
} // end of class
