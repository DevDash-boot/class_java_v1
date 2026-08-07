package MyExercise;

import java.util.Scanner;

public class OrderExercise1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count;
        int price = 2500;

        // 아메리카노 수량 입력
        while (true) {
            System.out.print("아메리카노 수량을 입력하세요: ");
            count = sc.nextInt();
            // 1잔 이상 주문하지 않을 시 문자 출력
            if (count > 0) {
                break;
            } else {
                System.out.println("1잔 이상 주문해야 합니다.\n");
            }
        }
        // 총 금액
        int total = count * price;
        System.out.println("총 결제 금액은 " + total + "원 입니다.");

        // 특별 스탬프
        if (count >= 3) {
            System.out.println("3잔 이상 주문으로 특별 스탬프 발급");
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
        sc.close();
    } // end of main
}  // end of class