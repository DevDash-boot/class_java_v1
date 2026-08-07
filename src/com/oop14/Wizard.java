package com.oop14;

public class Wizard extends Hero {
    public Wizard(String name, int hp) {
        super(name, hp);
    }

    void freezing() {
        System.out.println(name + " 얼음 공격을 합니다.");

    }
}
