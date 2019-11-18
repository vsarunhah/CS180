package Q1.Q1b;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TableInsertion {

	@SuppressWarnings("CanBeFinal")
	private static int[][] table = new int[5][5];
	private static Scanner sIn;
	@SuppressWarnings("FieldCanBeLocal")
	private static int xPos;
	@SuppressWarnings("FieldCanBeLocal")
	private static int yPos;
	@SuppressWarnings("FieldCanBeLocal")
	private static String x;
	@SuppressWarnings("FieldCanBeLocal")
	private static String y;
	@SuppressWarnings("FieldCanBeLocal")
	private static int numToInsert;

	/**
	 * The {@code main} method for this program will initialize a {@code Scanner} object to the standard input, print
	 * the current table, request for the number that the user would like to input, verify that input, then ask for
	 * the column that the user would like to insert the number in, validate both the input and the actual position
	 * entered, then ask for the row that the user would like to insert the number in, validate both the input and
	 * the actual position entered, insert if all conditions were passed, and then print the updated table.
	 *
	 * @param args command line arguments, should the program be run through the command line.
	 */
	public static void main(String[] args) {
		sIn = new Scanner(System.in);

		System.out.println("Your current table looks like this:");
		printTable(table);

		System.out.println("Please enter the number you would like to insert in the table.");
		String toInsert = verifyLineInput();
		numToInsert = parseNumber(toInsert);

		System.out.println("At what column would you like to insert the number?");
		x = verifyLineInput();
		xPos = parseNumber(x);
		checkBoundValidity(table, xPos, true, false);

		System.out.println("At what row would you like to insert the number?");
		y = verifyLineInput();
		yPos = parseNumber(y);
		checkBoundValidity(table, yPos, false, true);

		table[yPos][xPos] = numToInsert;

		System.out.println("Your new table looks like this.");
		printTable(table);
	}

	/**
	 * The {@code printTable} method will print the contents of a two dimensional, potentially jagged array, with each
	 * element separated by a space. Each row should be on a new line, while each element at a specific row and
	 * column should be separated by a single space.
	 *
	 * @param table the two dimensional array to print the contents of
	 */
	private static void printTable(int[][] table) {
		for (int[] ints : table) {
			for (int i = 0; i < ints.length; i++) {
				int anInt = ints[i];
				if (i == ints.length - 1) {
					System.out.print(anInt);
				} else {
					System.out.print(anInt + " ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * The {@code verifyLineInput} method will verify that the input entered is a {@code String}. If it is not, an
	 * {@code InputMismatchException} will be thrown.
	 *
	 * @return the {@code String} entered through standard input, or {@code null} if an
	 * {@code InputMismatchException} was thrown.
	 */
	private static String verifyLineInput() {
		try {
			return sIn.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Input is invalid!");
			return null;
		}
	}

	/**
	 * Parses a given {@code String} into an integer. It should check whether the number can be parsed, and if not, a
	 * {@code NumberFormatException} should be caught. If a {@code NumberFormatException} is caught,
	 * {@code Integer.MAX_VALUE} should be returned.
	 *
	 * @param toParse the {@code String} to parse into an integer.
	 * @return the {@code int}, if parseable, or {@code Integer.MAX_VALUE} if unparseable.
	 */
	private static int parseNumber(String toParse) {
		try {
			return Integer.parseInt(toParse);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return Integer.MAX_VALUE;
		}
	}

	/**
	 * The {@code checkBoundValidity} method will check whether the number passed in is valid in the specific
	 * dimension of the table passed in. For example, it will check whether in a 5x5 table, whether the integer 6
	 * could be selected as either a row or column to place a number in.
	 *
	 * @param table the table to check the dimensions of
	 * @param num   the number to check if it is within the bounds of the table dimensions
	 * @param row   true if checking if the number passed in is valid in the row dimension, false otherwise.
	 * @param col   true if checking if the number passed in is valid in the column dimension, false otherwise.
	 * @throws ArrayIndexOutOfBoundsException thrown if the number passed in is invalid in the specified dimension.
	 */
	private static void checkBoundValidity(int[][] table, int num, boolean row, boolean col)
			throws ArrayIndexOutOfBoundsException {
		if (row) {
			if (num >= table[0].length) {
				throw new ArrayIndexOutOfBoundsException("Past the number of rows!");
			}
		} else if (col) {
			if (num >= table.length) {
				throw new ArrayIndexOutOfBoundsException("Past the number of columns!");
			}
		}
	}
}
