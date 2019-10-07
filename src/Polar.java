import java.text.DecimalFormat;
/**
 * Polar
 *
 * A polar point in a two-dimensional plane.
 *
 * @author Varun Shah, B13
 * @version 23/09/2019
 *
 */

public class Polar {
    private double r;  // The r coordinate of this polar point.
    private double theta;  // The theta coordinate of this polar point.

    /**
     * Calculates and returns the charge for shipping cargo
     * between two planets.
     *
     * @param r r coordinate of this polar point
     * @param theta theta coordinate of this polar point
     */
    public Polar(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    /**
     * Constructs a newly allocated Cartesian object with a default x and y coordinate of 0.0.
     */
    public Polar() {
        this.r = 0;
        this.theta = 0;
    }

    /**
     * Returns the r coordinate of this polar point.
     * @return returns r coordinate of the polar point
     */
    public double getR() {
        return r;
    }

    /**
     * Returns the theta coordinate of this polar point.
     * @return returns theta coordinate of the polar point
     */
    public double getTheta() {
        return theta;
    }

    /**
     * Converts this polar point to a Cartesian point.
     *
     * @return Returns this polar point as a Cartesian point.
     */
    public Cartesian toCartesian() {
        double x = r * Math.cos(theta);
        double y = r * Math.sin(theta);
        return new Cartesian(x, y);
    }

    /**
     * Calculates and returns the distance between this Cartesian point and another one.
     *
     * @param polar polar point between which the distance is being calculated
     * @return Returns the distance between this polar point and the specified polar point.
     */
    public double getDistance(Polar polar) {
        Cartesian thisPolar = toCartesian();
        Cartesian passedPolar = polar.toCartesian();
        double d = thisPolar.getDistance(passedPolar);
        return d;
    }

    /**
     * Returns the String representation of this polar point.
     *
     * @return Returns the String representation of this polar point.
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.000000");
        return "(" + df.format(getR()) + ", " + df.format(getTheta()) + ")";
    }
}