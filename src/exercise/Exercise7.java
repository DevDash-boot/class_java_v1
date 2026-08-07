package exercise;

public class Exercise7 {
    // 함수 만들기 1. 인사말 출력
    static void greet(String greeting) {
        System.out.println("안녕하세요, " + greeting + "님!🖐️🖐️");
    }

    // 함수 만들기 2. 제곱 계산
    static int square(int n1) {
        int result = n1 * n1;
        return result;
    }

    // 함수 만들기 3. 부호 판별
    static String signOfNumber(int num) {
        if (num > 0)
            return "positive";
        else if (num < 0)
            return "negative";
        else
            return "zero";
    }

    // 함수 만들기 4. 나이 확인
    static Boolean checkAdult(int age) {
        if (age >= 18)
            return true;
        else
            return false;
    }

    // 함수 만들기 5. 최대값 찾기
    static int findMax(int a, int b) {
        if (a > b)
            return a;
        else if(a<b)
            return b;
        else
            System.out.println("값을 다르게 입력해주세요.");
        return a;
    }

    public static void main(String[] args) {
        // 1
        greet("홍길동");
        System.out.println("---------------------");

        // 2
        System.out.println("제곱: " + square(10));
        System.out.println("제곱: " + square(-6));
        System.out.println("---------------------");

        // 3
        System.out.println(signOfNumber(12));
        System.out.println(signOfNumber(0));
        System.out.println(signOfNumber(-8));
        System.out.println("---------------------");

        // 4
        System.out.println(checkAdult(25));
        System.out.println(checkAdult(13));
        System.out.println("---------------------");

        // 5
        System.out.println("큰 값: " + findMax(123, 65));
        System.out.println("큰 값: " + findMax(13, 64));
        System.out.println("큰 값: " + findMax(5, 5));
    }

}
