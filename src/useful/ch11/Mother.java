package useful.ch11;

public class Mother extends Thread {

    BankAcount bankAcount;

    public Mother(BankAcount bankAcount) {
        this.bankAcount = bankAcount;
    }

    @Override
    public void run() {
        // 가정 : 어머니는 5천원 출금
        bankAcount.withdraw(5000);
    }
}
