package Q2;

@SuppressWarnings("unused")
public class Townhouse extends Home {

	/**
	 * The {@code Townhouse} constructor takes a parameter of the number of bedrooms and bathrooms in this townhouse,
	 * and makes a super call to the parent class, {@code Home}.
	 * In addition, it will set {@code hasBackyard} to true.
	 *
	 * @param bed  the number of bedrooms in this studio apartment.
	 * @param bath the number of bathrooms in this studio apartment.
	 */
	public Townhouse(int bed, int bath) {
		super(bed, bath);
		hasBackyard = true;
	}

	/**
	 * The {@code String} representation of this {@code Townhouse}, formatted like so:
	 * <p>
	 * Townhouse[bedroomCount, bathroomCount, hasBackyard]
	 *
	 * @return a {@code String} representation of the {@code Townhouse} object, formatted as shown above.
	 */
	@Override
	public String toString() {
		return "Townhouse[" + super.getNumBedrooms() + ", " + super.getNumBathrooms() + ", " + hasBackyard() + "]";
	}


}
