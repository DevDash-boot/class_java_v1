package com.oop2;

public class FunctionTest2 {
    // 세개의 수를 입력받아 뺄셈하는 함수를 설계하고 그 값을 반환하는 함수 생성
    // 함수 설계
    static int sub(int n1, int n2, int n3) {
        int result = n1 - n2 - n3;
        return result;  // return : 값을 반환
    }

    // 리턴 키워드가 없는 함수
    // void : 텅 빈, 값이 없는
    static void sayHello(String greeting) {
        System.out.println("[[[" + greeting + "]]]🖐️🖐️");
    }

    // 매개 변수가 없는 함수 설계
    static int calcSum() {
        // 지역 변수는 가능한 초기값을 먼저 할당하자
        int sum = 0, i;
        for (i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    // 함수 사용하기 (모양 맞추기)
    public static void main(String[] args) {
        int num1 = 151, num2 = 20;
        // 인수: 함수 호출 시 들어가는 값
        int result1 = sub(num1, num2, 53);
        sayHello("안녕 함수야 반가워");
        sayHello("안녕~️ 홍길동");
        int result2 = calcSum();

        System.out.println("결과: " + result1);
        System.out.println("결과: " + result2);

    }
}
