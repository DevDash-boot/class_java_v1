package exercise;

public class Exercise0 {
    public static void main(String[] args) {

        // 이중 for문
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(j + "\t");    // \t는 탭, \n은 enter와 같은 기능
            }
            System.out.println();
        }
        System.out.println("-------------------");

        // 별
        /*|i열 ------j열
         *|1 *       i=1 j=1
         *|2 **      i=2 j=2
         *|3 ***     i=3 j=3
         *|4 ****    i=4 j=4
         */
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-------------------");

        for (int i = 1; i <= 7; i += 2) {
            for (int j = 1; j <= (7 - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 별 역순
        for (int i = 7; i >= 1; i -= 2) {
            // 공백 출력
            for (int j = 1; j <= (7 - i) / 2; j++) {
                System.out.print(" ");
            }
            // 별 출력
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
