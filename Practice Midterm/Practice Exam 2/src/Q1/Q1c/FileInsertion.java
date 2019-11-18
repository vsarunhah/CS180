package Q1.Q1c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileInsertion {

	@SuppressWarnings("FieldCanBeLocal")
	private static Scanner sIn;
	@SuppressWarnings("FieldCanBeLocal")
	private static String insertion;
	@SuppressWarnings("FieldCanBeLocal")
	private static ArrayList<String> contents;

	/**
	 * The {@code main} method will initialize a {@code Scanner} object, initialize an {@code ArrayList} called
	 * contents, fill the aforementioned {@code ArrayList} with the contents of a file called "Names.txt", sort the
	 * contents {@code ArrayList} in the lists natural order as defined by the {@code Comparable} interface's
	 * {@code toCompare} method, prompt the user for text to insert into the file, insert the text, and then re-sort
	 * the file in the same aforementioned natural order (defined once again by the {@code compareTo} method of the
	 * {@code Comparable} interface, and then print the contents to a file called "output.txt", with each entry of
	 * the sorted {@code ArrayList} on its own line.
	 *
	 * @param args the command line arguments, should this program be executed through the command line.
	 */
	public static void main(String[] args) {
		sIn = new Scanner(System.in);
		contents = new ArrayList<>();

		contents = readFromFile();

		Collections.sort(contents);

		System.out.println("What is the text you would like to insert in the sorted file?");
		insertion = sIn.nextLine();
		contents.add(insertion);

		Collections.sort(contents);
		printToFile(contents);
	}

	/**
	 * The {@code readFromFile} method will return an {@code ArrayList} that holds the contents of the file read in,
	 * which will always be called "Names.txt"
	 *
	 * @return the {@code ArrayList<String>} that holds the contents of the file read in, which will always be a file
	 * called "Names.txt".
	 */
	private static ArrayList<String> readFromFile() {
		ArrayList<String> contents = new ArrayList<>();
		try (BufferedReader bfr = new BufferedReader(new FileReader("Names.txt"))) {
			String line;
			while ((line = bfr.readLine()) != null) {
				contents.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contents;
	}

	/**
	 * The {@code printToFile} method takes an {@code ArrayList<String>} as a parameter, and prints the contents line
	 * by line to a file called "output.txt".
	 *
	 * @param contents the {@code ArrayList<String>} that holds the contents that should be printed to the file
	 *                 called "output.txt".
	 */
	private static void printToFile(ArrayList<String> contents) {
		try (PrintWriter pw = new PrintWriter("output.txt")) {
			for (String content : contents) {
				pw.println(content);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
