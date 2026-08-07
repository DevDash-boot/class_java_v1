package exercise;

public class Exercise3 {

    // 메인 함수(코드 실행의 시작점)
    public static void main(String[] args) {
        // 할인된 가격을 화면에 출력하는 코드 작성

        final double ORIGINAL_PRICE = 59.99;
        final double DISCOUNT_RATE = 0.3; //30%할인
        // 할인 계산식을 찾아서 준비
        // DISCOUNT_RATE는 추후 변경될 수 있다.

        // 방식 1. 할인 금액을 먼저 구해서 원본 금액에서 빼기
        double result1 = ORIGINAL_PRICE * DISCOUNT_RATE; // 할인 금액
        double result2 = ORIGINAL_PRICE - result1; // 최종 금액

        // 방식 2. 남는 비용(1-할인율)을 한 번에 곱하기
        // double result2 = ORIGINAL_PRICE * (1-DISCOUNT_RATE);

        // 할인된 계산 금액을 변수에 담아서 화면에 정수값으로 출력
        System.out.println("할인 금액 : " + (int)result1);

        // 할인 후 금액
        System.out.println("최종 금액: " + (int)result2);

    } //end of main

} //end of class
