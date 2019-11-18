public class Home {
	/**
	 * The number of bedrooms of this home.
	 */
	private final int numBedrooms;
	/**
	 * The number of bathrooms of this home.
	 */
	private final int numBathrooms;
	/**
	 * Whether or not this home has a backyard.
	 */
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
	public Home(int numBed, int numBath) {
		this.numBedrooms = numBed;
		this.numBathrooms = numBath;
		hasBackyard = true;
	}
	/**
	 * Returns the number of bedrooms in this {@code Home}.
	 *
	 * @return the number of bedrooms in this {@code Home}.
	 */
	public int getNumBedrooms() {
		return numBedrooms;
	}
	/**
	 * Returns the number of bathrooms in this {@code Home}.
	 *
	 * @return the number of bathrooms in this {@code Home}.
	 */
	public int getNumBathrooms() {
		return numBathrooms;
	}
	/**
	 * Returns whether this {@code Home} has a backyard or not.
	 *
	 * @return whether this {@code Home} has a backyard or not.
	 */
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
	@Override
	public String toString(){
		return "Home[" + getNumBedrooms() +", " + getNumBathrooms() + ", " + hasBackyard() + "]";
	}
}