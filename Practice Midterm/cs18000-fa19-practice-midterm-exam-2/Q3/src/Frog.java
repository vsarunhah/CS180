public class Frog {
	/**
	 * Whether or not this frog is warm blooded.
	 */

	/**
	 * Whether or not this frog is cold blooded.
	 */

	/**
	 * A constructor for class {@code Frog}. It takes three parameters, where one is a {@code String} habitat,
	 * and one is an {@code int} numLegs. It will make a super call to its parent constructor, {@code Amphibian}, and
	 * then set {@code isWarmBlooded} to false, and {@code isColdBlooded} to true.
	 *
	 * @param habitat the habitat that this {@code Frog} lives in.
	 * @param numLegs the number of legs that this {@code Frog} lives in.
	 */

	/**
	 * Returns whether this {@code Amphibian} is cold blooded. {@code Amphibian}s are cold blooded.
	 *
	 * @return the cold blooded state of this {@code Animal}.
	 */

	/**
	 * Returns whether this {@code Amphibian} is warm blooded. {@code Amphibians}s are not warm blooded.
	 *
	 * @return the warm blooded state of this {@code Animal}.
	 */

	/**
	 * Consumes food, incrementing energy, if and only if the {@code Animal} is not dead.
	 *
	 * @param numFood the amount of food to consume.
	 */

	/**
	 * Reproduces an {@code Animal} of type {@code Frog} if and only if the animal is not dead. The offspring
	 * will have the same properties as its parent.
	 *
	 * @return a new {@code Frog} with the same properties of the parent, if and only if the parent is not dead.
	 * If the parent is dead, the method will return {@code null}.
	 */


	/**
	 * Causes the {@code Animal} to die, if and only if the animal is not already dead.
	 */

	/**
	 * Compares two objects for their equality. A {@code Amphibian} is equal to another {@code Amphibian} if they are
	 * both cold blooded, both not warm blooded, both live in the same habitat, and have the same
	 * number of legs.
	 *
	 * @param o The {@code Object} to compare to.
	 * @return the equality state of the two objects after comparison.
	 */

	/**
	 * Returns a {@code String} representing this {@code Frog}, formatted as so:
	 * <p>
	 * Frog[isColdBlooded, isWarmBlooded, numLegs, habitat]
	 *
	 * @return a formatted String repreesenting an {@code Frog}, formatted like above.
	 */
}