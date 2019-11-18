import java.math.BigDecimal;

/**
 * @author varun
 * @version 1.0
 */
public enum Size implements Consumable, Sellable {
    LARGE(15, BigDecimal.valueOf(0.4), BigDecimal.valueOf(4.05)),
    MEDIUM(10, BigDecimal.valueOf(0.3), BigDecimal.valueOf(3.45)),
    SMALL(5, BigDecimal.valueOf(0.2), BigDecimal.valueOf(2.85));
    private int calories;
    private BigDecimal cost;
    private BigDecimal price;

    Size(int calories, BigDecimal cost, BigDecimal price) {
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
