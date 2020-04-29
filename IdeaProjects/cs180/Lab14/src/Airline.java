import java.io.Serializable;
import java.util.ArrayList;

/**
 * Airline interface
 *
 * @author Varun Shah
 * @author Rahul Kolli
 * @version 1.0
 */
public interface Airline extends Serializable {
    // static AtomicInteger numPassengers = new AtomicInteger(0);
    ArrayList<String> PASSENGER_LIST = new ArrayList<>();
    int FLIGHT_NUMBER = 180000;

    int getTotalPassengers();

    boolean canAddPassengers();

    void addPassenger(String p);
}
