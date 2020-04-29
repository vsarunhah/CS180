/**
 * Passenger
 *
 * @author Rahul Kolli
 * @author Varun Shah
 * @version 1.0
 */
public class Passenger {
    String first;
    String last;
    int age;
    BoardingPass bp;

    public Passenger(String first, String last, int age) {
        this.first = first;
        this.last = last;
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BoardingPass getBp() {
        return bp;
    }

    public void setBp(BoardingPass bp) {
        this.bp = bp;
    }

    @Override
    public String toString() {
        return getFirst().toUpperCase().charAt(0) + ". " + getLast().toUpperCase() + ", " + getAge();
    }
}
