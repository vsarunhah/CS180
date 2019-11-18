/**
 * Cube object
 * @author varun
 * @version 1.0
 */
public class Cube implements ThreeDimensionalShape {
    private String name;
    private double sideLength;

    /**
     * Constructs cube object
     * @param sideLength
     * @throws UnexpectedSideLengthException
     */
    public Cube(double sideLength) throws UnexpectedSideLengthException {
        this.name = "Cube";
        if (sideLength < 0.0) {
            throw new UnexpectedSideLengthException();
        }
        this.sideLength = sideLength;
    }

    /**
     * Returns sidelength
     * @return sidelength
     */
    @Override
    public double getSideLength() {
        return sideLength;
    }

    @Override
    /**
     * Calculates volume
     * @return volume
     */
    public double calculateVolume() {
        return Math.pow(sideLength, 3);
    }

    @Override
    /**
     * Calculates surface area
     * @return surface area
     */
    public double calculateSurfaceArea() {
        return (6 * Math.pow(sideLength, 2));
    }

    /**
     * returns name
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * returns number of sides
     * @return number of sides
     */
    @Override
    public int getNumSides() {
        return 6;
    }

    /**
     * calculates perimeter
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        return (12 * sideLength);
    }

    /**
     * Checks if objects are same
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Cube) {
            Cube c = (Cube) o;
            return c.getName().equals(getName()) && c.getSideLength() == getSideLength();
        }
        return false;
    }

    /**
     * Returns string of object
     * @return formatted string
     */
    @Override
    public String toString() {
        String sid = String.format("%.2f", getSideLength());
        String peri = String.format("%.2f", calculatePerimeter());
        String vol = String.format("%.2f", calculateVolume());
        String sa = String.format("%.2f", calculateSurfaceArea());
        return "Cube[" + sid + ", " + peri + ", " + vol +
                ", " + sa + "]";
    }
}
