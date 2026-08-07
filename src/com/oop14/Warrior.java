package com.oop14;

public class Warrior extends Hero {

    Warrior(String name, int hp) {
        // 부ㅋ모 클래스의 사용자 정의 생정자가 있다면 반드시 부모 생성자를 호출해야 사용할 수 있다.
        super(name, hp);    // super - 부모를 호출할 때 사용
    }

    void comboAttack() {
        System.out.println(name + " 콤보 공격을 합니다.");
    }
}
