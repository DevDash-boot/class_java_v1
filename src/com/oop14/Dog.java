package com.oop14;

public class Dog extends Animal{

    @Override
    void eat() {
        super.eat();    // 부모 메서드 호출 후 자식 메서드 실행
        System.out.println("강아지가 밥을 먹다");
    }
}
