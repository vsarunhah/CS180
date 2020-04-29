import java.util.Random;

/**
 * Boarding Pass
 *
 * @author Varun Shah
 * @author Rahul Kolli
 * @version 1.0
 */
public class BoardingPass {
    Passenger passenger;
    String airline;
    int gate;
    char terminal;

    public BoardingPass(Passenger p, String airline) {
        this.passenger = p;
        Random rand = new Random();
        terminal = (char) (rand.nextInt(3) + 65);
        gate = rand.nextInt(18) + 1;
        this.airline = airline;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getGate() {
        return gate;
    }

    public char getTerminal() {
        return terminal;
    }

    @Override
    public String toString() {
        String s = "-----------------------------------------------------------------------------------------------" +
                "---------\n";
        s += "BOARDING PASS FOR FLIGHT 180000 WITH " + airline + " Airlines\n";
        s += "PASSENGER FIRST NAME: " + getPassenger().getFirst() + "\n";
        s += "PASSENGER LAST NAME: " + getPassenger().getLast() + "\n";
        s += "PASSENGER AGE: " + getPassenger().getAge() + "\n";
        s += "You can now begin boarding at gate " + getTerminal() + "" + getGate() + "\n";
        s += "--------------------------------------------------------------------------------------------------------";
        return s;
    }
}
