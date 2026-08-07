package useful.ch11;

public class Father extends Thread {

    BankAcount bankAcount;

    public Father(BankAcount bankAcount) {
        this.bankAcount = bankAcount;
    }

    @Override
    public void run() {
        // 가정 : 아버지가 1만원 입금한다.
        bankAcount.saveMoney(10000);
    }
}
