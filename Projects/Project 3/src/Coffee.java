import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author varun
 * @version 1.0
 */
public class Coffee extends Drink {
    private Ingredient[] ingredients;
    private Roast roast;

    public Coffee(String name, int calories, BigDecimal cost, BigDecimal price, Size size,
                  Roast roast, Ingredient... ingredients)
            throws NullPointerException, IllegalArgumentException {
        super(name, calories, cost, price, size);
        if (name == null || cost == null || price == null || size == null || roast == null || ingredients == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] == null) {
                throw new NullPointerException();
            }
        }
        if (calories < 0 || cost.compareTo(BigDecimal.ZERO) == -1 || price.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException();
        }
        this.roast = roast;
        this.ingredients = ingredients;
    }

    public Coffee(String name, Size size, Roast roast, Ingredient... ingredients) throws NullPointerException {
        super(name, size);
        int cal = 0;
        BigDecimal cost = BigDecimal.ZERO;
        if (name == null || size == null || roast == null) {
            throw new NullPointerException();
        }
        if (ingredients == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i] == null) {
                throw new NullPointerException();
            }
            cal += ingredients[i].getCalories();
            cost = cost.add(ingredients[i].getCost());
        }
        cal += size.getCalories();
        cost = cost.add(size.getCost());
        super.setCal(cal);
        super.setCost(cost);
        //super(name, cal, size.getCost(), size.getPrice(), size);
        this.ingredients = ingredients;
        this.roast = roast;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public Roast getRoast() {
        return roast;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coffee) {
            Coffee c = (Coffee) o;
            return c.getName().equals(getName()) && c.getCalories() == getCalories() &&
                    c.getCost().compareTo(getCost()) == 0 && c.getPrice().compareTo(getPrice()) == 0 &&
                    c.getSize().equals(getSize()) && c.getRoast().equals(getRoast()) &&
                    Arrays.equals(c.getIngredients(), getIngredients());
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "Coffee[" + getName() + ", " + getCalories() + ", " + getCost() + ", " + getPrice() + ", " +
                getSize() + ", " + getRoast() + ", " + Arrays.toString(ingredients) + "]";
        return s;
    }
}