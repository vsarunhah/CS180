import java.math.BigDecimal;

/**
 * @author varun
 * @version 1.0
 */
public class Drink extends FoodProduct {
    private Size size;

    public Drink(String name, int calories, BigDecimal cost, BigDecimal price, Size size)
            throws NullPointerException, IllegalArgumentException {
        super(name, calories, cost, price);
        if (name == null || size == null || price == null || cost == null) {
            throw new NullPointerException();
        }
        if (calories < 0 || price.compareTo(BigDecimal.ZERO) == -1 || cost.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    public Drink(String name, Size size) throws NullPointerException {
        super(name, size.getCalories(), size.getCost(), size.getPrice());
        if (name == null || size == null) {
            throw new NullPointerException();
        }
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setCal(int calories) {
        super.setCalories(calories);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Drink) {
            Drink d = (Drink) object;
            return d.getName().equals(getName()) && d.getSize().equals(getSize());
        }
        return false;
    }

    @Override
    public String toString() {
        return ("Drink[" + getName() + ", " + getCalories() + ", " + getCost() + ", " + getPrice() + ", " + getSize() +
                "]");
    }
}
