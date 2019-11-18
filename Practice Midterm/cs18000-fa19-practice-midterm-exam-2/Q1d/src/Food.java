/**
 * An interface for a food product.
 */
public interface Food {
	/**
	 * A method to be implemented that will return a {@code String} representation of the allergens of this product
	 *
	 * @return a {@code String} representation of the allergens of this product.
	 */
	public String getAllergens();
	/**
	 * A method to be implemented that will return a {@code int} that represents the caloric count of this product
	 *
	 * @return a {@code int} representation of the caloric count of this product.
	 */
	public int getCaloricCount();
	/**
	 * A method to be implemented that will return a {@code int} that represents the carbohydrate count of this product
	 *
	 * @return a {@code int} representation of the carbohydrate count of this product.
	 */
	public int getCarbohydrates();
	/**
	 * A method to be implemented that will return a {@code int} that represents the protein count of this product
	 *
	 * @return a {@code int} representation of the protein count of this product.
	 */
	public int getProtein();
	/**
	 * A method to be implemented that will return a {@code int} that represents the fats count of this product
	 *
	 * @return a {@code int} representation of the fats count of this product.
	 */
	public int getFats();
	/**
	 * A method to be implemented that will return a {@code boolean} that represents whether this food product is
	 * consumable or not. If the child class that implements this interface also implements the interface
	 * {@code Consumable}, it is considered a consumable food product.
	 *
	 * @return whether this food product is considered consumable, as determined by whether it also implements the
	 * {@code Consumable} interface.
	 */
	public boolean isConsumable();
	/**
	 * A method to be implemented that will return the country where the food product originated from.
	 *
	 * @return the country where this food product originated from.
	 */
	public String countryOfOrigin();
	/**
	 * Returns a boolean representing whether a food product is considered healthy or unhealthy. An unhealthy food
	 * product is represented by a false state, while a healthy food product is represented by a true state.
	 *
	 * @return whether this food product is considered healthy (true), or unhealthy (false).
	 */
	public boolean isHealthy();
}