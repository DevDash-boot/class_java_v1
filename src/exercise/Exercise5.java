package exercise;

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        // 요구 사항을 확인하고 프로그램을 작성해보자
        //1. 사용자로부터 성적을 입력받기 위해 Scanner 클래스를 사용하세요.
        //2. 입력 받은 성적을 기반으로 학점을 계산하고, 해당하는 메시지를 출력하세요.
        //3. 모든 입력과 계산, 출력은 main 메소드 내에서 이루어져야 합니다.
        //4. 입력 받은 성적이 범위를 벗어날 경우, 적절한 안내 메시지를 출력하고 프로그램을 종료하세요.

        Scanner sc = new Scanner(System.in);
        System.out.printf("성적을 입력하세요: ");

        int grade = sc.nextInt();
        char result;

        if (grade < 0 || grade > 100) {
            System.out.println("잘못된 입력입니다. 성적은 0에서 100 사이로 입력해주세요.");
            return;
        }
        if (grade >= 90) {
            result = 'A';
            System.out.println(result + " 학점: 우수한 성적이네요! 계속 좋은 성적 유지하길 바랍니다.");
        } else if (grade >= 80) {
            result = 'B';
            System.out.println(result + " 학점: 좋은 성적입니다. 조금만 더 노력하면 A도 가능해요!");
        } else if (grade >= 70) {
            result = 'C';
            System.out.println(result + " 학점: 괜찮은 성적이지만, 더 높은 등급을 위해 노력해봅시다.");
        } else if (grade >= 60) {
            result = 'D';
            System.out.println(result + " 학점: 학습에 더 집중할 필요가 있어요. 도움이 필요하면 말해주세요.");
        } else {
            result = 'F';
            System.out.println(result + " 학점: 불합격입니다. 부족한 부분을 파악하고, 추가 학습이 필요해요.");
        }

    } // end of main

}  // end of class
