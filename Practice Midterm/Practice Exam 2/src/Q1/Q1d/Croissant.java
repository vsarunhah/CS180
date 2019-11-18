package Q1.Q1d;

@SuppressWarnings("unused")
public class Croissant implements Food, Consumable {

	private final int calories;
	private final int carbs;
	private final int protein;
	private final int fats;
	private final String[] allergens;

	/**
	 * The {@code Croissant} constructor will take in four {@code int}s representing calorie count, carbohydrates,
	 * proteins, and fats. It will also take in a single dimension {@code String} array representing the allergens
	 * that this product has.
	 *
	 * @param calories  the caloric count of this food product.
	 * @param carbs     the carbohydrate count of this food product.
	 * @param protein   the protein count of this food product
	 * @param fats      the fats count of this food product
	 * @param allergens the list of allergens for this food.
	 */
	@SuppressWarnings("unused")
	public Croissant(int calories, int carbs, int protein, int fats, String[] allergens) {
		this.calories = calories;
		this.carbs = carbs;
		this.protein = protein;
		this.fats = fats;
		this.allergens = allergens;
	}

	/**
	 * The {@code getAllergens} method will return a formatted String where the list of allergens is separated by a
	 * comma and a space, unless it is the last element in the array. For example, if a food had allergens in its
	 * single dimension allergens {@code String} array like so:
	 * <p>
	 * Eggs
	 * Milk
	 * Wheat
	 * Butter
	 *
	 * <p>
	 * This method will return a single String formatted like so:
	 * <p>
	 * Eggs, Milk, Wheat, Butter
	 *
	 * @return a single line {@code String} representing the allergens of this food product.
	 */
	@Override
	public String getAllergens() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < allergens.length; i++) {
			String s = allergens[i];
			sb.append(s);
			if (i != allergens.length - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	/**
	 * Returns {@code calorie} count of this food product.
	 *
	 * @return {@code calorie} count of this food product.
	 */
	@Override
	public int getCaloricCount() {
		return calories;
	}

	/**
	 * Returns the {@code carbs} count of this food product.
	 *
	 * @return the {@code carbs} count of this food product.
	 */
	@Override
	public int getCarbohydrates() {
		return carbs;
	}

	/**
	 * Returns the {@code protein} count of this food product.
	 *
	 * @return the {@code protein} count of this food product.
	 */
	@Override
	public int getProtein() {
		return protein;
	}

	/**
	 * Returns the {@code fats} count of this food product
	 *
	 * @return the {@code fats} count of this food product
	 */
	@Override
	public int getFats() {
		return fats;
	}

	/**
	 * Returns a boolean representing if this food is consumable, as determined by if the class implements the marker
	 * interface called {@code Consumable}.
	 *
	 * @return if this item is {@code Consumable}, as determined by if the class implements the {@code Consumable}
	 * marker interface.
	 */
	@SuppressWarnings("ConstantConditions")
	@Override
	public boolean isConsumable() {
		return this instanceof Consumable;
	}

	/**
	 * Returns the country where this food product originated. For an {@code Croissant}, this food product originated in
	 * France.
	 *
	 * @return the country where this food product originated from. For an {@code Croissant}, it originated from France.
	 */
	@Override
	public String countryOfOrigin() {
		return "France";
	}

	/**
	 * Returns whether or not this food product is generally considered healthy. True if it is considered healthy,
	 * and false if it is not considered generally healthy. For an {@code Croissant}, this is generally considered a
	 * unhealthy food product.
	 *
	 * @return whether or not this food product is generally considered healthy. For an {@code Croissant}, it is
	 * generally considered to be unhealthy.
	 */
	@Override
	public boolean isHealthy() {
		return false;
	}


}
