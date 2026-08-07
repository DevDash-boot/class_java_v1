package exercise;

import com.oop6.Bank; // 직접 해당하는 파일만 가지고 올 수 있다.

public class BankPublic {

    public static void main(String[] args) {

        // public: 어디서나 접근 가능
        Bank bank1 = new Bank();
        //bank1.name = "우리은행";
        //System.out.println(bank1.name);

    }
}
