/**
 * A simple abstract class representing
 * Employees at a company
 *
 */
public abstract class Employee {

    private String name;
    private int age;
    private int ID;
    private static int employeeIDs;
    private double salary;
    /**
     * Basic Constructor for the Employee class
     * @param name Name of the employee
     * @param age Age of the employee
     */
    public Employee(String name, int age){
        this.name = name;
        this.age = age;
        ID = employeeIDs;
        employeeIDs++;

    }

    /**
     * Method to get salary of employee
     * @return salary of employee
     */

    /**
     * Method to print employee information
     */
    public void printInfo() {
        System.out.println("Employee Number #"+ID);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public abstract double getSalary();
}
