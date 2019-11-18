public class Passenger {
    private String fName; //first name
    private String lName; //last name
    private int age; //age
    private BoardingPass boardingPass;

    /**
     * creates a new passenger with information
     * @param fName
     * @param lName
     * @param age
     */
    public Passenger(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    /**
     * create a duplicate of an existing passenger
     * @param p
     */
    public Passenger(Passenger p){
        this.fName = p.getfName();
        this.lName = p.getlName();
        this.age = p.getAge();
    }

    /**
     * getters and setters for the private variables fName, lName, age and boarding pass;
     */
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }

    public void setBoardingPass(BoardingPass boardingPass) {
        this.boardingPass = boardingPass;
    }

    @Override
    public String toString(){
        return getfName().charAt(0) + ". " + getlName().toUpperCase() + ", " + getAge();
    }
}
