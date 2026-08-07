package com.oop3;

public class BusMainTest1 {
    public static void main(String[] args) {
        Bus b1 = new Bus();
        Bus b2 = new Bus();

        b1.busNumber = 12;
        b1.station = "서면";
        b1.time = 2;
        b1.passenger = "톰";
        b1.pirce = 1000;

        b2.busNumber = 8;
        b2.station = "해운대";
        b2.time = 6;
        b2.passenger = "제리";
        b2.pirce = 700;

        b1.stop();
        b1.arrive();
        b1.board();
        b1.pay();
        b1.depart();
        System.out.println("-------------");

        b2.stop();
        b2.arrive();
        b2.board();
        b2.pay();
        b2.depart();
        System.out.println("-------------");

    }
}
