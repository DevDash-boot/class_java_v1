package com.oop15;

public class Car {
    private String name;
    private Engine engine;  // 필드로 들어감. 합성관계 조건 1과 관련

    public Car(String name){
        this.name = name;
        // 합성의 조건 1. 밖에서 참조값을 받지 않고 생성자에서 직접 객체를 생성한다.
        // 즉, Car 객체가 태어날 때 Engine 객체도 함께 태어난다.
        this.engine = new Engine("v8");
    }

    // 합성의 조건 2. getEngine()을 만들지 않는다.
    // 내부의 Engine 객체를 밖으로 꺼내지 않겠다는 뜻

    public void start(){
        engine.start(); // 엔진에 시동이 걸려야 한다.
        System.out.println(name + "가 출발합니다.");
    }
    public void stop(){
        engine.stop();
        System.out.println(name + "가 정지합니다.");
    }

}
