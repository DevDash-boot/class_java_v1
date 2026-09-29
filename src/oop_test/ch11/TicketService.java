package oop_test.ch11;

public class TicketService{
    private PricePolicy pricePolicy;

    public TicketService(PricePolicy pricePolicy) {
        this.pricePolicy = pricePolicy;
    }

    public void reserve(String movieTitle, int price){
        Ticket newTicket = new Ticket(movieTitle, price);
        int finalPrice = pricePolicy.calculate(newTicket.getPrice());
        System.out.printf("영화 : %s | 금액 : %d원\n", newTicket.getMovieTitle(), finalPrice);
    }
}
