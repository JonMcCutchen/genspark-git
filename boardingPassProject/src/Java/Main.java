import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        TicketData ticketData = new TicketData();
        ticketData.getInputs();
        ticketData.computeETA();
        System.out.println(ticketData);
    }
}
