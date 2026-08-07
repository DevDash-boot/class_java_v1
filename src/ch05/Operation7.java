package ch05;

/*
 * 빠른 평가란?
 * 논리 연산에서 첫 번째 조건이 결과를 결정하는 경우 두 번째 조건을 평가하지 않는 것
 */

public class Operation7 {
    public static void main(String[] args) {
        int num = 5, index = 0;

        // 논리곱(&&)을 이용한 빠른 평가
        boolean result1 = ((num += 10) < 10) && ((index += 2) < 10);
        System.out.println("num = " + num); // 15
        // 첫 항의 조건이 true이기 때문에 뒤 항의 조건은 실행되지 않음
        System.out.println("index = " + index); // 0
        System.out.println("논리곱 결과 = " + result1); // false
        System.out.println("--------------------");

        // 논리합(||)을 이용한 빠른 평가
        // num은 위에서 연산했기 때문에 현재 15 이다.
        // index는 위에서 빠른 평가로 진행했기 때문에 현재 0 이다.
        //boolean result2 = ((num += 10) < 10) || ((index += 2) < 10);
        boolean result2 = ((num += 10) > 10) || ((index += 2) < 10);
        System.out.println("num = " + num); // 25
        System.out.println("index = " + index); // 0
        System.out.println("논리합 결과 = " + result2); // true

        // 빠른 평가 수식을 만들어 보고 결과를 확인하는 코드
        float a = 5.2f, b = 13.5f;
        boolean r3 = ((a *= 2) > 10 && ((b /= 3) < 4));
        System.out.println("--------------------");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("논리곱 결과 = " + r3);
        boolean r4 = ((a *= 2) > 10 || ((b /= 3) < 4));
        System.out.println("--------------------");
        System.out.println("a = " + a + ", b = " + b); // 빠른 평가로 b 실행 안됨
        System.out.println("논리합 결과 = " + r4);

    }  // end of main

}   // end of class
