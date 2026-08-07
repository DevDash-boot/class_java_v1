package com.oop15;

public class Student {

    private String studentID;
    private String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void showInfo(){
        System.out.print("학번: " + studentID + ", 이름: " + name);
    }
}
