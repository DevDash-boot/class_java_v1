package com.oop10;

public class Card {
    int newCardNumber;
    private String cardType;

    public Card(String cardType) {
        this.cardType = cardType;
        newCardNumber = CardCompany.cardSerialNumber++;
    }
}
