package com.oop19;
// class 앞에 final이 작성되어 있으면 상속 불가
public abstract class Car {

    private void startCar() {
        System.out.println("시동을 켭니다.");
    }

    private void trunOff() {
        System.out.println("시동을 끕니다.");
    }

    protected abstract void drive();
    protected abstract void stop();

    // 핵심 :  이 메서드를 탬플릿 메서드로 설계하겠다.
    // 실행의 흐름이 미리 정의되어 있다.
    // 반드시 final 키워드를 선언해준다.
    // 변수에 final을 사용하면 상수가 된다.
    // 메서드에 final을 정의하면 재정의 불가(오버라이드 불가)
    final public void run() {
        startCar(); // 1. 시동 걸기
        drive();    // 2. 운전하기
        stop();     // 3. 정지하기
        trunOff();  // 4. 시동 끄기
    }

}
