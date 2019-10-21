import static java.lang.Math.sqrt;

/**
 * The {@code Color} class defines what a color is. It has an R, G, and B value, representing the individual
 * red, green, or blue value in the RGB colorspace. This class also has a method in order to calculate the distance
 * from one color to another, therein following the Euclidean Color Approximation Theorem. It also has a method
 * made for decomposing the color from a Color object into a String array representation of its R, G, and B values.
 * @author CS180 group
 * @version 1.0
 */
@SuppressWarnings("WeakerAccess")
public class Color {

    private String name;
    private int r;
    private int g;
    private int b;

    /**
     * The {@code Color} method should take a parameter of a {@code String}, and three integers. It should
     * construct an object of this, and instantiate the local variables with the parameters.
     *
     * @param name  The name of the color
     * @param red   The red value in the RGB colorspace
     * @param green The green value in the RGB colorspace
     * @param blue  The blue value in the RGB colorspace
     */
    @SuppressWarnings("WeakerAccess")
    public Color(String name, int red, int green, int blue) {
        this.name = name;
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    /**
     * Returns the name of the color
     *
     * @return the name of the color
     */
    @SuppressWarnings("WeakerAccess")
    public String getName() {
        return name;
    }

    /**
     * Returns the red value of the color
     *
     * @return the red value of the color
     */
    @SuppressWarnings("WeakerAccess")
    public int getRedValue() {
        return r;
    }

    /**
     * Returns the green value of the color
     *
     * @return the green value of the color
     */
    @SuppressWarnings("WeakerAccess")
    public int getGreenValue() {
        return g;
    }

    /**
     * Returns the blue value of the color
     *
     * @return the blue value of the color
     */
    @SuppressWarnings("WeakerAccess")
    public int getBlueValue() {
        return b;
    }

    /**
     * Calculates the distance between two colors, essentially comparing them and finding a number that can
     * be used to compare colors based on their RGB values, based on the Euclidean color distance.
     *
     * @param colorQuery The color to calculate the distance of, as compared to this object's color
     * @return The integer value of the color distance from a specific color
     */
    @SuppressWarnings("WeakerAccess")
    public int calculateColorDistance(Color colorQuery) {
        return (int) sqrt(Math.pow(getRedValue() - colorQuery.getRedValue(), 2) +
                Math.pow(getGreenValue() - colorQuery.getGreenValue(), 2) +
                Math.pow(getBlueValue() - colorQuery.getBlueValue(), 2));
    }

    /**
     * Decomposes a color into its individual RGB values, given as a {@code String} format like so:
     * <p>
     * red value, green value, blue value
     *
     * @return The color values separated by a comma and a space, in a single String.
     */
    @SuppressWarnings("WeakerAccess")
    public String decomposeColor() {
        return r + ", " + g + ", " + b;
    }

}
