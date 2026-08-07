package com.oop14;

public class CMainTest {
    public static void main(String[] args) {
        C c = new C();

        // 물려받기는 하지만 접근 제어 지시자에 따라
        // 접근을 할 수 있거나 못할 수 있다.
        c.name = "CCCCC";
        c.age = 10;
        c.height = 120;
        c.weight = 35;
        c.level = 2;
        c.nickName = "C";

        System.out.println(c.age);
        System.out.println(c.height);
        System.out.println(c.weight);

    }
}
