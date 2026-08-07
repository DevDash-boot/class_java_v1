package ch03;

public class ConstantTest3 {

    // 코드 실행의 시작점
    public static void main(String[] args) {
        // 사각형의 면적을 구하는 코드 작성 - 상수 활용
        final int WIDTH = 5, LENGTH = 6;    // WIDTH = 가로, LENGTH = 세로
        int area; // 면적 area의 변수 선언

        area = WIDTH * LENGTH; // 사각형의 면적 = 가로 * 세로
        System.out.println("사각형의 면적 = " + area);

        // 사각형의 부피
        final int HEIGHT = 9; // HEIGHT = 높이
        int area1 = WIDTH * LENGTH * HEIGHT; // 부피 area1의 변수 선언
        System.out.println("사각형의 부피 = " + area1);

    } // end of main

} // end of class
