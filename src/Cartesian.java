import java.text.DecimalFormat;
/**
 * Cartesian
 *
 * A Cartesian point in a two-dimensional plane.
 *
 * @author Varun Shah, B13
 * @version 23/09/2019
 *
 */

public class Cartesian {
    private double x;  // The x coordinate of this Cartesian point.
    private double y;  // The y coordinate of this Cartesian point.

    /**
     * Constructs a newly allocated Cartesian object with a default x and y coordinate of 0.0.
     */
    public Cartesian() {
        x = 0;
        y = 0;
    }

    /**
     * Constructs a new Cartesian object with the specified x and y coordinates
     *
     * @param x specified x coordinate of the new Cartesian point
     * @param y specified y coordinate of the new Cartesian point
     */
    public Cartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of this Cartesian point
     *
     * @return Returns the x coordinate of this Cartesian point.
     */
    public double getX() { // Returns the x coordinate of this Cartesian point.
        return x;
    }

    /**
     * Returns the y coordinate of this Cartesian point
     *
     * @return Returns the y coordinate of this Cartesian point.
     */
    public double getY() {
        return y;
    }

    /**
     * Calculates and returns the distance between this Cartesian point and another one.
     *
     * @param cartesian cartesian point between which the distance is being calculated
     * @return Returns the distance between this Cartesian point and the specified Cartesian point.
     */
    public double getDistance(Cartesian cartesian) {
        double d = 0;
        d = Math.sqrt((Math.pow(getX() - cartesian.getX(), 2)) + Math.pow(getY() - cartesian.getY(), 2));
        return d;
    }

    /**
     * Converts this Cartesian point to a polar point.
     *
     * @return Returns this Cartesian point as a polar point.
     */
    public Polar toPolar() {
        double r = Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
        double theta = Math.atan2(getY(), getX());
        return new Polar(r, theta);
    }

    /**
     * Returns the String representation of this Cartesian point.
     *
     * @return Returns the String representation of this Cartesian point.
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.000000");
        return "(" + df.format(getX()) + ", " + df.format(getY()) + ")";
    }

}