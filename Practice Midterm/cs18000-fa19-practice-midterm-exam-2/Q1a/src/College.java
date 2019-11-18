import java.util.ArrayList;

public class College {
	/**
	 * The classes of this college.
	 */
	private ArrayList<String> classes;
	/**
	 * The name of this college.
	 */
	private final String name;
	/**
	 * The location of this college.
	 */
	private final String location;
	/**
	 * The maximum number of classes of this college.
	 */
	private int maxClasses;
	/**
	 * The number of classes of this college.
	 */
	private int numClasses;
	/**
	 * The {@code College} constructor will take a {@code String} college name, {@code String} {@code College}
	 * location, and {@code int} maximum number of classes, and use these values to set the local fields with
	 * appropriate values. It will also instantiate an {@code ArrayList} that will hold each {@code String} that
	 * represents a {@code College} class, and set the number of classes offered by this {@code College} currently to 0.
	 *
	 * @param name       the name of the {@code College} that this class represents, ie, Purdue University.
	 * @param maxClasses the number of classes that this {@code College} offers
	 * @param location   the location that this {@code College} is, ie, West Lafayette.
	 */
	public College(String name, int maxClasses, String location){
		this.name = name;
		this.location = location;
		this.maxClasses = maxClasses;
		classes = new ArrayList<String>();
		numClasses = 0;
	}
	/**
	 * The {@code addClass} method takes in a {@code String} that represents a {@code College} class, and adds it to
	 * the {@code College}'s list of classes. In addition, as the class list increases, the number of courses that this
	 * {@code College} offers must be incremented by one.
	 *
	 * @param collegeClass the name of a class that this {@code College} offers.
	 */
	public void addClass(String collegeClass){
		classes.add(collegeClass);
		numClasses += 1;
	}
	/**
	 * The {@code getName} method will return the name of the {@code College} that this {@code College} object
	 * represents.
	 *
	 * @return the name of the {@code College} that this {@code College} object represents.
	 */
	public String getName() {
		return name;
	}
	/**
	 * The {@code getMaxNumClasses} method will return the number of classes that a College can offer.
	 *
	 * @return the maximum number of classes the {@code College} that this {@code College} object represents can have.
	 */
	public int getMaxNumClasses() {
		return maxClasses;
	}
	/**
	 * The {@code getNumClasses} returns the number of classes that this {@code College} currently offers.
	 *
	 * @return returns the number of classes offered by this {@code College}.
	 */
	public int getNumClasses() {
		return numClasses;
	}
	/**
	 * The {@code getLocation} method will return the location that this {@code College} is in.
	 *
	 * @return the location that this {@code College} is in.
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * The {@code getClasses} method will return the classes offered by this {@code College} in a list format. For
	 * example, if the {@code College} offers the following courses, which are stored in its {@code ArrayList} called
	 * {@code classes}:
	 * <p>
	 * Introduction to Sociology
	 * Foundations of Computer Science
	 * Programming in C
	 * Plane Analytic Geometry II
	 * <p>
	 * The method {@code getClasses} will return the contents of the {@code ArrayList}, shown above, in a format like
	 * so:
	 * <p>
	 * Introduction to Sociology, Foundations of Computer Science, Programming in C, Plane Analytic Geometry II
	 *
	 * @return the name of the courses offered by this {@code College}, in a {@code String} format, separated evenly
	 * by one comma and one space, except for the final entry in the list, which is followed by nothing.
	 */
	public String getClasses() {
		String s = "";
		for (int i = 0; i < classes.size(); i++){
			s += classes.get(i) + ", ";
		}
		s = s.substring(0,s.length()-2);
		return s;
	}
}