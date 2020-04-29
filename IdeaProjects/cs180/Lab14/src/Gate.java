import java.util.Random;

/**
 * Gate.java
 *
 * @author Rahul Kolli
 * @author Varun Shah
 * @version 1.0
 */
public class Gate {
    int gate;

    public Gate() {
        Random rand = new Random();
        gate = rand.nextInt(18) + 1;
    }

    public int getGate() {
        return gate;
    }
}