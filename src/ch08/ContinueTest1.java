package ch08;

public class ContinueTest1 {

    public static void main(String[] args) {

        // 중간에 멈추는 continue
        // 1부터 10까지 짝수는 건너뛰고 홀수만 출력

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }


    } // end of main

} // end of class
