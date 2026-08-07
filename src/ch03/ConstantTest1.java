package ch03;

public class ConstantTest1 {

    // 코드 실행의 시작점
    public static void main(String[] args) {
        int num = 10;
        num = 101;

        // 상수 사용
        // final 키워드를 사용하고 변수명에 이름을 작성할 때 대문자_(언더바)를 사용하는게 권장 사항이다.
        final int MAX_NUM = 100;    // 한 번 값이 정해지면 변경할 수 없다.(상수)
        // int MAX_NUM = 1;

        // 원주율을 상수로 선언해보자
        final double PI = 3.141592;

        // 반지름이 5인 원의 둘레를 구하는 공식 - 둘레 = 2πr
        final int RADIUS = 5;
        double perimeter = 2 * PI * RADIUS; // 둘레 변수 선언
        System.out.println("원의 둘레 = " + perimeter);

        // 반지름이 5인 원의 면적을 구하는 공식 -  넓이 = πr^2
        double area = PI * RADIUS * RADIUS;  // 면적 변수 선언
        System.out.println("원의 넓이 = " + area);


    } // end of main

} // end of class
