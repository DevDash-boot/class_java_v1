package useful.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("학생 수 : ");
        int count = sc.nextInt();
        int sum = 0;

        System.out.println("점수 입력");
        for (int i = 0; i < count; i++) {
            int score = sc.nextInt();
            list.add(score);
            sum += score;
        }

        double avg = (double) sum / count;

        System.out.println("===== 결과 =====");
        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);
        System.out.println("최고점 : " + Collections.max(list));
        System.out.println("최저점 : " + Collections.min(list));


        sc.close();
    }
}