import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.Assert.fail;

public class AnimalTest {
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
	public void testHasLegsMethod() {
		Method hasLegsMethod;
		try {
			hasLegsMethod = Animal.class.getDeclaredMethod("hasLegs");
			if (!hasLegsMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method contract for hasLegs in class Animal will return a boolean when " +
						"implemented!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have an unimplemented method hasLegs that returns a boolean in interface Animal!");
		}
	}

	@Test(timeout = 1000)
	public void testNumLegsMethod() {
		Method numLegsMethod;
		try {
			numLegsMethod = Animal.class.getDeclaredMethod("numLegs", boolean.class);
			if (!numLegsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method contract for numLegs in class Animal will return an int when " +
						"implemented!");
			}
			if (!numLegsMethod.getParameterTypes()[0].equals(boolean.class)) {
				fail("Ensure that your method contract for numLegs in class Animal will take a boolean as a parameter" +
						" when implemented!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have an unimplemented method numLegs that returns an int in interface Animal!");
		}
	}

	@Test(timeout = 1000)
	public void testGetHabitatMethod() {
		Method getHabitatMethod;
		try {
			getHabitatMethod = Animal.class.getDeclaredMethod("getHabitat");
			if (!getHabitatMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method contract for getHabitat in class Animal will return a String when " +
						"implemented!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have an unimplemented method getHabitat that returns a String in interface Animal!");
		}
	}

	@Test(timeout = 1000)
	public void testConsumeFoodMethod() {
		Method consumeFoodMethod;
		try {
			consumeFoodMethod = Animal.class.getDeclaredMethod("consumeFood", int.class);
			if (!consumeFoodMethod.getReturnType().equals(void.class)) {
				fail("Ensure that your method contract for consumeFood in class Animal will return nothing (void) " +
						"when implemented!");
			}
			if (!consumeFoodMethod.getParameterTypes()[0].equals(int.class)) {
				fail("Ensure that your method contract for consumeFood in class Animal will take an int as a " +
						"parameter when implemented!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have an unimplemented method consumeFood that returns nothing (void) in interface " +
					"Animal!");
		}
	}

	@Test(timeout = 1000)
	public void testReproduceMethod() {
		Method reproduceMethod;
		try {
			reproduceMethod = Animal.class.getDeclaredMethod("reproduce");
			if (!reproduceMethod.getReturnType().equals(Object.class)) {
				fail("Ensure that your method contract for reproduce in class Animal will return an Object when " +
						"implemented!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have an unimplemented method reproduce that returns an Object in interface Animal!");
		}
	}

	@Test(timeout = 1000)
	public void testDieMethod() {
		Method dieMethod;
		try {
			dieMethod = Animal.class.getDeclaredMethod("die");
			if (!dieMethod.getReturnType().equals(void.class)) {
				fail("Ensure that your method contract for die in class Animal will return nothing (void) when " +
						"implemented!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have an unimplemented method die that returns nothing (void) in interface Animal!");
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
