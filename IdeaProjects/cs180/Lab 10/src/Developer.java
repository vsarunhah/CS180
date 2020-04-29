/**
 * A simple class representing a Developer
 * employee at a company
 * Extends the Employee class
 *
 */
public class Developer extends Employee {
    private Team team;
    /**
     * Simple constructor for Developer class
     * @param name Name of Developer
     * @param age Age of Developer
     * @param t Team type of Developer
     */
    public Developer(String name, int age, Team t){
        super(name, age);
        this.team = t;
    }

    /**
     * Method to get Team type of Developer
     * @return
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Method to set Team type of Developer
     * @param team Team to be set
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Method to get salary of Developer
     * A Developer earns 50000
     * @return
     */
    
    public double getSalary() {
        return 50000;
    }
    /**
     * Method to print Developer info
     */
    public void printInfo() {
        super.printInfo();
        System.out.println("Position: Developer");
        System.out.println("Team: " + team);
    }
}
