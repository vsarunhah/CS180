package Q3;

@SuppressWarnings("unused")
public class Capybara extends Mammal {

	private final boolean isWarmBlooded;
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
	@SuppressWarnings("WeakerAccess")
	public Capybara(String habitat, int numLegs, boolean isLiveBirth) {
		super(habitat, numLegs, isLiveBirth);
		this.isWarmBlooded = true;
		this.isColdBlooded = false;
	}

	/**
	 * Returns whether this {@code Mammal} is cold blooded. {@code Mammal}s are not cold blooded.
	 *
	 * @return the cold blooded state of this {@code Animal}.
	 */
	@Override
	public boolean isColdBlooded() {
		return isColdBlooded;
	}

	/**
	 * Returns whether this {@code Mammal} is warm blooded. {@code Mammal}s are warm blooded.
	 *
	 * @return the warm blooded state of this {@code Animal}.
	 */
	@Override
	public boolean isWarmBlooded() {
		return isWarmBlooded;
	}

	/**
	 * Consumes food, incrementing energy, if and only if the {@code Animal} is not dead.
	 *
	 * @param numFood the amount of food to consume.
	 */
	@Override
	public void consumeFood(int numFood) {
		if (energy != -1) {
			energy += numFood;
		}
	}

	/**
	 * Reproduces an {@code Animal} of type {@code Capybara} if and only if the animal is not dead. The offspring
	 * will have the same properties as its parent.
	 *
	 * @return a new {@code Capybara} with the same properties of the parent, if and only if the parent is not dead.
	 * If the parent is dead, the method will return {@code null}.
	 */
	@Override
	public Mammal reproduce() {
		if (energy != -1) {
			return new Capybara(super.getHabitat(), 4, true);
		} else {
			return null;
		}
	}

	/**
	 * Causes the {@code Animal} to die, if and only if the animal is not already dead.
	 */
	@Override
	public void die() {
		if (energy != -1) {
			energy = -1;
		}
	}

	/**
	 * Compares two objects for their equality. A {@code Mammal} is equal to another {@code Mammal} if they are both
	 * not cold blooded, both warm blooded, both give live birth, both live in the same habitat, and have the same
	 * number of legs.
	 *
	 * @param o The {@code Object} to compare to.
	 * @return the equality state of the two objects after comparison.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}

		Mammal mam = (Mammal) o;

		return mam.isColdBlooded() == this.isColdBlooded() & mam.isWarmBlooded() == this.isWarmBlooded() &
				mam.isLiveBirth() == this.isLiveBirth() & mam.getHabitat().equals(this.getHabitat()) &
				this.numLegs(this.hasLegs()) == mam.numLegs(mam.hasLegs());
	}

	/**
	 * Returns a {@code String} representing this {@code Capybara}, formatted as so:
	 * <p>
	 * Capybara[isColdBlooded, isWarmBlooded, isLiveBirth, numLegs, habitat]
	 *
	 * @return a formatted String repreesenting an {@code Capybara}, formatted like above.
	 */
	@Override
	public String toString() {
		return "Capybara[" + isColdBlooded() + ", " + isWarmBlooded() + ", " + isLiveBirth() + ", " +
				numLegs(hasLegs()) + ", " + getHabitat() + "]";
	}
}
