package MyExercise;

import java.util.Scanner;

public class OrderExercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price = 1500;   // 삼각김밥 가격
        int count;          // 삼각김밥 개수
        int sum;            // 합계 금액 = 개수 * 가격
        int discount = 0;   // 할인 금액
        int total;          // 총 결제 금액 = 합계 금액 - 할인 금액

        System.out.println("======= 편의점 계산기 =======");

        // 삼각김밥 개수 입력
        while (true) {
            System.out.print("삼각김밥 개수를 입력하세요 : ");
            count = sc.nextInt();

            // 삼각김밥이 0개 이하로 선택된 경우
            if (count > 0) {
                break;
            } else {
                System.out.println("1개 이상 입력하세요.\n");
            }
        }

        // 총 금액 계산
        sum = count * price;

        System.out.println("삼각김밥 개수 : " + count + "개");
        System.out.println("총 금액 : " + sum + "원");

        // 7개 이상일 때 20프로 할인, 4개 이상일 때 10프로 할인
        if (count >= 7) {
            discount = sum * 20 / 100;
            System.out.println("7개 이상 구매로 20% 할인");
        } else if (count >= 4) {
            discount = sum * 10 / 100;
            System.out.println("4개 이상 구매로 10% 할인");
        } else {
            System.out.println("할인 없음");
        }
        // 총 결제 금액
        total = sum - discount;

        System.out.println("할인 금액 : " + discount + "원");
        System.out.println("최종 결제 금액 : " + total + "원");

        // 7개 이상 구매시 럭키 이벤트 출력 *로된 사각형
        if (count >= 7) {
            System.out.println("\n럭키 이벤트!");

            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 4; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }

        final int PASSWORD = 1234;  // 결제 시 입력할 비밀번호
        boolean success = false;    // 비밀번호 입력이 맞는지 틀린지 확인

        // 3번이상 틀리면 결제 실패, 3번 이내에 성공 시 결제 완료가 된다.
        for (int i = 1; i <= 3; i++) {
            System.out.print("\n비밀번호 입력 : ");
            int pw = sc.nextInt();

            if (pw == PASSWORD) {
                System.out.println("결제 완료!");
                success = true;
                break;
            } else {
                System.out.println("비밀번호 오류");
            }
        }
        if (!success) {
            System.out.println("결제 실패");
        }
        sc.close();
    }
}