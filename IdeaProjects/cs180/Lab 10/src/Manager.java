/**
 * A simple class representing a Manager
 * employee at a company
 * Extends the Employee class
 *
 */
public class Manager extends Employee {
    private Team team;
    private int teamSize;
    private Developer[] developers;
    private int developerCounter;

    /**
     * Simple constructor for Manager class
     * @param name Name of Manager
     * @param age Age of Manager
     * @param teamSize Size of team under manager
     * @param t Team type of Manager
     */
    public Manager(String name, int age, int teamSize, Team t){
        super(name, age);
        this.teamSize = teamSize;
        this.team = t;
        developerCounter = 0;
        developers = new Developer[teamSize];
    }

    /**
     * Method to get salary of Manager. 
     * Managers have a base salary of 70000 with 2000 added for each developer under them. 
     * @return salary of Manager
     */
    
    public double getSalary() {
        return (70000 + (2000*teamSize));
    }

    /**
     * Method to print Manager information
     */
    
    public void printInfo() {
        super.printInfo();
        System.out.println("Position: Manager");
        System.out.println("Team: " + team);
        System.out.println("Developers: ");
        for(Developer d: developers){
            d.printInfo();
        }
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public Developer[] getDevelopers() {
        return developers;
    }

    public void setDevelopers(Developer[] developers) {
        this.developers = developers;
    }

    /**
     * Method to add developer to the developers array
     * @param d Developer to be added
     * @return True if developer was added successfully
     */
    public boolean addDeveloper(Developer d){
        if(teamSize == developerCounter) {
            return false;
        }
        developers[developerCounter] = d;
        developerCounter++;
        return true;

    }

    public int getDeveloperCounter() {
        return developerCounter;
    }
}
