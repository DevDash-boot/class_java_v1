package ch08;

import java.util.Scanner;

public class MenuChoice4 {

    public static void main(String[] args) {
        // Scanner 활용 - 문자열로 값 받기
        Scanner sc = new Scanner(System.in);

        int menuNum = sc.nextInt();
        // nextInt는 정수값만 가지고 가고, 개행 문자(\n)는 남겨둔다.
        // 남겨진 개행 문자(\n)을 소비해주면 된다.
        sc.nextLine(); // 개행 문자 소비
        String name = sc.nextLine();    // 문자열 입력

        System.out.println("menuNum: " + menuNum);
        System.out.println("name: " + name);

    } // end of main

} // end of class
