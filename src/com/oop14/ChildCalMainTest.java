package com.oop14;

public class ChildCalMainTest {
    public static void main(String[] args) {
        ChildCal childCal = new ChildCal();
        System.out.println(childCal.add(10,10));
        System.out.println(childCal.mul(10,0)); // 오버라이드된 메서드
        System.out.println(childCal.sub(100,1));

        // 곱하기 기능에 n1과 n2에 0이 들어온다면 0을 입력하지 마시오.
        // 코드 수정 요청이 들어옴

        // 메서드 오버라이드 활용


    }
}
