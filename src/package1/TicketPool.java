package package1;

public class TicketPool {
    private int availableTickets;
    private final int maxTicketCapacity;    //why final?//

    public TicketPool(int availableTickets, int maxTicketCapacity) {
        this.availableTickets = availableTickets;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public synchronized boolean addTickets(int count){
        if(availableTickets + count <= maxTicketCapacity){
            availableTickets += count;
            System.out.println(count + "tickets added. Total: " + availableTickets);
            return true;
        }else{
            System.out.println("Exceeding ticket capacity");
            return false;
        }
    }

    public synchronized boolean removeTicket(int ticketsPerRemove){
        if(availableTickets - ticketsPerRemove > 0){
            availableTickets -= ticketsPerRemove;
            System.out.println("Tickets purchased. Remaining: " + availableTickets);
            return true;
        }else {
            System.out.println("No tickets available.");
            return false;
        }

    }
}
