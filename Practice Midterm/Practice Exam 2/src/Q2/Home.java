package Q2;

@SuppressWarnings("unused")
public class Home {
	private final int numBedrooms;
	private final int numBathrooms;
	@SuppressWarnings("WeakerAccess")
	protected boolean hasBackyard;

	/**
	 * The constructor for a {@code Home} object, that takes two {@code int} parameters, with one representing the
	 * number of bathrooms in the {@code Home}, and one representing the number of bedrooms in the {@code Home}. To
	 * be the most optimistic, every {@code Home} will have a backyard, unless a child class extends it and defines
	 * it as otherwise.
	 *
	 * @param numBed  the number of bedrooms in this home.
	 * @param numBath the number of bathrooms in this home.
	 */
	@SuppressWarnings("WeakerAccess")
	public Home(int numBed, int numBath) {
		this.numBedrooms = numBed;
		this.numBathrooms = numBath;
		this.hasBackyard = true;
	}

	/**
	 * Returns the number of bedrooms in this {@code Home}.
	 *
	 * @return the number of bedrooms in this {@code Home}.
	 */
	@SuppressWarnings("WeakerAccess")
	public int getNumBedrooms() {
		return numBedrooms;
	}

	/**
	 * Returns the number of bathrooms in this {@code Home}.
	 *
	 * @return the number of bathrooms in this {@code Home}.
	 */
	@SuppressWarnings("WeakerAccess")
	public int getNumBathrooms() {
		return numBathrooms;
	}

	/**
	 * Returns whether this {@code Home} has a backyard or not.
	 *
	 * @return whether this {@code Home} has a backyard or not.
	 */
	@SuppressWarnings("WeakerAccess")
	public boolean hasBackyard() {
		return hasBackyard;
	}

	/**
	 * Returns the {@code String} representation of this {@code Home}, where it is formatted as:
	 * <p>
	 * Home[bedroomCount, bathroomCount, hasBackyard]
	 *
	 * @return the {@code String} representation of this {@code Home}, formatted as shown above.
	 */
	public String toString() {
		return "Home[" + numBedrooms + ", " + numBathrooms + ", " + hasBackyard() + "]";
	}

}
