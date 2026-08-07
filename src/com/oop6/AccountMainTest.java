package com.oop6;

public class AccountMainTest {
    public static void main(String[] args) {

        Account account = new Account();
        account.deposit(10000);
        account.withdraw(6000);
        account.showInfo();

        // 접근 제어 지시자가 필요한 이유
        // 가상 시나리오
        // 내가 객체의 행동이 입금하는 기능을 만들어 두었는데
        // 신입 개발자가 실수로 입금하는 기능이 아닌 직접 변수에 접근해서 값을 수정한다면
        // 의도하지 않은 결과를 발생시킬 수 있다.

        //account.balance = 10000;
        // 변수에 직접 접근해서 값을 수정할 경우 실수할 가능성이 높다.
        // 그래서 우리는 변수에 private을 선언해서 외부에서는 필드가 안보이게 설정하는 것이 좋다.

        System.out.println("------------------");
        account.showInfo();
    }
}
