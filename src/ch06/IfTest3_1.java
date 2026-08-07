package ch06;

// import: 수입하다, 가지고 오다.
import java.util.Scanner;

public class IfTest3_1 {
    public static void main(String[] args) {

        // 키보드에서 값을 입력받을 수 있는 도구 사용
        Scanner sc = new Scanner(System.in);
        System.out.println("나이를 입력하세요.");

        int age = sc.nextInt();

        if (age <=7){
            System.out.println("아직 학교에 다니지 않았습니다.");
        } else if (age<=13) {
            System.out.println("초등학생");
        } else if (age<=16) {
            System.out.println("중학생");
        } else if (age<=19) {
            System.out.println("고등학생");
        }else {
            System.out.println("성인");
        }
        System.out.println("프로그램을 종료합니다.");

    } // end of main
} // end of class
