package com.oop16;
// 상속 + 재정의
public class Tiger extends Animal {

    // 어노케이션 = 주석 + 힌트
    @Override
    public void move() {
        System.out.println("호랑이가 살금살금 움직입니다.");
    }

    public void hunting() {
        System.out.println("호랑이가 뒤에서 사냥을 합니다.");
    }
}
