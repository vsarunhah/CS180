@SuppressWarnings("unused")
public class Capybara extends Mammal{
	/**
	 * Whether or not this capybara is warm blooded.
	 */
	private final boolean isWarmBlooded;
	/**
	 * Whether or not this capybara is cold blooded.
	 */
	private final boolean isColdBlooded;
	/**
	 * A constructor for class {@code Capybara}. It takes three parameters, where one is a {@code String} habitat,
	 * one is an {@code int} numLegs, and one is an {@code boolean} isLiveBirth. It will make a super call to its
	 * parent constructor, {@code Mammal}, and then set {@code isWarmBlooded} to true, and {@code isColdBlooded} to
	 * false.
	 *
	 * @param habitat     the habitat that this {@code Capybara} lives in.
	 * @param numLegs     the number of legs that this {@code Capybara} lives in.
	 * @param isLiveBirth the boolean value representing if this {@code Capybara} gives live birth.
	 */
	public Capybara(String habitat, int numLegs, boolean isLiveBirth){
		super(habitat, numLegs, isLiveBirth);
		isWarmBlooded = true;
		isColdBlooded = false;
	}
	/**
	 * Returns whether this {@code Mammal} is cold blooded. {@code Mammal}s are not cold blooded.
	 *
	 * @return the cold blooded state of this {@code Animal}.
	 */

	/**
	 * Returns whether this {@code Mammal} is warm blooded. {@code Mammal}s are warm blooded.
	 *
	 * @return the warm blooded state of this {@code Animal}.
	 */

	/**
	 * Consumes food, incrementing energy, if and only if the {@code Animal} is not dead.
	 *
	 * @param numFood the amount of food to consume.
	 */

	/**
	 * Reproduces an {@code Animal} of type {@code Capybara} if and only if the animal is not dead. The offspring
	 * will have the same properties as its parent.
	 *
	 * @return a new {@code Capybara} with the same properties of the parent, if and only if the parent is not dead.
	 * If the parent is dead, the method will return {@code null}.
	 */

	/**
	 * Causes the {@code Animal} to die, if and only if the animal is not already dead.
	 */

	/**
	 * Compares two objects for their equality. A {@code Mammal} is equal to another {@code Mammal} if they are both
	 * not cold blooded, both warm blooded, both give live birth, both live in the same habitat, and have the same
	 * number of legs.
	 *
	 * @param o The {@code Object} to compare to.
	 * @return the equality state of the two objects after comparison.
	 */

	/**
	 * Returns a {@code String} representing this {@code Capybara}, formatted as so:
	 * <p>
	 * Capybara[isColdBlooded, isWarmBlooded, isLiveBirth, numLegs, habitat]
	 *
	 * @return a formatted String repreesenting an {@code Capybara}, formatted like above.
	 */
}