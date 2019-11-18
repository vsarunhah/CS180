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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.fail;

public class HomeTest {
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
	public void testHomeFields() {
		Field numBeds;
		Field numBath;
		Field hasBackyard;

		try {
			numBeds = Home.class.getDeclaredField("numBedrooms");
			if (!numBeds.getType().equals(int.class)) {
				fail("Ensure that you have a field numBedrooms in class Home that is of type int and is private and " +
						"final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field numBedrooms in class Home that is of type int and is private and " +
					"final!");
			return;
		}

		if (numBeds.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your field numBedrooms in class Home is private and final!");
		}

		try {
			numBath = Home.class.getDeclaredField("numBathrooms");
			if (!numBath.getType().equals(int.class)) {
				fail("Ensure that you have a field numBathrooms in class Home that is of type int and is private and " +
						"final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field numBathrooms in class Home that is of type int and is private and " +
					"final!");
			return;
		}

		if (numBath.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your field numBathrooms in class Home is private and final!");
		}

		try {
			hasBackyard = Home.class.getDeclaredField("hasBackyard");
			if (!hasBackyard.getType().equals(boolean.class)) {
				fail("Ensure that you have a field hasBackyard in class Home that is of type boolean and is private " +
						"and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field hasBackyard in class Home that is of type boolean and is private and " +
					"final!");
			return;
		}

		if (hasBackyard.getModifiers() != Modifier.PROTECTED) {
			fail("Ensure that your field hasBackyard in class Home is protected!");
		}
	}

	@Test(timeout = 1000)
	public void testHomeConstructor() {
		Constructor<?> HomeConstructor;

		try {
			HomeConstructor = Home.class.getDeclaredConstructor(int.class, int.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class Home that takes two ints!");
			return;
		}
		if (HomeConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Home is public!");
		}
	}

	@Test(timeout = 1000)
	public void testToStringMethod() {
		Method toStringMethod;
		try {
			toStringMethod = Home.class.getDeclaredMethod("toString");
			if (!toStringMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method toString in class Home returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method toString in class Home that returns a String and is public!");
			return;
		}

		if (toStringMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method toString in class Home is public!");
		}
	}

	@Test(timeout = 1000)
	public void testGetNumBedroomsMethod() {
		Method getNumBedroomsMethod;
		try {
			getNumBedroomsMethod = Home.class.getDeclaredMethod("getNumBedrooms");
			if (!getNumBedroomsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your getNumBedrooms method in class Home returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method called getNumBedrooms in class Home that is public and returns an " +
					"int!");
			return;
		}

		if (getNumBedroomsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your getNumBedrooms method in class Home is public!");
		}
	}

	@Test(timeout = 1000)
	public void testGetNumBathroomsMethod() {
		Method getNumBathroomsMethod;
		try {
			getNumBathroomsMethod = Home.class.getDeclaredMethod("getNumBathrooms");
			if (!getNumBathroomsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your getNumBathrooms method in class Home returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method called getNumBathrooms in class Home that is public and returns an " +
					"int!");
			return;
		}

		if (getNumBathroomsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your getNumBathrooms method in class Home is public!");
		}
	}

	@Test(timeout = 1000)
	public void testHasBackyardMethod() {
		Method hasBackyardMethod;
		try {
			hasBackyardMethod = Home.class.getDeclaredMethod("hasBackyard");
			if (!hasBackyardMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your hasBackyard method in class Home returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method called hasBackyard in class Home that is public and returns a " +
					"boolean!");
			return;
		}

		if (hasBackyardMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your hasBackyard method in class Home is public!");
		}
	}

	@Test(timeout = 1000)
	public void testHomeInnerWorkings() {
		Home Home = new Home(2, 2);
		Assert.assertEquals("Ensure that your method toString in class Home gives the appropriate output as detailed" +
				" in the Javadoc!", "Home[2, 2, true]", Home.toString());
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
