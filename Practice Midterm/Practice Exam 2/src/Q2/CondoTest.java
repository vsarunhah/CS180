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

public class CondoTest {
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
	public void testCondoExtends() {
		Class<?> studentExtends = Condo.class.getSuperclass();
		Assert.assertEquals("Ensure that your class Condo extends Home!", Home.class, studentExtends);
	}

	@Test(timeout = 1000)
	public void testCondoConstructor() {
		Constructor<?> condoConstructor;

		try {
			condoConstructor = Condo.class.getDeclaredConstructor(int.class, int.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class Condo that takes two ints!");
			return;
		}
		if (condoConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Condo is public!");
		}
	}

	@Test(timeout = 1000)
	public void testToStringMethod() {
		Method toStringMethod;
		try {
			toStringMethod = Condo.class.getDeclaredMethod("toString");
			if (!toStringMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method toString in class Condo returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method toString in class Condo that returns a String and is public!");
			return;
		}

		if (toStringMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method toString in class Condo is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCondoInnerWorkings() {
		Home condo = new Condo(2, 2);
		Assert.assertEquals("Ensure that your method toString in class Condo gives the appropriate output as detailed" +
				" in the Javadoc!", "Condo[2, 2, false]", condo.toString());
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
