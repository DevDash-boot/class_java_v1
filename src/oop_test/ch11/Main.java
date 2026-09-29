package oop_test.ch11;

public class Main {
    public static void main(String[] args) {
        //PricePolicy pricePolicy = new WeekdayPricePolicy();
        PricePolicy pricePolicy = new WeekendPricePolicy();

        TicketService ticketService= new TicketService(pricePolicy);
        ticketService.reserve("어벤져스", 12000);
        ticketService.reserve("해리포터", 15000);
    }
}
