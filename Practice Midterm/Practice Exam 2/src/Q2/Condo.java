package Q2;

@SuppressWarnings("unused")
public class Condo extends Home {

	/**
	 * The {@code Condo} constructor takes a parameter of the number of bedrooms and bathrooms in this condo, and
	 * makes a super call to the parent class, {@code Home}. In addition, it will set {@code hasBackyard} to false.
	 *
	 * @param bed  the number of bedrooms in this condo.
	 * @param bath the number of bathrooms in this condo.
	 */
	public Condo(int bed, int bath) {
		super(bed, bath);
		hasBackyard = false;
	}

	/**
	 * The {@code String} representation of this {@code Condo}, formatted like so:
	 * <p>
	 * Condo[bedroomCount, bathroomCount, hasBackyard]
	 *
	 * @return a {@code String} representation of the {@code Condo} object, formatted as shown above.
	 */
	public String toString() {
		return "Condo[" + super.getNumBedrooms() + ", " + super.getNumBathrooms() + ", " + hasBackyard() + "]";
	}


}
