package ch08;

public class BreakTest1 {

    public static void main(String[] args) {
        // 중간에 멈추는 break 구문
        // 만약 i 값이 7과 같다면 멈추는 코드
        for (int i = 0; i < 10; i++) {
            System.out.println("i: " + i);
            if (i == 7) {
                break;
            }
        }
        System.out.println("-------------");

        // 1. 100 ~ 200 까지 화면에 출력하는 코드를 작성
        // 2. 단, 151에 도달했다면 반복문을 멈추는 코드를 작성
        // 3. while 구문을 사용해서 코드를 작성
        int j=100;
        while (j <= 200) {
            System.out.println("j: " + j);
            j++; // i 값을 1씩 증가
            if (j == 151) {  // i 값이 151에 도달했다면 멈춤
                break;
            }
        }

    } // end of main

} // end of class
