package com.oop18.Abstract;

public abstract class Computer {

    // 추상 클래스(Abstract Class)
    // class 앞에 abstract 키워드가 있거나 하나 이상의 추상 메서드를 가지는 클래스

    // 추상 메서드 -> 메서드 선언부만 존재하는 녀석
    // 추상 메서드가 단 하나라도 존재한다면 그 클래스는 추상 클래스여야 한다. - 강제성

    // 추상 클래스는 직접 객채로 생성할 수 없다.
    // Animal animal = new Animal(); 제약 사항 - 직접 new 키워드를 사용할 수 없다.

    // Animal 에는 추상 메서드가 존재하고 있다. new 사용 불가
    // 부모의 모든 것을 물려 받았기 때문에 추상 메서드를 가지는 형태가 된다.
    // 추상 메서드를 일반 구현 메서드로 재정의하면 추상 메서드가 Human에서 사라지게 된다.

    public abstract void display();

    public abstract void typing();

    public void trunOn() {
        System.out.println("전원을 켭니다.");
    }

    public void trunOff() {
        System.out.println("전원을 끕니다.");
    }
}
