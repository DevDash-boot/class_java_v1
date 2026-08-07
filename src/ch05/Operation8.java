package ch05;

/*
 * 조건 연산자(삼항 연산자)
 * 조건식 ? 결과 1 : 결과 2
 * 조건식에 결과값이 true이면 결과 1을 반환, 아니라면 결과 2를 반환
 */

public class Operation8 {
    public static void main(String[] args) {

        int num = 7; // 7이라는 값이 홀수 인지 짝수 인지 판별
        // 조건식
        char r1 = (num % 2 == 0) ? '짝' : '홀';
        System.out.println("결과는 : " + r1);

        boolean isOk = (5 > 3) ? true : false;
        System.out.println("isOk : " + isOk);

        // 두 정수 중에 큰 수를 max라는 변수에 담기
        int max = (10 > 1) ? 10 : 1;
        System.out.println("max : " + max);

        int n1 = 100, n2 = 300, max2;
        max2 = (n1 > n2) ? n1 : n2;
        System.out.println("max2 : " + max2);

    }  // end of main

}   // end of class
