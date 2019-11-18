import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileInsertion {
	private static Scanner sIn;
	private static String insertion;
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
	private static ArrayList<String> readFromFile(){
		File f = new File("Names.txt");
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> content = new ArrayList<String>();
		while(s.hasNextLine()){
			content.add(s.nextLine());
		}
		return content;
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