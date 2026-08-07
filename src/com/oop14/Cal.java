package com.oop14;

public class Cal {
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public int mul(int n1, int n2) {
        return n1 * n2;
    }
}
// xxx.java - 하나의 자바 파일에 여러개의 클래스를 선언할 수 있다.
// 단, 권장하지는 않음
// 주의점: 단, 하나의 자바 파일에서 public 클래스는 하나만 선언할 수 있다.

class ChildCal extends Cal{
    public int sub(int n1, int n2){
        return n1 - n2;
    }

    // 부모 클래스의 메서드를 재정의 할 수 있다. -> 오버라이드
    @Override   // 어노테이션: 컴파일러에게 알려주는 주석
    public int mul(int n1, int n2) {
        System.out.println("Child의 mul() 호출");
        if(n1 == 0 || n2 == 0){
            System.out.println("0으로 입력하지 마세요.");
        }
        return n1 * n2;
    }
}
