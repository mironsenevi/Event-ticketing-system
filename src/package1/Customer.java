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

        for (int i = 1; i < ticketsPerRemove; i++){
            Ticket ticket =ticketPool.removeTicket();
            System.out.println("Ticket is - " + ticket + " - Customer name is - " + Thread.currentThread().getName());
            try {
                Thread.sleep(customerRetrievalRate * 1000); // convert to millisecond
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
