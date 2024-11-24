package package1;

public class Customer implements Runnable{
    private TicketPool ticketPool;
    private int retrievalInterval;
    private int ticketsPerRemove;

    public Customer(TicketPool ticketPool, int retrievalInterval) {
        this.ticketPool = ticketPool;
        this.retrievalInterval = retrievalInterval;
    }

    public void run() {
        while(true) {
            ticketPool.removeTicket(ticketsPerRemove);
            try{
                Thread.sleep(retrievalInterval);
            }catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
