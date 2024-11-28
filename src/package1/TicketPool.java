package package1;

public class TicketPool {
    private int totalTickets;
    private final int maxTicketCapacity;    //why final?//

    public TicketPool(int availableTickets, int maxTicketCapacity) {
        this.totalTickets = availableTickets;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    /**
     * add tickets to the ticketpool
     *
     * @param count amount of tickets
     * @return true if ticket was added, false ticketQueue is full
     */
    public synchronized boolean addTickets(int count){
        if(totalTickets + count <= maxTicketCapacity){
            totalTickets += count;
            System.out.println(count + "tickets added. Total: " + totalTickets);
            return true;
        }else{
            System.out.println("Exceeding ticket capacity");
            return false;
        }
    }

    /**
     * remove ticket from the ticketpool
     *
     * @param ticketsPerRemove amount of tickets to be removed
     * @return true if removal is success, false if no tickets available in the ticketPool
     */
    public synchronized boolean removeTicket(int ticketsPerRemove){
        if(totalTickets - ticketsPerRemove > 0){
            totalTickets -= ticketsPerRemove;
            System.out.println("Tickets purchased. Remaining: " + totalTickets);
            return true;
        }else {
            System.out.println("No tickets available.");
            return false;
        }

    }
}
