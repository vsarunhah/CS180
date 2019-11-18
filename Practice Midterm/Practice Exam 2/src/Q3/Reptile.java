package Q3;

@SuppressWarnings("unused")
public abstract class Reptile implements Animal {

	private final String habitat;
	private final boolean laysEggs;
	private final boolean isNocturnal;
	private final int numLegs;
	@SuppressWarnings("WeakerAccess")
	protected int energy;

	/**
	 * A constructor for an {@code Reptile}, that takes four parameters = one {@code String} representing the habitat
	 * of this {@code Animal}, one {@code int} representing the number of legs this animal has if it has any, one
	 * {@code boolean} representing if this {@code Animal} lays eggs, and one {@code boolean} representing if this
	 * animal is nocturnal or not.
	 *
	 * @param habitat     the habitat of this {@code Animal}.
	 * @param numLegs     the number of legs that this {@code Animal} has.
	 * @param laysEggs    true if this {@code Animal} lays eggs.
	 * @param isNocturnal true if this {@code Animal} is nocturnal.
	 */
	@SuppressWarnings("WeakerAccess")
	public Reptile(String habitat, int numLegs, boolean laysEggs, boolean isNocturnal) {
		this.habitat = habitat;
		this.numLegs = numLegs;
		this.laysEggs = laysEggs;
		this.isNocturnal = isNocturnal;
		this.energy = 0;
	}

	/**
	 * Returns true if this {@code Animal} has more than 0 legs.
	 *
	 * @return true if this {@code Animal} has more than 0 legs, false otherwise.
	 */
	public boolean hasLegs() {
		return numLegs > 0;
	}

	/**
	 * Returns the number of legs that this {@code Animal} has, if it has any legs.
	 *
	 * @param hasLegs a boolean that represents whether the {@code Animal} has legs or not.
	 * @return the number of legs that this {@code Animal} has, if it has any legs.
	 */
	public int numLegs(boolean hasLegs) {
		return hasLegs ? numLegs : 0;
	}

	/**
	 * Returns the habitat of this {@code Animal}.
	 *
	 * @return the habitat of this {@code Animal}.
	 */
	public String getHabitat() {
		return habitat;
	}

	/**
	 * Returns true if this {@code Animal} lays eggs.
	 *
	 * @return true if this {@code Animal} lays eggs, false otherwise.
	 */
	@SuppressWarnings("WeakerAccess")
	public boolean laysEggs() {
		return laysEggs;
	}

	/**
	 * Returns true if this {@code Animal} is nocturnal.
	 *
	 * @return true if this {@code Animal} is nocturnal.
	 */
	@SuppressWarnings("WeakerAccess")
	public boolean isNocturnal() {
		return isNocturnal;
	}

	/**
	 * An abstract method that returns whether this {@code Reptile} is cold blooded.
	 *
	 * @return whether this {@code Reptile} is cold blooded.
	 */
	public abstract boolean isColdBlooded();

	/**
	 * An abstract method that returns whether this {@code Reptile} is warm blooded.
	 *
	 * @return whether this {@code Reptile} is warm blooded.
	 */
	public abstract boolean isWarmBlooded();

	/**
	 * An abstract method that causes this {@code Reptile} to shed its skin, subsequently setting its life energy
	 * back to 0.
	 */
	public abstract void shedSkin();
}
