package com.oop8;

public class Person {

    // this 의 3가지 사용 방법
    // 1. 자기자신의 주소를 가리킨다.
    // 2. 생성자에서 다른 생성자를 호출할 수 있다.
    // 3. 자기 자신의 주소값을 리턴값으로 반환시킬 수 있다.

    private String name;
    private int age;
    private String phone;
    private String gender; // F, M

    // 생성자 - 1. this 사용 방법 첫 번째
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 생성자 - 2. this 사용 방법 두 번째
    // 생성자 매개변수 개수를 확인하고, 데이터 타입을 확인하여 같은지 확인한다.
    public Person(String name, int age, String phone) {
        // this.name = name;
        // this.age = age;

        // this() 생성자가 만들어져 있어야 호출 가능
        // this.name = name, this.age = age 반복 사용을 this(name, age)로 줄일 수 있다.
        this(name, age);
        this.phone = phone;
    }

    // 생성자 - 2_1. this 사용 방법 두 번째 복습
    // 순서 : 2_1 -> 2 -> 1 -> 2 -> 2_1 순서로 this()를 처리하고 다시 원래 있던 곳으로 돌아온다.
    public Person(String name, int age, String phone, String gender) {
        this(name, age, phone);
        this.gender = gender;
    }

    // this 사용 방법 세 번째
    // 메서드를 통해서 자기 자신의 주소값을 반환시켜야 하는 경우 this 사용 할 수 있다.
    public Person getPerson() {
        return this;
    }

}   // end of class
