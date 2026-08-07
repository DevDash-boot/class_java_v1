package com.oop16;

public class AnimalTest1 {

    public static void main(String[] args) {

        // 1. 자기 타입으로 바라보기
        Animal animal1 = new Animal();
        animal1.move();
        animal1.eating();
        System.out.println("------------------");

        // 다형성
        // 2. 부모 타입으로 자식 객체 바라보기(업캐스팅)
        Animal animal2 = (Animal) new Tiger();  // 업캐스팅된 상태 - (Animal) 생략 가능
        // Animal animal2 = (Animal) new Human(): 사용 시 ClassCastException 에러가 발생
        // 다운캐스팅이 안전하지 않은 이유: 실제 객체가 그 자식 타입이 아닐 수도 있기 때문

        animal2.move();
        animal2.eating();

        // 3. 다운캐스팅 작성
        Tiger tiger = (Tiger) animal2;  // 강제 형 변환
        tiger.hunting();

        System.out.println("------------------");

        // 2-1. 부모 타입으로 자식 객체 바라보기(업캐스팅)
        Animal animal3 = new Human();
        animal3.move();
        animal3.eating();

        // 3-1. 문제 확인
        // Human 객체에는 readBook() 메서드가 호출이 될까?
        // animal3.readBook()   --> 에러 발생: 실제 객체 Human이 맞지만 컴파일 시점에 readBook()을 호출할 수 없음
        // 이유: 현재 부모타입으로 바라보고 있기 때문에

        // 컴파일 시점에는 타입만 바라보고, 런타임 시점에는 실제 동작하는 객체의 행위가 실행된다.
        Human human = (Human) animal3;
        human.readBook();
    } // end of main
} // emd of class
