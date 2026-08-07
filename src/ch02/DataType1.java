package ch02;

/**
 * 데이터 타입이란?
 * 변수라는 상자에 담을 수 있는 값의 종류와 크기를 지정하는 것
 * 상자의 크기에 따라서 담을 수 있는 값의 범위가 달라짐
 *
 * 자바에서는 데이터 타입을 가장 큰 분류로 딱 2가지로 구분한다
 *      1. 기본 자료형(Primitive Data Type)
 *          --> 정수형, 문자형, 실수형, 논리형
 *      2. 참조 자료형(Reference Data Type)
 */
public class DataType1 {

    // 메인 함수(코드 실행의 시작점)
    public static void main(String[] args) {
        // 정수형 : 정수는 소수점 이하를 포함하지 않는 숫자를 의미

        byte byteBox; // 1바이트 = 8비트
        short shortBox; // 2바이트 = 16비트
        int intBox; // 4바이트(정수형 데이터 파일의 기본 타입) = 32비트
        long longBox; // 8바이트 = 64비트

        // 컴퓨터는 데이터를 이진수로 표현한다. 즉, 0과 1로만 데이터를 표현한다.

        byteBox = -128;
        byteBox = 127;

        shortBox = -32768;
        shortBox = 32767;

        // 약 21억
        intBox = -2147483648;
        intBox = 2147483647;

        // 약 9경
        longBox = -9L;  // long타입을 표현할 때 접미사를 사용(L, l) 대소문자 구분 X
        longBox = 9L;

        // L value = R value
        // 보통 오른쪽에 기술되는 수의 기본 단위는 4바이트 크기인 int형으로 먼저 인지한다.
        // long 을 사용하고 싶다면 접미사 L 을 사용해야 한다.

    }   // end of main
} // end of class
