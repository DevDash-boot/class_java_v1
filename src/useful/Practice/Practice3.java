package useful.Practice;

import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int n = sc.nextInt();
            System.out.println("입력: " + n);

            System.out.println("입력한 숫자: " + n);
        } catch (Exception e) {
            System.out.println("숫자만 입력하세요.");
        }
        sc.close();
    }
}
