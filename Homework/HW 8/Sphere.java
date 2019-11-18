/**
 * Sphere object
 * @author varun
 * @version 1.0
 */
public class Sphere implements ThreeDimensionalShape {
    private double radius;
    private double thickness;
    private String name;

    /**
     * constructs sphere object
     * @param radius
     * @param thickness
     * @throws UnexpectedSideLengthException
     */
    public Sphere(double radius, double thickness) throws UnexpectedSideLengthException {
        if (thickness == 0) {
            name = "Sphere";
        } else if (thickness > 0) {
            name = "Ball";
        }
        if (thickness < 0.0 || radius < 0.0) {
            throw new UnexpectedSideLengthException();
        }
        this.thickness = thickness;
        this.radius = radius;
    }

    /**
     * returns sidelength
     * @return sidelength
     */
    @Override
    public double getSideLength() {
        return 0;
    }

    /**
     * calculates volume
     * @return volume
     */
    @Override
    public double calculateVolume() {
        return ((4.0 / 3.0) * Math.PI) * Math.pow(radius, 3);
    }

    /**
     * calculates surface area
     * @return
     */
    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
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
     * @return
     */
    @Override
    public int getNumSides() {
        return 0;
    }

    /**
     * calculates perimeter
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        return 0;
    }

    /**
     * returns radius
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * returns thickness
     * @return thickness
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * checks if objects are equal
     * @param o
     * @return equality boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Sphere) {
            Sphere c = (Sphere) o;
            return c.getName().equals(getName()) && c.getRadius() == getRadius() && c.getThickness() == getThickness();
        }
        return false;
    }

    /**
     * converts object into string formatted
     * @return formatted string
     */
    @Override
    public String toString() {
        String rad = String.format("%.2f", getRadius());
        String thick = String.format("%.2f", getThickness());
        String names = getName();
        String vol = String.format("%.2f", calculateVolume());
        String sa = String.format("%.2f", calculateSurfaceArea());
        return "Sphere[" + rad + ", " + thick + ", " + names +
                ", " + vol + ", " + sa + "]";
    }
}
