package Q2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.fail;

public class TownhouseTest {
	private final InputStream originalInput = System.in;

	private final PrintStream originalOutput = System.out;

	@SuppressWarnings("FieldCanBeLocal")
	private ByteArrayInputStream testIn;
	private final String TA_ERROR_MESSAGE = "You bumped into an error! Please contact a TA immediately.";
	private ByteArrayOutputStream testOut;

	@Before
	public void outputStart() {
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	@Test(timeout = 1000)
	public void testTownhouseExtends() {
		Class<?> studentExtends = Townhouse.class.getSuperclass();
		Assert.assertEquals("Ensure that your class Townhouse extends Home!", Home.class, studentExtends);
	}

	@Test(timeout = 1000)
	public void testTownhouseConstructor() {
		Constructor<?> TownhouseConstructor;

		try {
			TownhouseConstructor = Townhouse.class.getDeclaredConstructor(int.class, int.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class Townhouse that takes two ints!");
			return;
		}
		if (TownhouseConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Townhouse is public!");
		}
	}

	@Test(timeout = 1000)
	public void testToStringMethod() {
		Method toStringMethod;
		try {
			toStringMethod = Townhouse.class.getDeclaredMethod("toString");
			if (!toStringMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method toString in class Townhouse returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method toString in class Townhouse that returns a String and is public!");
			return;
		}

		if (toStringMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method toString in class Townhouse is public!");
		}
	}

	@Test(timeout = 1000)
	public void testTownhouseInnerWorkings() {
		Home Townhouse = new Townhouse(2, 2);
		Assert.assertEquals("Ensure that your method toString in class Townhouse gives the appropriate output as detailed" +
				" in the Javadoc!", "Townhouse[2, 2, true]", Townhouse.toString());
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
