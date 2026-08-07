package com.oop15;

public class SchoolMainTest {

    public static void main(String[] args) {
        School school = new School("서울대학교", 5);
        Student s1 = new Student("0123456", "김철수");



        s1.showInfo();

    }

    private static int getSize() {
        return 5;
    }


}
