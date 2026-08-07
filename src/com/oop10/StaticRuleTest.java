package com.oop10;

public class StaticRuleTest {

    private String version = "1.0.0"; // 인스턴스 변수
    private static String appName = "로또 번호 생성기"; // static 변수

    // 인스턴스 메서드
    public String getVersion(){
        System.out.println(appName);
        System.out.println(version);
        System.out.println(makeMessage()); // static는 원래 존재하는 것이어서 실행이 된다.
        return version;
    }

    // static 메서드
    public static String makeMessage(){
        System.out.println(appName); // static 변수

        // 불가능
        // 이유: 아직 객체가 생성되지 않은 상태일 수 있기 때문에 사용 못하게 막는다.
        // System.out.println(version); // 인스턴스 변수
        // System.out.println(getVresion());
        // System.out.println(this);

        return appName + "입니다.";
    }
}
