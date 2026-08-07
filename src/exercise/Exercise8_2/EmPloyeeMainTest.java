package exercise.Exercise8_2;

public class EmPloyeeMainTest {

    public static void main(String[] args) {

        Employee f1 = new FullTimeEmployee("김정규", 1001, 320000);
        Employee p1 = new PartTimeEmployee("이알바", 2001, 10000, 80);

        f1.printInfo();
        f1.calculatePay();
        System.out.println("-------------");
        p1.printInfo();

    }
}
