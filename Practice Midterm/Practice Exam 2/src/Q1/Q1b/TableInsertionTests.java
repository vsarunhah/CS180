package Q1.Q1b;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import static org.junit.Assert.fail;

public class TableInsertionTests {
	private final InputStream originalInput = System.in;
	private final String TA_ERROR_MESSAGE = "You bumped into an error! Please contact a TA immediately.";
	private final PrintStream originalOutput = System.out;

	@SuppressWarnings("FieldCanBeLocal")
	private ByteArrayInputStream testIn;

	private ByteArrayOutputStream testOut;

	@Before
	public void outputStart() {
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	@Test(timeout = 1000)
	public void testTableInsertionFields() {
		Field table;
		Field scanner;
		Field xInt;
		Field yInt;
		Field xString;
		Field yString;
		Field numInsert;

		try {
			table = TableInsertion.class.getDeclaredField("table");
			TableInsertion.class.getDeclaredField("table").setAccessible(true);
			if (!table.getType().equals(int[][].class)) {
				fail("Ensure that your field table in class TableInsertion is of type int[][]!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field table in class TableInsertion that is a two dimensional int array," +
					" that is private and static!");
			return;
		}

		if (table.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your int[][] table in class TableInsertion is both private and static!");
			return;
		}

		try {
			scanner = TableInsertion.class.getDeclaredField("sIn");
			TableInsertion.class.getDeclaredField("sIn").setAccessible(true);
			if (!scanner.getType().equals(Scanner.class)) {
				fail("Ensure that your field sIn in class TableInsertion is of type Scanner!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field sIn in class TableInsertion that is of type Scanner and ," +
					"is private and static!");
			return;
		}

		if (scanner.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your Scanner sIn in class TableInsertion is both private and static!");
			return;
		}

		try {
			xInt = TableInsertion.class.getDeclaredField("xPos");
			TableInsertion.class.getDeclaredField("xPos").setAccessible(true);
			if (!xInt.getType().equals(int.class)) {
				fail("Ensure that your field xPos in class TableInsertion is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field xPos in class TableInsertion that is of type int," +
					" and is private and static!");
			return;
		}

		if (xInt.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your int xPos in class TableInsertion is both private and static!");
			return;
		}

		try {
			yInt = TableInsertion.class.getDeclaredField("yPos");
			TableInsertion.class.getDeclaredField("yPos").setAccessible(true);
			if (!yInt.getType().equals(int.class)) {
				fail("Ensure that your field yPos in class TableInsertion is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field yPos in class TableInsertion that is of type int," +
					" and is private and static!");
			return;
		}

		if (yInt.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your int yPos in class TableInsertion is both private and static!");
			return;
		}

		try {
			xString = TableInsertion.class.getDeclaredField("x");
			TableInsertion.class.getDeclaredField("x").setAccessible(true);
			if (!xString.getType().equals(String.class)) {
				fail("Ensure that your field x in class TableInsertion is of type String!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field x in class TableInsertion that is of type String," +
					" and is private and static!");
			return;
		}

		if (xString.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your String x in class TableInsertion is both private and static!");
			return;
		}

		try {
			yString = TableInsertion.class.getDeclaredField("y");
			TableInsertion.class.getDeclaredField("y").setAccessible(true);
			if (!yString.getType().equals(String.class)) {
				fail("Ensure that your field y in class TableInsertion is of type String!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field y in class TableInsertion that is of type String," +
					" and is private and static!");
			return;
		}

		if (xInt.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your String y in class TableInsertion is both private and static!");
			return;
		}

		try {
			numInsert = TableInsertion.class.getDeclaredField("numToInsert");
			TableInsertion.class.getDeclaredField("numToInsert").setAccessible(true);
			if (!numInsert.getType().equals(int.class)) {
				fail("Ensure that your field numToInsert in class TableInsertion is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field numToInsert in class TableInsertion that is of type int," +
					" and is private and static!");
			return;
		}

		if (numInsert.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your int numToInsert in class TableInsertion is both private and static!");
		}
	}


	@Test(timeout = 1000)
	public void testPrintTableMethod() {
		Method printTableMethod;
		try {
			printTableMethod = TableInsertion.class.getDeclaredMethod("printTable", int[][].class);
			if (!printTableMethod.getReturnType().equals(void.class)) {
				fail("Ensure that your method printTable returns nothing (void)!");
				return;
			}
			if (!printTableMethod.getParameterTypes()[0].equals(int[][].class)) {
				fail("Ensure that your method printTable takes one parameter of a two dimensional int array!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method printTable in class TableInsertion that takes one parameter of a two " +
					"dimensional int array, returns nothing (void), and is private and static!");
			return;
		}

		if (printTableMethod.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your method printTable in class TableInsertion is both private and static!");
		}
	}

	@Test(timeout = 1000)
	public void testVerifyLineInputMethod() {
		Method verifyLineInputMethod;
		try {
			verifyLineInputMethod = TableInsertion.class.getDeclaredMethod("verifyLineInput");
			if (!verifyLineInputMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method verifyLineInput returns a String!");
				return;
			}
			if (verifyLineInputMethod.getParameterTypes().length > 0) {
				fail("Ensure that your method verifyLineInput takes no parameters!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method verifyLineInput in class TableInsertion that takes no parameters, " +
					"returns a String, and is private and static!");
			return;
		}

		if (verifyLineInputMethod.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your method verifyLineInput in class TableInsertion is both private and static!");
		}
	}

	@Test(timeout = 1000)
	public void testParseNumberMethod() {
		Method parseNumberMethod;
		try {
			parseNumberMethod = TableInsertion.class.getDeclaredMethod("parseNumber", String.class);
			if (!parseNumberMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method parseNumber in class TableInsertion returns an int!");
				return;
			}
			if (!parseNumberMethod.getParameterTypes()[0].equals(String.class)) {
				fail("Ensure that your method parseNumber in class TableInsertion takes one String as a parameter!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method parseNumber in class TableInsertion that takes one parameter of a " +
					"String, returns an int, and is private and static!");
			return;
		}

		if (parseNumberMethod.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your method parseNumber in class TableInsertion is both private and static!");
		}
	}

	@Test(timeout = 1000)
	public void testCheckBoundValidityMethod() {
		Method checkBoundValidity;
		try {
			checkBoundValidity = TableInsertion.class.getDeclaredMethod("checkBoundValidity", int[][].class,
					int.class, boolean.class, boolean.class);
			if (!checkBoundValidity.getReturnType().equals(void.class)) {
				fail("Ensure that your method checkBoundValidity in class TableInsertion returns nothing (void)!");
				return;
			}
			if (!checkBoundValidity.getExceptionTypes()[0].equals(ArrayIndexOutOfBoundsException.class)) {
				fail("Ensure that your method checkBoundValidity in class TableInsertion includes a throws " +
						"declaration for the ArrayIndexOutOfBounds exception!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method checkBoundValidity in class TableInsertion that takes four parameters" +
					" - one two dimensional int array, one int, and two booleans, that returns nothing (void), and is" +
					" private and static!");
			return;
		}

		if (checkBoundValidity.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your method checkBoundValidity in class TableInsertion is private and static!");
		}
	}

	@Test(timeout = 1000)
	public void testTableInsertionInnerWorkings() {
		Field table;
		String input = "5\n1\n1\n";
		String expected = "Your current table looks like this:\n" +
				"0 0 0\n" +
				"0 0 0\n" +
				"0 0 0\n" +
				"Please enter the number you would like to insert in the table.\n" +
				"At what column would you like to insert the number?\n" +
				"At what row would you like to insert the number?\n" +
				"Your new table looks like this.\n" +
				"0 0 0\n" +
				"0 5 0\n" +
				"0 0 0\n";
		String studentOutput;
		try {
			table = TableInsertion.class.getDeclaredField("table");
			table.setAccessible(true);
			table.set(null, new int[3][3]);
			receiveInput(input);
			TableInsertion.main(new String[0]);
			studentOutput = getOutput();
			Assert.assertEquals("Ensure that your output prints with each row of the array on a new line, and each " +
					"column of the array separated by one space!", expected, studentOutput);
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a int[][] table in class TableInsertion!");
		} catch (IllegalAccessException e) {
			fail(TA_ERROR_MESSAGE + " TACIllAcc");
		}
	}

	/**
	 * UTILITY METHODS BELOW
	 */
	@SuppressWarnings("SameParameterValue")
	private void receiveInput(String str) {
		testIn = new ByteArrayInputStream(str.getBytes());
		System.setIn(testIn);
	}

	private String getOutput() {
		return testOut.toString();
	}

	@After
	public void restoreInputAndOutput() {
		System.setIn(originalInput);
		System.setOut(originalOutput);
	}
}
