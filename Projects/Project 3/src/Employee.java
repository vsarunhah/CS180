import java.math.BigDecimal;

/**
 * @author varun
 * @version 1.0
 */
public class Employee extends Person implements Employable {
    private BigDecimal hourlyWage;

    public Employee(String name, int age, BigDecimal hourlyWage) throws NullPointerException, IllegalArgumentException {
        super(name, age);
        if (name == null || hourlyWage == null) {
            throw new NullPointerException();
        }
        if (age < 0 || hourlyWage.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException();
        }
        this.hourlyWage = hourlyWage;
    }

    @Override
    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    @Override
    public void setHourlyWage(BigDecimal hourlyWage) throws NullPointerException, IllegalArgumentException {
        if (hourlyWage.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException();
        }
        if (hourlyWage == null) {
            throw new NullPointerException();
        }
        this.hourlyWage = hourlyWage;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return e.getHourlyWage().compareTo(getHourlyWage()) == 0 && e.getAge() == getAge() &&
                    e.getName().equals(getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Employee[" + getName() + ", " + getAge() + ", " + getHourlyWage() + "]";
    }
}
