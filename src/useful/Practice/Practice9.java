package useful.Practice;

import java.util.Scanner;

public class Practice9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] score = s.split(",");

        int sum = 0;

        for(String str : score) {
            sum += Integer.parseInt(str);
        }

        double avg = (double) sum / score.length;

        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + avg);

        sc.close();
    }
}