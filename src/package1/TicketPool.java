package package1;

public class TicketPool {
    private int totalTickets;
    private final int maxTicketCapacity;    //why final?//

    public TicketPool(int availableTickets, int maxTicketCapacity) {
        this.totalTickets = availableTickets;
        this.maxTicketCapacity = maxTicketCapacity;
    }

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
