package package1;

import java.math.BigDecimal;

public class Vendor implements Runnable {
    private TicketPool ticketPool;
    private int totalTickets; //amount of tickets going to sell
    private int ticketReleaseRate; //frequency of releasing

    public Vendor(TicketPool ticketPool, int totalTickets, int releaseInterval) {
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = releaseInterval;
    }

    public void run() {

        for (int i = 0; i < totalTickets; i++) {
            Ticket ticket = new Ticket(i,"simple event",new BigDecimal("2000"));
            ticketPool.addTicket(ticket);
            try{
                Thread.sleep(ticketReleaseRate * 1000); // convert to millisecond
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
