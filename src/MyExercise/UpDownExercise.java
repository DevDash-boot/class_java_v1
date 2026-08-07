package MyExercise;

import java.util.Scanner;

public class UpDownExercise {

    public static void main(String[] args) {
        // 변수 지정
        final int SECRET = 77; // 임의의 숫자 하나 지정
        int totalChance = 5; // 5번의 기회 지정
        boolean correct = false; // 맞췄는지 여부 확인

        Scanner sc = new Scanner(System.in);

        System.out.println("======= Up-Down 게임 =======");
        System.out.println("1부터 100사이의 비밀 숫자를 맞춰보세요");
        System.out.println("총 기회는 " + totalChance + "번 입니다.");

        for (int chance = 1; chance <= totalChance; chance++) {
            int remainChance = totalChance - chance + 1; // 남은 기회
            System.out.println(chance + "회차 입니다. 기회는 " + remainChance + " 번 남았습니다.");
            System.out.print("숫자를 입력하세요: ");
            int guess = sc.nextInt();
            // 범위를 초과한 경우
            if (guess < 1 || guess > 100) {
                System.out.println("범위는 1부터 100까지 입니다. 다시 입력해주세요.\n");
                continue;
            }
            // 맞춘 경우
            if (guess == SECRET) {
                System.out.println("축하합니다." + chance + "번째에 정답을 맞추셨습니다.");
                correct = true;
                break; // 종료
            }
            // 비밀 숫자보다 큰 경우
            else if (guess > SECRET) {
                System.out.print("다운!\n\n");
            }
            // 비밀 숫자보다 작은 경우
            else {
                System.out.print("업!\n\n");
            }
        }
        // 기회를 모두 소진한 경우
        if (!correct) {
            System.out.println("기회를 모두 소진했습니다. 정답은 " + SECRET + "이었습니다.");
        }
        sc.close();
    } // end of main
} // end of class
