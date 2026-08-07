package com.oop20;

// 키워드가 class 가 아닌 interface
public interface RemoteControl {

    // 1. 인터페이스 안에 선언된 필드는 자동으로 public static final이 붇는다. 즉, 상수가 된다.
    int MAX_VOLUME = 10;    // 여기 코드는 생략되어 있음
    // public static final int MAX_VOLUME = 10;

    // 2. 인터페이스 안에 선언되는 메서드는 자바 8 버전 default 제외하고 전부 추상 메서드로 설계되어야 한다.

    void turnOn();  // 자동으로 public abstract가 붙는다.

    public abstract void turnOff(); // 생략되기 전

    void setVolume(int volume);
}
