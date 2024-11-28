package package1;

public class Customer implements Runnable{
    private TicketPool ticketPool;
    private int customerRetrievalRate;
    private int ticketsPerRemove;

    public Customer(TicketPool ticketPool, int retrievalInterval, int ticketsPerRemove) {
        this.ticketPool = ticketPool;
        customerRetrievalRate = retrievalInterval;
        this.ticketsPerRemove = ticketsPerRemove;
    }

    public void run() {
        while(true) {
            ticketPool.removeTicket(ticketsPerRemove);
            try{
                Thread.sleep(customerRetrievalRate);
            }catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
