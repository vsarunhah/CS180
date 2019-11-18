public abstract class Mammal implements Animal{
	/**
	 * The habitat of this mammal.
	 */
	private final String habitat;
	/**
	 * Whether or not this mammal does live birth.
	 */
	private final boolean isLiveBirth;
	/**
	 * The number of legs of this mammal.
	 */
	private final int numLegs;
	/**
	 * The energy of this mammal.
	 */
	protected int energy;
	/**
	 * A constructor for {@code Mammal}, that takes three parameters - one {@code String} representing the habitat of
	 * this {@code Mammal}, one {@code int} representing the number of legs of this animal, and one {@code boolean}
	 * representing whether this animal does live birth.
	 *
	 * @param habitat     represents the habitat of this {@code Animal}
	 * @param numLegs     represents the number of legs of this {@code Animal}
	 * @param isLiveBirth represents if this {@code Animal} does live birth.
	 */
	public Mammal(String habitat, int numLegs, boolean isLiveBirth) {
		this.habitat = habitat;
		this.isLiveBirth = isLiveBirth;
		this.numLegs = numLegs;
	}
	/**
	 * Returns true if this {@code Animal} does live birth, false otherwise.
	 *
	 * @return true if this {@code Animal} does live birth, false otherwise.
	 */
	public boolean isLiveBirth(){
		return isLiveBirth;
	}
	/**
	 * Returns true if this {@code Animal} has more than 0 legs, false otherwise.
	 *
	 * @return true if this {@code Animal} has more than 0 legs, false otherwise.
	 */
	public boolean hasLegs(){
		return numLegs > 0;
	}
	/**
	 * Returns the number of legs if this {@code Animal} has legs, or 0 otherwise.
	 *
	 * @param hasLegs a boolean that represents whether the {@code Animal} has legs or not.
	 * @return the number of legs if this {@code Animak} has legs, or 0 otherwise.
	 */
	public int numLegs(boolean hasLegs){
		if(!hasLegs){
			return 0;
		}
		return numLegs;
	}
	/**
	 * Returns the habitat of this {@code Animal}.
	 *
	 * @return the habitat of this {@code Animal}.
	 */
	@Override
	public String getHabitat() {
		return habitat;
	}
	/**
	 * An abstract method that when implemented, returns true if this {@code Animal} is cold blooded, or false
	 * otherwise.
	 *
	 * @return true if this {@code Animal} is cold blooded, false otherwise.
	 */
	public abstract boolean isColdBlooded();
	/**
	 * An abstract method that when implemented, returns true if this {@code Animal} is warm blooded, or false
	 * otherwise.
	 *
	 * @return true if this {@code Animal} is warm blooded, false otherwise.
	 */
	public abstract boolean isWarmBlooded();
}