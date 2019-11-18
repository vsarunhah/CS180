import java.math.BigDecimal;

/**
 * @author varun
 * @version 1.0
 */
public class FoodProduct implements Consumable, Identifiable, Sellable {
    private int calories;
    private BigDecimal cost;
    private String name;
    private BigDecimal price;

    public FoodProduct(String name, int calories, BigDecimal cost, BigDecimal price) throws NullPointerException,
            IllegalArgumentException {
        if (name == null || cost == null || price == null) {
            throw new NullPointerException();
        }
        if (calories < 0 || cost.compareTo(BigDecimal.ZERO) == -1 || price.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException();
        }
        this.calories = calories;
        this.cost = cost;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof FoodProduct) {
            FoodProduct fp = (FoodProduct) object;
            return fp.getCalories() == getCalories() && fp.getCost().compareTo(getCost()) == 0 &&
                    fp.getName().equals(getName()) && fp.getPrice().compareTo(getPrice()) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return ("FoodProduct[" + getName() + ", " + getCalories() + ", " + getCost() + ", " + getPrice() + "]");
    }
}
