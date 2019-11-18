import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@code ColorEngine} class is what defines the Color fixer algorithm. It will read the broken file in,
 * collapse the array twice, via the {@code collapseArrayList} method, and the {@code analyzeColors} method.
 * @author varun, cs180 group
 * @version 1.0
 */
public class ColorEngine {

    @SuppressWarnings("FieldCanBeLocal")
    private static ArrayList<String> contentsOfFile;
    @SuppressWarnings("FieldCanBeLocal")
    private static ArrayList<String> collapsedContents;
    private static ArrayList<String> toWrite;

    public static void main(String[] args) throws UnsupportedColorSpectrumException{
        Scanner s = new Scanner(System.in);
        System.out.println("What is the name of the color file you would like to fix?");
        String input = s.nextLine();
        System.out.println("What is the name of the file you would like to dump the updated contents to?");
        String output = s.nextLine();
        contentsOfFile = readFile(input);
        collapsedContents = collapseArrayList(contentsOfFile);
        analyzeColors(collapsedContents);
        writeFile(toWrite, output);
        // To Do - Prompts are included above.
    }

    /**
     * This method should check whether the passed file name exists, and if it does, then it should read the contents
     * of the file into an {@code ArrayList} of {@code String}s. If the file doesn't exist, the {@code
     * FileNotFoundException} should be thrown.
     *
     * @param fileName The file name to read from
     * @return The {@code ArrayList} to read the file contents into
     * @throws FileNotFoundException thrown if the file could not be found
     */

        private static ArrayList<String> readFile(String fileName){
        File f = new File(fileName);
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ArrayList<String> fileStuff = new ArrayList<String>();
        BufferedReader bfr = new BufferedReader(fr);
        while (true) {
            String line = null;
            try{
                line = bfr.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            if (line == null) {
                break;
            }
            fileStuff.add(line);
        }
        try{
            bfr.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return fileStuff;
    }

    /**
     * Collapses an {@code ArrayList} into a third of its size. Should collapse the {@code ArrayList} from
     * having an integer on each line to each line containing three integers.
     *
     * @param toCollapse The pre-collapsed {@code ArrayList}
     * @return the newly collapsed {@code ArrayList}
     */

    private static ArrayList<String> collapseArrayList(ArrayList<String> toCollapse) {
        ArrayList<String> t = new ArrayList<String>();
        for (int i = 0; i < toCollapse.size(); i += 9) {
            System.out.println(i);
            t.add(toCollapse.get(i) + toCollapse.get(i + 1) + toCollapse.get(i + 2) + " " +
                    toCollapse.get(i + 3) + toCollapse.get(i + 4) + toCollapse.get(i + 5) + " "
                    + toCollapse.get(i + 6) + toCollapse.get(i + 7) + toCollapse.get(i + 8));
        }
        return t;
    }

    /**
     * This method should instantiate a new {@code ColorApproximator} object, and create a new {@code Color} object
     * using the data from the {@code ArrayList} parameter's data. It should then add a string of this template to
     * the {@code ArrayList} that holds the data that will be written to the file.
     * <p>
     * 0,0,0 is approximately the color BLACK
     *
     * @param toAnalyze The 'brokencolors.txt' file, that has been 'collapsed' once, into three digits per line.
     * @throws UnsupportedColorSpectrumException thrown if the {@code Color} constructor throws an exception.
     */

    private static void analyzeColors(ArrayList<String> toAnalyze) throws UnsupportedColorSpectrumException {
        toWrite = new ArrayList<String>();
        for (int i = 0; i < toAnalyze.size(); i++) {
            String[] numbers = toAnalyze.get(i).split(" ");
            Color colors = new Color("", Integer.valueOf(numbers[0]),
                    Integer.valueOf(numbers[1]), Integer.valueOf(numbers[2]));
            ColorApproximation ca = new ColorApproximation(colors);
            String colorName = ca.approximateColor();
            String colo = colors.decomposeColor();
            System.out.println(colorName);
            toWrite.add(colo + " is approximately the color " + colorName);
        }

    }

    /**
     * This method should take in a parameter of an ArrayList, containing the fixed numbers and their color
     * approximations. It should print the contents of the ArrayList to a file, with a new line
     *
     * @param dataToWrite The {@code ArrayList} that contains the data to write to the text file
     * @param filename    The filename of the file you want to write data to
     */
    private static void writeFile(ArrayList<String> dataToWrite, String filename) {
        File f = new File(filename);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < dataToWrite.size(); i++) {
            try {
                bw.write(dataToWrite.get(i) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
