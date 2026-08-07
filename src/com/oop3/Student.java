package com.oop3;

public class Student {

    // 속성(필드)
    int studentID;
    String name;
    String address;

    // 행위(method)
    void study(){
        System.out.println(name +" 학생이 공부를 합니다.");
    }

    void breakTime(){
        System.out.println(name+ " 학생이 휴식을 합니다.");
    }

    void showInfo(){
        System.out.println("====== 상태창 ======");
        System.out.println("학생 ID: " + studentID);
        System.out.println("학생 이름: " + name);
        System.out.println("학생 주소: " + address);
    }

    void test(){
        System.out.println(name + " 학생이 시험을 친다.");
    }
    void cleaning(){
        System.out.println(name + " 학생이 청소를 한다.");
    }

}
