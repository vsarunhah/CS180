import java.util.*;

public class Palette {
    private ArrayList<Color> colorList;

    public Palette() {
        this.colorList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        boolean repeat = true;
        /*
         * TODO #1: Create a new Palette object named "palette"
         */
        Palette palette = new Palette();

        System.out.println("Welcome to the RGB Palette!");

        do {
            do {
                System.out.println("Select an option:\n" +
                        "1. Add color\n" +
                        "2. View color list\n" +
                        "3. Edit color\n" +
                        "4. Quit"
                );
                choice = in.nextInt();
                if (choice < 1 || choice > 4) {
                    System.out.println("Please type an integer between 1 and 4.");
                }
            } while (choice < 1 || choice > 4);
            switch (choice) {
                case 1: {
                    int red;
                    int blue;
                    int green;
                    System.out.println("Enter the value for the red channel (0-255):");
                    do {
                        red = in.nextInt();
                        if (red < 0 || red > 255) {
                            System.out.println("Please enter an integer between 0 and 255 inclusive:");
                        }
                    } while (red < 0 || red > 255);
                    System.out.println("Enter the value for the green channel (0-255):");
                    do {
                        green = in.nextInt();
                        if (green < 0 || green > 255) {
                            System.out.println("Please enter an integer between 0 and 255 inclusive:");
                        }
                    } while (green < 0 || green > 255);
                    System.out.println("Enter the value for the blue channel (0-255):");
                    do {
                        blue = in.nextInt();
                        if (blue < 0 || blue > 255) {
                            System.out.println("Please enter an integer between 0 and 255 inclusive:");
                        }
                    } while (blue < 0 || blue > 255);
        /*
         * TODO #2: Create a new Color object named "newColor" using the red, green, and blue variables declared above.
         */
                    Color newColor = new Color(red, green, blue);
                    palette.colorList.add(newColor);
                    System.out.println("Added " + newColor.getHex() + " to the list.\n");
                    break;
                }
                case 2: {
                    System.out.println("Color List:");
                    for (int i = 0; i < palette.colorList.size(); i++) {
                        System.out.printf("%d: %s\n", (i + 1), palette.colorList.get(i).getHex());
                    }
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("Enter the corresponding number from the color list:");
                    int num;
                    do {
                        num = in.nextInt();
                        if (num - 1 < 0 || num - 1 >= palette.colorList.size()) {
                            System.out.println("Invalid number! Enter the corresponding number from the color list:");
                        }
                    } while (num - 1 < 0 || num - 1 >= palette.colorList.size());
                    Color selected = palette.colorList.get(num - 1);
                    System.out.println("The current RGB values of the selected color are:");

        /*
         * TODO #3: Print the current values of each color channel for selected in the following format:
         * Red: [value]
         * Green: [value]
         * Blue: [value]
         *
         * Note: Do not print the brackets [].
         */
              System.out.println("Red: " + selected.getRed());
              System.out.println("Green: " + selected.getGreen());
              System.out.println("Blue: " + selected.getBlue());


                    int newRed;
                    int newGreen;
                    int newBlue;
                    System.out.println("Enter the new value for the red channel (0-255):");
                    do {
                        newRed = in.nextInt();
                        if (newRed < 0 || newRed > 255) {
                            System.out.println("Please enter an integer between 0 and 255 inclusive:");
                        }
                    } while (newRed < 0 || newRed > 255);
                    System.out.println("Enter the value for the green channel (0-255):");
                    do {
                        newGreen = in.nextInt();
                        if (newGreen < 0 || newGreen > 255) {
                            System.out.println("Please enter an integer between 0 and 255 inclusive:");
                        }
                    } while (newGreen < 0 || newGreen > 255);
                    System.out.println("Enter the value for the blue channel (0-255):");
                    do {
                        newBlue = in.nextInt();
                        if (newBlue < 0 || newBlue > 255) {
                            System.out.println("Please enter an integer between 0 and 255 inclusive:");
                        }
                    } while (newBlue < 0 || newBlue > 255);

        /*
         * TODO #4: Set the channels of the Color "selected" to the newRed, newGreen, and newBlue variables initialized above.
         */
                    selected.setRed(newRed);
                    selected.setGreen(newGreen);
                    selected.setBlue(newBlue);

                    System.out.println("Changed color " + num + " on the list to " + selected.getHex() + "\n");

                    break;
                }
                case 4: {
                    System.out.println("Thanks for using the RGB Palette!");
                    repeat = false;
                    break;
                }
            }
        } while (repeat);
    }
}
