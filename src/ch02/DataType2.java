package ch02;

/**
 * 문자 데이터 타입
 * char 자료형 크기는 2byte 입니다.
 */

public class DataType2 {

    // 메인 함수
    public static void main(String[] args) {

        // 기본 자료형 - 문자타입(사실은 정수형으로 저장되어 있다.)
        // 문자를 저장할 때 사용한다
        // 단 하나의 문자만을 저장할 수 있다.
        char charBox = '가';
        System.out.println(charBox);

        System.out.println('A');
        System.out.println('B');
        System.out.println('C');

        System.out.println("----------------------------");
        char alphabetA = 'A';  // [][][][] <-- 65 저장됨
        System.out.println(alphabetA);  // A
        System.out.println((int)alphabetA); // 65
        System.out.println((int)'K'); // 75
        // char alphabetB = "B"; " "(쌍따옴표)는 문자가 아닌 문자열을 표현할 때 사용한다.

        // 고민1. 문자도 사실 정수형이라고 했으나 왜 화면에는 문자 형태로 출력이 되는걸까?
        // 이유는 문자표가 이미 컴퓨터 내부에 저장되어 있다.

    } // end of main

} // end of class
