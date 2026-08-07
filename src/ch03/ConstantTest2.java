package ch03;

public class ConstantTest2 {

    // 코드 실행의 시작점
    public static void main(String[] args) {
        // 도전과제: 상수를 사용해서 값을 화면에 출력

        final int MAX_SCORE = 100;

        int score = 80;
        System.out.println("내 점수: " + score);
        System.out.println("만점: " + MAX_SCORE);

        if(score==MAX_SCORE)
            System.out.println(("만점입니다."));
        else if (score>=90)
            System.out.println("학점: A");
        else if(score>=80)
            System.out.println("학점: B");
        else if(score>=70)
            System.out.println("학점: C");
        else if(score>=60)
            System.out.println("학점: D");
        else
            System.out.println("과락입니다.");




    } // end of main

} // end of class
