package exercise;

public class Exercise1 {

    // 메인 함수(코드 실행의 시작점)
    public static void main(String[] args) {
        //1. 데이터 10, 100, 200 을 변수 선언과 동시에 초기화를 하고 화면에 출력해 보세요.
        int n1=10, n2=100, n3=200;

        System.out.println("n1 = " + n1);
        System.out.println("n1 = " + n2);
        System.out.println("n1 = " + n3);

        //2. int ageBox 상자에 20을 담아 보세요
        int ageBox =20;
        System.out.println("ageBox = " + ageBox);

        //2.1 ageBox 상자의 값을 30으로 변경하고 기존에 담겨 있던 데이터를 다른 곳으로 옮겨 보세요
        int ageBox1 = ageBox;
        ageBox =30;
        System.out.println("ageBox = " + ageBox);
        System.out.println("ageBox1 = " + ageBox1);

        //3. int a = 1; int b = 3; 선언하고 a와 b에 담겨 있는 값을 서로 스위칭 해보세요
        int a=1, b=3, tmp;
        tmp = a;
        a = b;
        b = tmp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    } //end of main

} //end of class
