package exercise.Exercise8_1;

public class BeverageMain {
    public static void main(String[] args) {
        Beverage[] b = new Beverage[3];
        b[0] = new Americano("아메리카노", 3000);
        b[1] = new Americano("라떼", 4500);

        int sum = 0;    // 합계 금액

        // i번째 prepare 호출과 금액 합
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {
                b[i].prepare();
                sum += b[i].getPrice();
            }
        }

        System.out.print("주문 : ");

        // 에러 방지 코드(배열의 범위를 넘을 떄)
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {
                System.out.print(b[i].getName());
                if (i + 1< b.length && b[i + 1] != null) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
        System.out.println("총 금액 : " + sum + "원");
    }
}

