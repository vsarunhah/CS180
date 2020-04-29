import java.util.ArrayList;

/**
 * Delta
 *
 * @author Varun Shah
 * @author Rahul Kolli
 * @version 1.0
 */
public class Delta implements Airline {
    //static AtomicInteger numPassengers = new AtomicInteger(0);
    ArrayList<String> passList = new ArrayList<>();
    int totalPossible;

    @Override
    public int getTotalPassengers() {
        return passList.size();
    }

    @Override
    public boolean canAddPassengers() {
        int numPass = passList.size();
        //numPassengers.decrementAndGet();
        return numPass < totalPossible;
    }

    @Override
    public void addPassenger(String p) {
        passList.add(p);
    }

    @Override
    public String toString() {
        return "Delta Airlines is proud to be one of the five premier Airlines at Purdue University.\nWe are extremely"
                + " offer exceptional services, with free limited WiFi for all customers.\nPassengers who use " +
                "T-Mobile as a cell phone carrier get additional benefits.\nWe are also happy to offer power outlets" +
                " in each seat for passenger use.\nWe hope you choose to fly Delta as your next Airline.";
    }

    public int getTotalPossible() {
        return totalPossible;
    }

    public void setTotalPossible(int totalPossible) {
        this.totalPossible = totalPossible;
    }
}
