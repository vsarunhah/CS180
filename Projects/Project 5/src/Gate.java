import java.io.Serializable;
import java.util.Random;

public class Gate implements Serializable {
    private Airline airline; //airline operating at this gate
    private String terminal; //this gate's terminal
    private int gate; //this gate's gate number
    private String[] terminals = new String[]{"A", "B", "C"}; //array of possible terminals

    /**
     * creates gate based on passed information
     * @param airline
     * @param terminal
     * @param gate
     */
    public Gate(Airline airline, String terminal, int gate) {
        this.airline = airline;
        this.terminal = terminal;
        this.gate = gate;
    }

    /**
     * creates gate randomly
     */
    public Gate(){
        Random rand = new Random();
        this.gate = rand.nextInt(18) + 1;
        setTerminal(getTerminals()[rand.nextInt(getTerminals().length)]);
    }

    /**
     * getter and setters for airline, terminal, gate and terminals
     * @return
     */
    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public String[] getTerminals() {
        return terminals;
    }

    public void setTerminals(String[] terminals) {
        this.terminals = terminals;
    }
}
