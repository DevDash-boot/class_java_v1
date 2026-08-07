package com.oop10;

public class CardMainTest1 {
    public static void main(String[] args) {

        Card cd1 = new Card("체크카드");
        Card cd2 = new Card("신용카드");
        Card cd3 = new Card("체크카드");
        Card cd4 = new Card("신용카드");

        System.out.println(cd1.newCardNumber);
        System.out.println(cd2.newCardNumber);
        System.out.println(cd3.newCardNumber);
        System.out.println(cd4.newCardNumber);

    }
}
