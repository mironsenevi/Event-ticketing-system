package package1;

public class Customer implements Runnable{
    private final TicketPool ticketPool;
    private final int retrievalInterval;

    public Customer(TicketPool ticketPool, int retrievalInterval) {
        this.ticketPool = ticketPool;
        this.retrievalInterval = retrievalInterval;
    }

    public void run() {
        while(true) {
            ticketPool.removeTicket();
            try{
                Thread.sleep(retrievalInterval);
            }catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
