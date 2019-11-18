package Q3;

@SuppressWarnings("unused")
public class Frog extends Amphibian {

	private final boolean isColdBlooded;
	private final boolean isWarmBlooded;

	/**
	 * A constructor for class {@code Frog}. It takes three parameters, where one is a {@code String} habitat,
	 * and one is an {@code int} numLegs. It will make a super call to its parent constructor, {@code Amphibian}, and
	 * then set {@code isWarmBlooded} to false, and {@code isColdBlooded} to true.
	 *
	 * @param habitat the habitat that this {@code Frog} lives in.
	 * @param numLegs the number of legs that this {@code Frog} lives in.
	 */
	@SuppressWarnings("WeakerAccess")
	public Frog(String habitat, int numLegs) {
		super(habitat, numLegs);
		isWarmBlooded = false;
		isColdBlooded = true;
	}

	/**
	 * Returns whether this {@code Amphibian} is cold blooded. {@code Amphibian}s are cold blooded.
	 *
	 * @return the cold blooded state of this {@code Animal}.
	 */
	@Override
	public boolean isColdBlooded() {
		return isColdBlooded;
	}

	/**
	 * Returns whether this {@code Amphibian} is warm blooded. {@code Amphibians}s are not warm blooded.
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
	 * Reproduces an {@code Animal} of type {@code Frog} if and only if the animal is not dead. The offspring
	 * will have the same properties as its parent.
	 *
	 * @return a new {@code Frog} with the same properties of the parent, if and only if the parent is not dead.
	 * If the parent is dead, the method will return {@code null}.
	 */
	@Override
	public Amphibian reproduce() {
		if (energy != -1) {
			return new Frog(super.getHabitat(), 4);
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
	 * Compares two objects for their equality. A {@code Amphibian} is equal to another {@code Amphibian} if they are
	 * both cold blooded, both not warm blooded, both live in the same habitat, and have the same
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
		Amphibian amp = (Amphibian) o;
		return amp.isColdBlooded() == this.isColdBlooded() & amp.isWarmBlooded() == this.isWarmBlooded() &
				amp.hasLegs() == this.hasLegs() & amp.getHabitat().equals(this.getHabitat()) &
				amp.numLegs(amp.hasLegs()) == this.numLegs(amp.hasLegs());
	}

	/**
	 * Returns a {@code String} representing this {@code Frog}, formatted as so:
	 * <p>
	 * Frog[isColdBlooded, isWarmBlooded, numLegs, habitat]
	 *
	 * @return a formatted String repreesenting an {@code Frog}, formatted like above.
	 */
	@Override
	public String toString() {
		return "Frog[" + isColdBlooded() + ", " + isWarmBlooded() + ", " + numLegs(hasLegs()) + ", " + getHabitat() + "]";
	}
}
