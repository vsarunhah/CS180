package Q3;

@SuppressWarnings("unused")
public class Iguana extends Reptile {

	private final boolean isColdBlooded;
	private final boolean isWarmBlooded;

	/**
	 * A constructor for class {@code Iguana}. It takes four parameters, where one is a {@code String} habitat,
	 * one is an {@code int} numLegs, one is a {@code boolean} laysEggs, and one is a {@code boolean} isNocturnal. It
	 * will make a super call to its parent constructor, {@code Reptile}, and then set {@code isWarmBlooded} to
	 * false, and {@code isColdBlooded} to true.
	 *
	 * @param habitat     the habitat that this {@code Reptile} lives in.
	 * @param numLegs     the number of legs that this {@code Reptile} has.
	 * @param laysEggs    true if this {@code Reptile} lays eggs
	 * @param isNocturnal true if this {@code Reptile} is nocturnal.
	 */
	@SuppressWarnings({"WeakerAccess", "unused"})
	public Iguana(String habitat, int numLegs, boolean laysEggs, boolean isNocturnal) {
		super(habitat, numLegs, laysEggs, isNocturnal);
		this.isWarmBlooded = false;
		this.isColdBlooded = true;
	}

	/**
	 * Returns the state of if this {@code Reptile} is considered cold blooded. {@code Reptile}s are considered cold
	 * blooded.
	 *
	 * @return the cold blooded state of this {@code Animal}. {@code Reptile}s are considered cold blooded.
	 */
	@Override
	public boolean isColdBlooded() {
		return isColdBlooded;
	}

	/**
	 * Returns the state of if this {@code Reptile} is considered warm blooded. {@code Reptile}s are considered to be
	 * not warm blooded.
	 *
	 * @return the warm blooded state of this {@code Animal}. {@code Reptile}s are not considered to be warm blooded.
	 */
	@Override
	public boolean isWarmBlooded() {
		return isWarmBlooded;
	}

	/**
	 * Resets this {@code Reptile}'s energy to 0, if and only if the {@code Reptile} is alive.
	 */
	@Override
	public void shedSkin() {
		if (energy != -1) {
			energy = 0;
		}
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
	 * Reproduces an {@code Animal} of type {@code Iguana} if and only if the animal is not dead. The offspring
	 * will have the same properties as its parent.
	 *
	 * @return a new {@code Iguana} with the same properties of the parent, if and only if the parent is not dead.
	 * If the parent is dead, the method will return {@code null}.
	 */
	@Override
	public Reptile reproduce() {
		if (energy != -1) {
			return new Iguana(super.getHabitat(), super.numLegs(super.hasLegs()), super.laysEggs(), super.isNocturnal());
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
	 * Compares two objects for their equality. A {@code Reptile} is equal to another {@code Reptile} if they are
	 * both cold blooded, both not warm blooded, both live in the same habitat, have the same
	 * number of legs, both nocturnal, and both lay eggs.
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

		Reptile rep = (Reptile) o;

		return rep.isColdBlooded() == this.isColdBlooded() & rep.isWarmBlooded() == this.isWarmBlooded() &
				rep.isNocturnal() == this.isNocturnal() & rep.laysEggs() == this.laysEggs() &
				rep.numLegs(rep.hasLegs()) == this.numLegs(rep.hasLegs());
	}

	/**
	 * Returns a {@code String} representing this {@code Iguana}, formatted as so:
	 * <p>
	 * Iguana[isColdBlooded, isWarmBlooded, isNocturnal, numLegs, habitat]
	 *
	 * @return a formatted String repreesenting an {@code Iguana}, formatted like above.
	 */
	public String toString() {
		return "Iguana[" + this.isColdBlooded() + ", " + this.isWarmBlooded() + ", " + this.isNocturnal() + ", " +
				this.laysEggs() + ", " + this.numLegs(this.hasLegs()) + ", " + this.getHabitat() + "]";
	}
}
