package useful.Practice;

import java.util.Scanner;

public class Practice7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try{
            String s = sc.nextLine();
            int n = Integer.parseInt(s);
            System.out.println(n + 10);
        }catch (Exception e){
            System.out.println("잘못된 입력입니다.");
        }

    }
}
