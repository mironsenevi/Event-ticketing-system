package package1;

public class Ticket {
    private int ticketID;
    private String ticketName;
    private int ticketPrice;

    public Ticket(int ticketID, String ticketName, int ticketPrice) {
        this.ticketID = ticketID;
        this.ticketName = ticketName;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketID() {return ticketID;}

    public void setTicketID(int ticketID) {this.ticketID = ticketID;}

    public String getTicketName() {return ticketName;}

    public void setTicketName(String ticketName) {this.ticketName = ticketName;}

    public int getTicketPrice() {return ticketPrice;}

    public void setTicketPrice(int ticketPrice) {this.ticketPrice = ticketPrice;}

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", ticketName='" + ticketName + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
