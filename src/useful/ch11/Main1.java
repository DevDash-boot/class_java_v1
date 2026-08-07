package useful.ch11;

public class Main1 {

    public static void main(String[] args) {
        // 10만원
        BankAcount bankAcount = new BankAcount();

        // bankAcount를 넣음으로써 하나의 자원을 공유하고 있는 상태
        // 입금 일 위임 -> 1만원 입금
        Father father = new Father(bankAcount);
        father.start();
        // 출금 일 위임 -> 5천원 출금
        Mother mother = new Mother(bankAcount);
        mother.start();
        // 기대값 : 10만 5천원
        // 11만원 : 의도하지 않은 동작이 발생됨
        // 이유 : Thread.sleep이 3초라 그 시간 동안 기다림

        // 위 해결 방안은 자바에서 동기화 처리로 해결할 수 있다.
        // 키워드 synchronized 사용해 synchronized 메서드로 만들 수 있다.

    }
}
