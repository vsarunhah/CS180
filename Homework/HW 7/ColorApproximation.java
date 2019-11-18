import java.util.ArrayList;
/**
 * The {@code ColorApproximation} class is designed to take in a {@code Color} object, and using the Euclidean
 * Color Approximation Theorem, names are approximated by finding the least distance to a color defined in the
 * color space.
 * @author CS180 group
 * @version 1.0
 */
@SuppressWarnings("WeakerAccess")
public class ColorApproximation {

    private int rValue;
    private int gValue;
    private int bValue;

    /**
     * The {@code ColorApproximation} constructor takes in a {@code Color} object. It should decompose
     * the passed in color into a String array by utilizing the {@code decomposeColor} method, and then
     * assign the {@code rValue}, {@code gValue}, and {@code bValue} fields to their respective values. In addition,
     * if the rValue that was generated was not between 0 and 255 both exclusive, then an
     * {@code UnsupportedColorSpectrumException} will be thrown.
     *
     * @param c The color to approximate
     * @throws UnsupportedColorSpectrumException thrown if the value in the file is above 255 or below 0.
     */
    @SuppressWarnings("WeakerAccess")
    public ColorApproximation(Color c) throws UnsupportedColorSpectrumException {
        String[] colors = c.decomposeColor().split(", ");
        rValue = Integer.parseInt(colors[0]);
        gValue = Integer.parseInt(colors[1]);
        bValue = Integer.parseInt(colors[2]);
        if (rValue < 0 | rValue > 255) {
            throw new UnsupportedColorSpectrumException("You can only input values that are" +
                    "between 0 and 255 both inclusive!");
        } else if (gValue < 0 | gValue > 255) {
            throw new UnsupportedColorSpectrumException("You can only input values that are" +
                    "between 0 and 255 both inclusive!");
        } else if (bValue < 0 | bValue > 255) {
            throw new UnsupportedColorSpectrumException("You can only input values that are" +
                    "between 0 and 255 both inclusive!");
        }
    }

    /**
     * The {@code approximateColor} method will calculate the smallest variance, or distance, from the provided color
     * spectrum to the color that was passed in.
     *
     * @return The name of the color closest to the red, green, and blue values passed in from the Color object.
     */
    public String approximateColor() {
        Color customColor = new Color(null, rValue, gValue, bValue);
        int smallestVariance = 1000;
        String nameOfMatch = "INVALID";
        for (Color c : mapColors()) {
            int variance = c.calculateColorDistance(customColor);
            if (variance < smallestVariance) {
                smallestVariance = variance;
                nameOfMatch = c.getName();
            }
        }
        return nameOfMatch;
    }

    /**
     * The {@code mapColors} method is a map that defines what colors are based on their RGB values. With this,
     * it also provides a name for the red green and blue values.
     *
     * @return The {@code ArrayList} of colors that are used for approximation.
     */
    private ArrayList<Color> mapColors() {
        final ArrayList<Color> colors = new ArrayList<>();
        colors.add(new Color("RED", 255, 0, 0));
        colors.add(new Color("BLUE", 0, 0, 255));
        colors.add(new Color("GREEN", 0, 128, 0));
        colors.add(new Color("ORANGE", 255, 128, 0));
        colors.add(new Color("YELLOW", 255, 255, 0));
        colors.add(new Color("INDIGO", 0, 0, 153));
        colors.add(new Color("VIOLET", 102, 0, 102));
        colors.add(new Color("MAGENTA", 255, 0, 255));
        colors.add(new Color("SILVER", 192, 192, 192));
        colors.add(new Color("BLACK", 0, 0, 0));
        colors.add(new Color("WHITE", 255, 255, 255));
        colors.add(new Color("MAROON", 128, 0, 0));
        colors.add(new Color("OLIVE", 128, 128, 0));
        colors.add(new Color("TEAL", 0, 128, 128));
        colors.add(new Color("NAVY", 0, 0, 128));
        colors.add(new Color("CYAN", 0, 255, 255));
        colors.add(new Color("LIME", 0, 255, 0));
        colors.add(new Color("GRAY", 128, 128, 128));
        colors.add(new Color("SNOW", 255, 250, 250));
        colors.add(new Color("SNOW 2", 238, 233, 233));
        colors.add(new Color("SNOW 3", 205, 201, 201));
        colors.add(new Color("SNOW 4", 139, 137, 137));
        colors.add(new Color("GHOST WHITE", 248, 248, 255));
        colors.add(new Color("WHITE SMOKE", 245, 245, 245));
        colors.add(new Color("GAINSBORO", 220, 220, 220));
        colors.add(new Color("FLORAL WHITE", 255, 250, 240));
        colors.add(new Color("OLD LACE", 253, 245, 230));
        colors.add(new Color("LINEN", 240, 240, 230));
        colors.add(new Color("ANTIQUE WHITE", 250, 235, 215));
        colors.add(new Color("ANTIQUE WHITE 2", 238, 223, 204));
        colors.add(new Color("ANTIQUE WHITE 3", 205, 192, 176));
        colors.add(new Color("ANTIQUE WHITE 4", 139, 131, 120));
        colors.add(new Color("PAPAYA WHIP", 255, 239, 213));
        colors.add(new Color("BLANCHED ALMOND", 255, 235, 205));
        colors.add(new Color("BISQUE", 255, 228, 196));
        colors.add(new Color("BISQUE 2", 238, 213, 183));
        colors.add(new Color("BISQUE 3", 205, 183, 158));
        colors.add(new Color("BISQUE 4", 139, 125, 107));
        colors.add(new Color("PEACH PUFF", 255, 218, 185));
        colors.add(new Color("PEACH PUFF 2", 238, 203, 173));
        colors.add(new Color("PEACH PUFF 3", 205, 175, 149));
        colors.add(new Color("PEACH PUFF 4", 139, 119, 101));
        colors.add(new Color("NAVAJO WHITE", 255, 222, 173));
        colors.add(new Color("MOCCASIN", 255, 228, 181));
        colors.add(new Color("CORNSILK", 255, 248, 220));
        colors.add(new Color("CORNSILK 2", 238, 232, 205));
        colors.add(new Color("CORNSILK 3", 205, 200, 177));
        colors.add(new Color("CORNSILK 4", 139, 136, 120));
        colors.add(new Color("IVORY", 255, 255, 240));
        colors.add(new Color("IVORY 2", 238, 238, 224));
        colors.add(new Color("IVORY 3", 205, 205, 193));
        colors.add(new Color("IVORY 4", 139, 139, 131));
        colors.add(new Color("LEMON CHIFFON", 255, 250, 205));
        colors.add(new Color("SEASHELL", 255, 245, 238));
        colors.add(new Color("SEASHELL 2", 238, 229, 222));
        colors.add(new Color("SEASHELL 3", 205, 197, 191));
        colors.add(new Color("SEASHELL 4", 139, 134, 130));
        colors.add(new Color("HONEYDEW", 240, 255, 240));
        colors.add(new Color("HONEYDEW 2", 244, 238, 224));
        colors.add(new Color("HONEYDEW 3", 193, 205, 193));
        colors.add(new Color("HONEYDEW 4", 131, 139, 131));
        colors.add(new Color("MINT CREAM", 245, 255, 250));
        colors.add(new Color("AZURE", 240, 255, 255));
        colors.add(new Color("ALICE BLUE", 240, 248, 255));
        colors.add(new Color("LAVENDER", 230, 230, 250));
        colors.add(new Color("LAVENDER BLUSH", 255, 240, 245));
        colors.add(new Color("MISTY ROSE", 255, 228, 225));
        colors.add(new Color("WHITE", 255, 255, 255));
        colors.add(new Color("BLACK", 0, 0, 0));
        colors.add(new Color("DARK SLATE GRAY", 49, 79, 79));
        colors.add(new Color("DIM GRAY", 105, 105, 105));
        colors.add(new Color("SLATE GRAY", 112, 138, 144));
        colors.add(new Color("LIGHT SLATE GRAY", 119, 136, 153));
        colors.add(new Color("GRAY", 190, 190, 190));
        colors.add(new Color("LIGHT GRAY", 211, 211, 211));
        colors.add(new Color("MIDNIGHT BLUE", 25, 25, 112));
        colors.add(new Color("NAVY", 0, 0, 128));
        colors.add(new Color("CORNFLOWER BLUE", 100, 149, 237));
        colors.add(new Color("DARK SLATE BLUE", 72, 61, 139));
        colors.add(new Color("SLATE BLUE", 106, 90, 205));
        colors.add(new Color("MEDIUM SLATE BLUE", 123, 104, 238));
        colors.add(new Color("LIGHT SLATE BLUE", 132, 112, 255));
        colors.add(new Color("MEDIUM BLUE", 0, 0, 205));
        colors.add(new Color("ROYAL BLUE", 65, 105, 225));
        colors.add(new Color("BLUE", 0, 0, 255));
        colors.add(new Color("DODGER BLUE", 30, 144, 255));
        colors.add(new Color("DEEP SKY BLUE", 0, 191, 255));
        colors.add(new Color("SKY BLUE", 135, 206, 250));
        colors.add(new Color("LIGHT SKY BLUE", 135, 206, 250));
        colors.add(new Color("STEEL BLUE", 70, 130, 180));
        colors.add(new Color("LIGHT STEEL BLUE", 176, 196, 222));
        colors.add(new Color("LIGHT BLUE", 173, 216, 230));
        colors.add(new Color("POWDER BLUE", 176, 224, 230));
        colors.add(new Color("PALE TURQUOISE", 175, 238, 238));
        colors.add(new Color("DARK TURQUOISE", 0, 206, 209));
        colors.add(new Color("MEDIUM TURQUOISE", 72, 209, 204));
        colors.add(new Color("TURQUOISE", 64, 224, 208));
        colors.add(new Color("CYAN", 0, 255, 255));
        colors.add(new Color("LIGHT CYAN", 224, 255, 255));
        colors.add(new Color("CADET BLUE", 95, 158, 160));
        colors.add(new Color("MEDIUM AQUAMARINE", 102, 205, 170));
        colors.add(new Color("AQUAMARINE", 127, 255, 212));
        colors.add(new Color("DARK GREEN", 0, 100, 0));
        colors.add(new Color("DARK OLIVE GREEN", 85, 107, 47));
        colors.add(new Color("DARK SEA GREEN", 143, 188, 143));
        colors.add(new Color("SEA GREEN", 46, 139, 87));
        colors.add(new Color("MEDIUM SEA GREEN", 60, 179, 113));
        colors.add(new Color("LIGHT SEA GREEN", 32, 178, 170));
        colors.add(new Color("PALE GREEN", 152, 251, 152));
        colors.add(new Color("SPRING GREEN", 0, 255, 127));
        colors.add(new Color("LAWN GREEN", 124, 252, 0));
        colors.add(new Color("CHARTREUSE", 127, 255, 0));
        colors.add(new Color("MEDIUM SPRING GREEN", 0, 250, 154));
        colors.add(new Color("GREEN YELLOW", 173, 255, 47));
        colors.add(new Color("LIME GREEN", 50, 205, 50));
        colors.add(new Color("YELLOW GREEN", 154, 205, 50));
        colors.add(new Color("FOREST GREEN", 34, 139, 34));
        colors.add(new Color("OLIVE DRAB", 107, 142, 35));
        colors.add(new Color("DARK KHAKI", 189, 183, 107));
        colors.add(new Color("KHAKI", 240, 230, 140));
        colors.add(new Color("PALE GOLDENROD", 238, 232, 170));
        colors.add(new Color("LIGHT GOLDENROD YELLOW", 250, 250, 210));
        colors.add(new Color("LIGHT YELLOW", 255, 255, 224));
        colors.add(new Color("YELLOW", 255, 255, 0));
        colors.add(new Color("GOLD", 255, 215, 0));
        colors.add(new Color("LIGHT GOLDENROD", 238, 221, 130));
        colors.add(new Color("GOLDENROD", 218, 165, 32));
        colors.add(new Color("DARK GOLDENROD", 184, 134, 11));
        colors.add(new Color("PALE GOLDENROD", 238, 232, 170));
        colors.add(new Color("LIGHT GOLDENROD YELLOW", 250, 250, 210));
        colors.add(new Color("LIGHT YELLOW", 255, 255, 224));
        colors.add(new Color("YELLOW", 255, 255, 0));
        colors.add(new Color("GOLD", 255, 215, 0));
        colors.add(new Color("LIGHT GOLDENROD", 238, 221, 130));
        colors.add(new Color("GOLDENROD", 218, 165, 32));
        colors.add(new Color("DARK GOLDENROD", 184, 134, 11));
        colors.add(new Color("PALE GOLDENROD", 238, 232, 170));
        colors.add(new Color("LIGHT GOLDENROD YELLOW", 250, 250, 210));
        colors.add(new Color("LIGHT YELLOW", 255, 255, 224));
        colors.add(new Color("YELLOW", 255, 255, 0));
        colors.add(new Color("ROSY BROWN", 188, 143, 143));
        colors.add(new Color("INDIAN RED", 205, 92, 92));
        colors.add(new Color("SADDLE BROWN", 139, 69, 19));
        colors.add(new Color("SIENNA", 160, 82, 45));
        colors.add(new Color("PERU", 205, 133, 63));
        colors.add(new Color("BURLYWOOD", 222, 184, 135));
        colors.add(new Color("BEIGE", 245, 245, 220));
        colors.add(new Color("WHEAT", 245, 222, 179));
        colors.add(new Color("SANDY BROWN", 244, 164, 96));
        colors.add(new Color("TAN", 210, 180, 140));
        colors.add(new Color("CHOCOLATE", 210, 105, 30));
        colors.add(new Color("FIREBRICK", 178, 34, 34));
        colors.add(new Color("BROWN", 165, 42, 42));
        colors.add(new Color("ROSY BROWN", 188, 143, 143));
        colors.add(new Color("INDIAN RED", 205, 92, 92));
        colors.add(new Color("SADDLE BROWN", 139, 69, 19));
        colors.add(new Color("SIENNA", 160, 82, 45));
        colors.add(new Color("PERU", 205, 133, 63));
        colors.add(new Color("BURLYWOOD", 222, 184, 135));
        colors.add(new Color("BEIGE", 245, 245, 220));
        colors.add(new Color("DARK SALMON", 233, 150, 122));
        colors.add(new Color("SALMON", 250, 128, 114));
        colors.add(new Color("LIGHT SALMON", 255, 160, 122));
        colors.add(new Color("ORANGE", 255, 165, 0));
        colors.add(new Color("DARK ORANGE", 255, 140, 0));
        colors.add(new Color("CORAL", 255, 127, 80));
        colors.add(new Color("LIGHT CORAL", 240, 128, 128));
        colors.add(new Color("TOMATO", 255, 99, 71));
        colors.add(new Color("ORANGE RED", 255, 69, 0));
        colors.add(new Color("RED", 255, 0, 0));
        colors.add(new Color("DARK SALMON", 233, 150, 122));
        colors.add(new Color("SALMON", 250, 128, 114));
        colors.add(new Color("LIGHT SALMON", 255, 160, 122));
        colors.add(new Color("ORANGE", 255, 165, 0));
        colors.add(new Color("DARK ORANGE", 255, 140, 0));
        colors.add(new Color("CORAL", 255, 127, 80));
        colors.add(new Color("LIGHT CORAL", 240, 128, 128));
        colors.add(new Color("TOMATO", 255, 99, 71));
        colors.add(new Color("ORANGE RED", 255, 69, 0));
        colors.add(new Color("RED", 255, 0, 0));
        colors.add(new Color("HOT PINK", 255, 105, 180));
        colors.add(new Color("DEEP PINK", 255, 20, 147));
        colors.add(new Color("PINK", 255, 192, 203));
        colors.add(new Color("LIGHT PINK", 255, 182, 193));
        colors.add(new Color("PALE VIOLET RED", 219, 112, 147));
        colors.add(new Color("MAROON", 176, 48, 96));
        colors.add(new Color("MEDIUM VIOLET RED", 199, 21, 133));
        colors.add(new Color("VIOLET RED", 208, 32, 144));
        colors.add(new Color("VIOLET", 238, 130, 238));
        colors.add(new Color("PLUM", 221, 160, 221));
        colors.add(new Color("ORCHID", 218, 112, 214));
        colors.add(new Color("MEDIUM ORCHID", 186, 85, 211));
        colors.add(new Color("DARK ORCHID", 153, 50, 204));
        colors.add(new Color("DARK VIOLET", 148, 0, 211));
        colors.add(new Color("BLUE VIOLET", 138, 43, 226));
        colors.add(new Color("PURPLE", 160, 32, 240));
        colors.add(new Color("MEDIUM PURPLE", 147, 112, 219));
        colors.add(new Color("THISTLE", 216, 191, 216));
        colors.add(new Color("HOT PINK", 255, 105, 180));
        colors.add(new Color("DEEP PINK", 255, 20, 147));
        return colors;
    }
}
