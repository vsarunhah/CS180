import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author varun
 * @version 1.0
 */
public class Tea extends Drink {
    private Ingredient[] ingredients;
    private Type type;

    public Tea(String name, int calories, BigDecimal cost, BigDecimal price, Size size, Type type,
               Ingredient... ingredients) throws NullPointerException, IllegalArgumentException {
        super(name, calories, cost, price, size);
        if (name == null || cost == null || price == null || size == null || type == null || ingredients == null) {
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
        this.type = type;
        this.ingredients = ingredients;

    }

    public Tea(String name, Size size, Type type, Ingredient... ingredients) throws NullPointerException {
        super(name, size);
        int cal = 0;
        BigDecimal cost = BigDecimal.ZERO;
        if (name == null || size == null || type == null || ingredients == null) {
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
        this.type = type;
        this.ingredients = ingredients;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tea) {
            Tea t = (Tea) o;
            return t.getSize().equals(getSize()) && t.getName().equals(getName()) &&
                    Arrays.equals(getIngredients(), t.getIngredients());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tea[" + getName() + ", " + getCalories() + ", " + getCost() + ", " + getPrice() + ", " + getSize() +
                ", " + getType() + ", " + Arrays.toString(getIngredients()) + "]";
    }
}
