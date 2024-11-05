package package1;

public class TicketPool {
    private int availableTickets;
    private final int maxTicketCapacity;    //why final?//

    public TicketPool(int availableTickets, int maxTicketCapacity) {
        this.availableTickets = availableTickets;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public synchronized void addTickets(int count){
        if(availableTickets + count <= maxTicketCapacity){
            availableTickets += count;
            System.out.println(count + "tickets added. Total: " + availableTickets);
        }
    }

    public synchronized boolean removeTicket(){
        if(availableTickets > 0){
            availableTickets--;
            System.out.println("Tickets purchased. Remaining: " + availableTickets);
            return true;
        }else {
            System.out.println("No tickets available.");
            return false;
        }

    }
}
