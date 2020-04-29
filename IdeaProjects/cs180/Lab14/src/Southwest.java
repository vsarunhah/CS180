import java.util.ArrayList;

/**
 * Southwest
 *
 * @author Rahul Kolli
 * @author Varun Shah
 * @version 1.0
 */
public class Southwest implements Airline {
    int totalPossible;
    ArrayList<String> passList = new ArrayList<>();

    //static AtomicInteger numPassengers = new AtomicInteger(0);
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
        return "Southwest Airlines is proud to offer flights to Purdue University.\nWe are happy to offer in flight" +
                " wifi as our amazing snacks. \n In addition we offer flights for much cheaper than other airlines" +
                ", and offer two free checked bags.\nWe hope you choose Southwest for your next flight.";
    }

    public int getTotalPossible() {
        return totalPossible;
    }

    public void setTotalPossible(int totalPossible) {
        this.totalPossible = totalPossible;
    }
}
