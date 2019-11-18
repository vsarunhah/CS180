import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author varun
 * @version 1.0
 */
public class Cafe implements Serializable {
    private ArrayList<Employee> employees;
    private BigDecimal revenue;
    private BigDecimal expenses;

    public Cafe() {
        revenue = BigDecimal.ZERO;
        expenses = BigDecimal.ZERO;
        employees = new ArrayList<Employee>();
    }

    public static FoodProduct makeFoodProduct(String name, int calories, BigDecimal cost, BigDecimal price)
            throws NullPointerException, IllegalArgumentException {
        if (name == null || price == null || cost == null) {
            throw new NullPointerException();
        }
        if (calories < 0 || cost.compareTo(BigDecimal.ZERO) == -1 || price.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException();
        }
        FoodProduct fp = new FoodProduct(name, calories, cost, price);
        return fp;
    }

    public static Coffee makeCoffee(String name, Size size, Roast roast, Ingredient... ingredients)
            throws NullPointerException {
        if (name == null || size == null || roast == null || ingredients == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] == null) {
                throw new NullPointerException();
            }
        }
        return new Coffee(name, size, roast, ingredients);
    }

    public static Tea makeTea(String name, Size size, Type type, Ingredient... ingredients)
            throws NullPointerException {
        if (name == null || size == null || type == null || ingredients == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] == null) {
                throw new NullPointerException();
            }
        }
        return new Tea(name, size, type, ingredients);
    }

    public void sellFoodProduct(FoodProduct foodProduct) throws NullPointerException {
        if (foodProduct == null) {
            throw new NullPointerException();
        }
        expenses = expenses.add(foodProduct.getCost());
        revenue = revenue.add(foodProduct.getPrice());
    }

    public void hireEmployee(Employee employee) throws NullPointerException, IllegalArgumentException {
        if (employee == null) {
            throw new NullPointerException();
        }
        if (employee.getAge() < 14) {
            throw new IllegalArgumentException();
        }
        employees.add(employee);
    }

    public boolean fireEmployee(Employee employee) throws NullPointerException {
        if (employee == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i))) {
                employees.remove(employees.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean updateEmployeeWage(Employee employee, BigDecimal newHourlyWage)
            throws NullPointerException, IllegalArgumentException {
        if (employee == null || newHourlyWage == null) {
            throw new NullPointerException();
        }
        if (newHourlyWage.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < employees.size(); i++) {
            if (employee.equals(employees.get(i))) {
                employees.get(i).setHourlyWage(newHourlyWage);
                return true;
            }
        }
        return false;
    }

    public void open(int hours, Random random) throws IllegalArgumentException, NullPointerException {
        if (random == null) {
            throw new NullPointerException();
        }
        if (hours < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < hours; i++) {
            int customers = random.nextInt(100);
            for (int j = 0; j < customers; j++) {
                FoodProduct fp;
                int order = random.nextInt(100);
                if (order < 25) {
                    fp = makeFoodProduct("Chocolate Sprinkle Donut", 290, BigDecimal.valueOf(0.2),
                            BigDecimal.valueOf(0.95));
                } else if (order < 50) {
                    fp = makeCoffee("Logan's Coffee", Size.MEDIUM, Roast.MEDIUM,
                            Ingredient.CREAM, Ingredient.CREAM, Ingredient.SUGAR, Ingredient.SUGAR);
                } else if (order < 75) {
                    fp = makeTea("Andrew's Tea", Size.SMALL, Type.GREEN, Ingredient.SUGAR);
                } else {
                    continue;
                }
                sellFoodProduct(fp);
            }
        }
        for (int i = 0; i < employees.size(); i++) {
            expenses = expenses.add((employees.get(i).getHourlyWage()).multiply(BigDecimal.valueOf(hours)));
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public BigDecimal getProfit() {
        return revenue.subtract(expenses);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cafe) {
            Cafe c = (Cafe) o;
            if (c.getExpenses().compareTo(getExpenses()) == 0 && c.getRevenue().compareTo(getRevenue()) == 0) {
                ArrayList<Employee> emps = c.getEmployees();
                ArrayList<Employee> e = getEmployees();
                emps.removeAll(e);
                return emps.size() == 0;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "Cafe[" + expenses + ", " + revenue + ", " + "[";
        for (int i = 0; i < getEmployees().size(); i++) {
            s += getEmployees().get(i).toString() + ", ";
        }
        s = s.substring(0, s.length() - 2) + "]]";
        return s;
    }
}
