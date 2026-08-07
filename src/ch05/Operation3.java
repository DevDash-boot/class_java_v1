package ch05;

/*
 * 복합 대입 연산자: 대입 연산자와 다른 연산자가 함께 쓰이는 것
 */
public class Operation3 {
    public static void main(String[] args) {
        int n1 = 100;
        n1 += 1;  // n1 = n1 + 1;
        System.out.println("----------------");

        // 시작값 설정
        int score = 0;

        // 1. 점수 추가
        score += 6; // 복합 대입 연산자
        System.out.println("점수 6점 추가. " + "현재 점수: " + score);

        // 2. 점수 감점
        score -= 4;
        System.out.println("점수 4점 감점. " + "현재 점수: " + score);

        // 3. 점수 15배 증가
        score *= 15;
        System.out.println("점수 3배 증가. " + "현재 점수: " + score);

        // 4. 점수 반으로 감소
        score /= 2;
        System.out.println("점수 반으로 감소. " + "현재 점수: " + score);

        // 3. 점수 나머지
        score %= 2;
        System.out.println("점수 나머지 연산. " + "현재 점수: " + score);

    }  // end of main

}   // end of class
