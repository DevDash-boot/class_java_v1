package ch03;

/*
 * 형변환이란?
 * 데이터의 타입을 다른 타입으로 변경하는 것
 * 자동 형변환과 강제 형변환이 있다.
 */
public class TypeConversion1 {
    // 코드 실행의 시작점
    public static void main(String[] args) {
        int intDataBox = 100;
        double doubleDataBox;

        // 1. 자동 형변환 예시
        // 8byte 상자 = 4byte 상자
        doubleDataBox = intDataBox; // 자동 형변환을 진행 함
        System.out.println("doubleDataBox : " + doubleDataBox);

        // 2. 강제 형변환 예시
        final double PI = 3.141592;
        // 컴파일러가 강제로 삽입하게 하는 명령어 (자료형)변수
        int intBox = (int)PI;
        System.out.println("intBox : " + intBox);   // 데이터 손실 발생

        // 연습
        double interestRate = 15.5;
        int discount;
        discount = (int)interestRate;

        System.out.println("discount : " + discount);

        float flatBox = (float)10.5; // 10.5f도 가능

    } //end of main
}  // end of class
