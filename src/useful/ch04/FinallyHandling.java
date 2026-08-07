package useful.ch04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("숫자를 입력하시오: ");
            int result = sc.nextInt();
        } catch (InputMismatchException e1) {   // 구체적으로 예외 처리, Exception 보다 위에 적어야한다.
            System.out.println("입력 잘못 했음");
        } catch (Exception e2) {
            System.out.println("알 수 없는 오류 발생");
        } finally {
            // 못 잡은 catch 가 있는 경우
            // finally는 반드시 수행되어야 할 코드 영역
            // 심지어 return 키워드를 만나더라도 이 영역은 수행
            sc.close(); // 메모리 누수 방지
        }

        System.out.println("--------------");
        System.out.println("프로그램이 비정상 종료 되지 않음");

    }
}
