package package1;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketsPerRelease;
    private final int releaseInterval;      //why final?//

    public Vendor(TicketPool ticketPool, int ticketsPerRelease, int releaseInterval) {
        this.ticketPool = ticketPool;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
    }

    public void run() {
        while (true) {
            ticketPool.addTickets(ticketsPerRelease);
            try{
                Thread.sleep(releaseInterval);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }

}
