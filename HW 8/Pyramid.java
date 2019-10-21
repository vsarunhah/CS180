/**
 * Pyramid object
 * @author varun
 * @version 1.0
 */
public class Pyramid implements ThreeDimensionalShape {
    private String name;
    private double length;
    private double height;

    /**
     * constructs pyramid object.
     * @param length
     * @param height
     * @throws UnexpectedSideLengthException
     */
    public Pyramid(double length, double height) throws UnexpectedSideLengthException {
        this.name = "Pyramid";
        if (length < 0.0 || height < 0.0) {
            throw new UnexpectedSideLengthException();
        }
        this.length = length;
        this.height = height;
    }

    /**
     * returns sidelength
     * @return sidelength
     */
    @Override
    public double getSideLength() {
        return length;
    }

    /**
     * returns height of pyramid
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * calculates volume
     * @return volume
     */
    @Override
    public double calculateVolume() {
        return ((length * length * height) / 3);
    }

    /**
     * calculates surface area
     * @return
     */
    @Override
    public double calculateSurfaceArea() {
        return length * (length + Math.pow(length * length + (4 * height * height), 0.5));
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
     * @return sides
     */
    @Override
    public int getNumSides() {
        return 4;
    }

    /**
     * calculates perimeter
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        return (4 * (height * height + (length * length / 4.0))) + (4 * length);
    }

    /**
     * checks if objects are equal
     * @param o
     * @return equality boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pyramid) {
            return ((Pyramid) o).getHeight() == getHeight() && ((Pyramid) o).getSideLength() == getSideLength() &&
                    ((Pyramid) o).getName().equals(getName());
        }
        return false;
    }

    /**
     * returns object string
     * @return string
     */
    @Override
    public String toString() {
        String sid = String.format("%.2f", getSideLength());
        String hei = String.format("%.2f", getHeight());
        String peri = String.format("%.2f", calculatePerimeter());
        String vol = String.format("%.2f", calculateVolume());
        String sa = String.format("%.2f", calculateSurfaceArea());
        return "Pyramid[" + sid + ", " + hei + ", " + peri + ", " + vol
                + ",    " + sa + "]";
    }
}
