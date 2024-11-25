package package1;

public class Customer implements Runnable{
    private TicketPool ticketPool;
    private int customerRetrievalRate;
    private int ticketsPerRemove;

    public Customer(TicketPool ticketPool, int retrievalInterval) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = retrievalInterval;
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
