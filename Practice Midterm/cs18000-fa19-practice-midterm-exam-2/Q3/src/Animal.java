public interface Animal {
	/**
	 * A method to be implemented by a child class that returns true if the {@code Animal} has legs, and false
	 * otherwise.
	 *
	 * @return true if the {@code Animal} has legs, and false otherwise.
	 */
	public boolean hasLegs();
	/**
	 * A method to be implemented by a child class that returns the number of legs if the {@code Animal} has
	 * legs. If the {@code Animal} does not have legs, the method returns 0.
	 *
	 * @param hasLegs a boolean that represents whether the {@code Animal} has legs or not.
	 * @return the number of legs if the {@code Animal} has legs.
	 */
	public int numLegs(boolean hasLegs);
	/**
	 * A method to be implemented by a child class that returns the habitat of the {@code Animal}.
	 *
	 * @return the habitat of the {@code Animal}.
	 */
	public String getHabitat();
	/**
	 * A method to be implemented by a child class wherein the {@code Animal} consumes a specific amount of food if
	 * and only if they are not dead.
	 *
	 * @param numFood the amount of food to consume.
	 */
	public void consumeFood(int numFood);
	/**
	 * A method to be implemented by a child class wherein the {@code Animal} will return a new instance of its
	 * specific type if and only if they are not dead.
	 *
	 * @return a new instance of the specific {@code Animal} if and only if the {@code Animal} is not dead.
	 */
	public Object reproduce();
	/**
	 * A method to be implemented by a child class wherein the {@code Animal} will die, setting its life energy to -1,
	 * and will prevent it from reproducing and consuming food.
	 */
	public void die();
}