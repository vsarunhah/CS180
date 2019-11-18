import java.math.BigDecimal;

/**
 * @author varun
 * @version 1.0
 */
public enum Ingredient implements Consumable, Sellable {
    CREAM(40, BigDecimal.valueOf(0.05), BigDecimal.ZERO),
    SUGAR(16, BigDecimal.valueOf(0.01), BigDecimal.ZERO);
    private int calories;
    private BigDecimal cost;
    private BigDecimal price;

    Ingredient(int calories, BigDecimal cost, BigDecimal price) {
        this.calories = calories;
        this.cost = cost;
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
