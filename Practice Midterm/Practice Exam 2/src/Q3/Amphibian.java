package Q3;

@SuppressWarnings("WeakerAccess")
public abstract class Amphibian implements Animal {

	private final String habitat;
	private final int numLegs;
	protected int energy;

	/**
	 * A constructor for the abstract class {@code Amphibian}. It take a {@code String} habitat and a {@code int}
	 * numLegs, and sets the two local equivalents to the parameters passed in. It also initializes {@code energy} to 0.
	 *
	 * @param habitat the habitat which this {@code Amphibian} lives in.
	 * @param numLegs the number of legs that this {@code Amphibian} has.
	 */
	public Amphibian(String habitat, int numLegs) {
		this.habitat = habitat;
		this.numLegs = numLegs;
		this.energy = 0;
	}

	/**
	 * Returns true if this {@code Amphibian} has more than 0 legs.
	 *
	 * @return true if this {@code Amphibian} has more than 0 legs.
	 */
	public boolean hasLegs() {
		return numLegs > 0;
	}

	/**
	 * Returns the number of legs that this {@code Amphibian} has if it has legs
	 *
	 * @param hasLegs a boolean that represents whether the {@code Animal} has legs or not.
	 * @return the number of legs that this {@code Amphibian} has if it has legs. If it does not have legs, it will
	 * return 0.
	 */
	public int numLegs(boolean hasLegs) {
		return hasLegs ? numLegs : 0;
	}

	/**
	 * Returns the habitat of this {@code Amphibian}
	 *
	 * @return the habitat of this {@code Amphibian}
	 */
	public String getHabitat() {
		return habitat;
	}

	/**
	 * An abstract method that returns whether this {@code Amphibian} is cold blooded.
	 *
	 * @return whether this {@code Amphibian} is cold blooded.
	 */
	public abstract boolean isColdBlooded();

	/**
	 * An abstract method that returns whether this {@code Amphibian} is warm blooded.
	 *
	 * @return whether this {@code Amphibian} is warm blooded.
	 */
	public abstract boolean isWarmBlooded();
}
