/**
 * Interface for 3D Shape
 * @author Varun
 * @version 1.0
 */
public interface ThreeDimensionalShape {
    /**
     * Returns sidelength
     * @return sidelength
     */
    double getSideLength();

    /**
     * Calculates volume
     * @return volume
     */
    double calculateVolume();

    /**
     * Calculates surface area
     * @return surface area
     */
    double calculateSurfaceArea();

    /**
     * returns name of object
     * @return name
     */
    String getName();

    /**
     * returns number of sides
     * @return numSides
     */
    int getNumSides();

    /**
     * calculates perimeter
     * @return perimeter
     */
    double calculatePerimeter();
}
