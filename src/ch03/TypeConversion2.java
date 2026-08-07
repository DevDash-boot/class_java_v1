package ch03;

public class TypeConversion2 {
    // 코드 실행의 시작점
    public static void main(String[] args) {

        // 변수 선언
        int alpha = 123, alpha1 = 321;
        double beta = 43.6842, beta1 = 87.1564;

        // 자동 형변환 코드
        beta = alpha;
        System.out.println("beta : " + beta);

        double a1 = 4.123;
        int area = (int)a1*alpha;
        System.out.println("area : " + area);

        // 강제 형변환 코드
        alpha1 = (int) beta1;
        System.out.println("alpha1 : " + alpha1);

    } //end of main
}  // end of class
