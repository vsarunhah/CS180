public class Bagel implements Food, Consumable{
	/**
	 * The calories of this bagel.
	 */
	private final int calories;
	/**
	 * The carbohydrates of this bagel.
	 */
	private final int carbs;
	/**
	 * The protein of this bagel.
	 */
	private final int protein;
	/**
	 * The fats of this bagel.
	 */
	private final int fats;
	/**
	 * The allergens of this bagel.
	 */
	private final String[] allergens;
	/**
	 * The {@code Bagel} constructor will take in four {@code int}s representing calorie count, carbohydrates,
	 * proteins, and fats. It will also take in a single dimension {@code String} array representing the allergens
	 * that this product has.
	 *
	 * @param calories  the caloric count of this food product.
	 * @param carbs     the carbohydrate count of this food product.
	 * @param protein   the protein count of this food product
	 * @param fats      the fats count of this food product
	 * @param allergens the list of allergens for this food.
	 */
	public Bagel(int calories, int carbs, int protein, int fats, String[] allergens) {
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
	 * Yeast
	 * Wheat
	 * <p>
	 * This method will return a single String formatted like so:
	 * <p>
	 * Yeast, Wheat
	 *
	 * @return a single line {@code String} representing the allergens of this food product.
	 */
	public String getAllergens(){
		String s = "";
		for (int i = 0; i < allergens.length; i++){
			s += allergens[i] + ", ";
		}
		s = s.substring(0, s.length()-2);
		return s;
	}
	/**
	 * Returns {@code calorie} count of this food product.
	 *
	 * @return {@code calorie} count of this food product.
	 */
	public int getCaloricCount() {
		return calories;
	}
	/**
	 * Returns the {@code carbs} count of this food product.
	 *
	 * @return the {@code carbs} count of this food product.
	 */
	public int getCarbohydrates() {
		return carbs;
	}
	/**
	 * Returns the {@code protein} count of this food product.
	 *
	 * @return the {@code protein} count of this food product.
	 */
	public int getProtein() {
		return protein;
	}
	/**
	 * Returns the {@code fats} count of this food product
	 *
	 * @return the {@code fats} count of this food product
	 */
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
	public boolean isConsumable(){
		Class[] clas = Bagel.class.getInterfaces();
		for (int i = 0; i < clas.length; i++){
			if(clas[i].getName().equals("Consumable")){
				return true;
			}
		}
		return false;
	}
	/**
	 * Returns the country where this food product originated. For an {@code Bagel}, this food product originated in
	 * Poland.
	 *
	 * @return the country where this food product originated from. For an {@code Bagel}, it originated from Poland.
	 */
	public String countryOfOrigin(){
		return "Poland";
	}
	/**
	 * Returns whether or not this food product is generally considered healthy. True if it is considered healthy,
	 * and false if it is not considered generally healthy. For an {@code Bagel}, this is generally considered a
	 * unhealthy food product.
	 *
	 * @return whether or not this food product is generally considered healthy. For an {@code Bagel}, it is
	 * generally considered to be unhealthy.
	 */
	public boolean isHealthy(){
		return false;
	}
}