package package1;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final int maxTicketCapacity;
    private Queue<Ticket> ticketQueue;


    public TicketPool(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
        this.ticketQueue = new LinkedList<Ticket>();
    }

    /**
     * add tickets to the Ticket pool
     *
     * @param count amount of tickets
     * @return true if ticket was added, false ticketQueue is full
     */
    public synchronized void addTicket(Ticket ticket){
        // checks
        if(ticketQueue.size() + 1 >= maxTicketCapacity){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace(); // for cli
                throw new RuntimeException(e.getMessage()); // for client server application
            }
        }else {
            ticketQueue.add(ticket);
            notifyAll();
            System.out.println("Ticket added by " + Thread.currentThread().getName() + ". Current size is - " + ticketQueue.size());
        }
    }

    /**
     * remove ticket from the Ticket Pool
     *
     * @param ticketsPerRemove amount of tickets to be removed
     * @return true if removal is success, false if no tickets available in the ticketPool
     */
    public synchronized Ticket removeTicket(){
        while(ticketQueue.isEmpty()){
            try {
                wait(); // If queue is empty add Customer to waiting status
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }

        Ticket ticket = ticketQueue.poll();
        notifyAll();
        System.out.println("Ticket bought by - " + Thread.currentThread().getName() + ". current size is - " + ticketQueue.size() + ". Ticket is - " + ticket);
        return ticket;

    }
}
