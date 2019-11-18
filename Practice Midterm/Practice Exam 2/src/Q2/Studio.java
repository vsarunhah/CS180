package Q2;

@SuppressWarnings("unused")
public class Studio extends Home {

	/**
	 * The {@code Studio} constructor takes a parameter of the number of bedrooms and bathrooms in this studio
	 * apartment, and makes a super call to the parent class, {@code Home}.
	 * In addition, it will set {@code hasBackyard} to false.
	 *
	 * @param bed  the number of bedrooms in this studio apartment.
	 * @param bath the number of bathrooms in this studio apartment.
	 */
	public Studio(int bed, int bath) {
		super(bed, bath);
		hasBackyard = false;
	}

	/**
	 * The {@code String} representation of this {@code Studio}, formatted like so:
	 * <p>
	 * Studio[bedroomCount, bathroomCount, hasBackyard]
	 *
	 * @return a {@code String} representation of the {@code Studio} object, formatted as shown above.
	 */
	@Override
	public String toString() {
		return "Studio[" + super.getNumBedrooms() + ", " + super.getNumBathrooms() + ", " + hasBackyard() + "]";
	}
}
