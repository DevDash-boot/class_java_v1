package exercise.Exercise8_instruoctor_3;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("-----");

// Employee 타입으로 받으면 calculateBonus() 를 호출할 수 없다
        FullTimeEmployee e3 = new Manager("박팀장", 1002, 4000000, 500000);

        e3.printInfo();
        System.out.println("급여 : " + e3.calculatePay() + "원");
        System.out.println("보너스 : " + e3.calculateBonus() + "원");
    }
}
