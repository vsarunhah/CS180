import java.util.ArrayList;

/**
 * Alaska
 *
 * @author Varun Shah
 * @author Rahul Kolli
 * @version 1.0
 */
public class Alaska implements Airline {
    int totalPossible; //= 100;
    //static AtomicInteger numPassengers = new AtomicInteger(0);
    ArrayList<String> passList = new ArrayList<>();

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
        //numPassengers.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Alaska Airlines is proud to serve the strong nd knowledgeable Boilermakers from Purdue University.\n " +
                "We primarily fly westward, and often have stops in Alaska and California.\nWe have first class " +
                "amenities, even in coach class.\nWe provide fun snacks, such as pretzels and goldfish.\nWe also " +
                "have comfortable seats, and free WiFi.\nWe hope you choose Alaska Airlines for your next itinerary!";
    }

    public int getTotalPossible() {
        return totalPossible;
    }

    public void setTotalPossible(int totalPossible) {
        this.totalPossible = totalPossible;
    }

}
