package Q1.Q1d;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.Assert.fail;

public class FoodTest {
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
	public void testGetAllergensMethod() {
		Method getAllergensMethod;

		try {
			getAllergensMethod = Food.class.getDeclaredMethod("getAllergens");
			if (!getAllergensMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your getAllergens method contract in the Food interface returns a String!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a unimplemented method getAllergens in the Food interface!");
		}
	}

	@Test(timeout = 1000)
	public void testGetCarbohydratesMethod() {
		Method getCarbohydratesMethod;

		try {
			getCarbohydratesMethod = Food.class.getDeclaredMethod("getCarbohydrates");
			if (!getCarbohydratesMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your getCarbohydrates method contract in the Food interface returns an int!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a unimplemented method getCarbohydrates in the Food interface!");
		}
	}

	@Test(timeout = 1000)
	public void testGetProteinMethod() {
		Method getProteinMethod;

		try {
			getProteinMethod = Food.class.getDeclaredMethod("getProtein");
			if (!getProteinMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your getProtein method contract in the Food interface returns an int!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a unimplemented method getProtein in the Food interface!");
		}
	}

	@Test(timeout = 1000)
	public void testGetFatsMethod() {
		Method getFatsMethod;

		try {
			getFatsMethod = Food.class.getDeclaredMethod("getFats");
			if (!getFatsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your getFats method contract in the Food interface returns an int!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a unimplemented method getFats in the Food interface!");
		}
	}

	@Test(timeout = 1000)
	public void testIsConsumableMethod() {
		Method isConsumableMethod;

		try {
			isConsumableMethod = Food.class.getDeclaredMethod("isConsumable");
			if (!isConsumableMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your isConsumable method contract in the Food interface returns a boolean!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a unimplemented method isConsumable in the Food interface!");
		}
	}

	@Test(timeout = 1000)
	public void testIsHealthyMethod() {
		Method isHealthyMethod;

		try {
			isHealthyMethod = Food.class.getDeclaredMethod("isHealthy");
			if (!isHealthyMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your isHealthy method contract in the Food interface returns a boolean!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a unimplemented method isHealthy in the Food interface!");
		}
	}

	@Test(timeout = 1000)
	public void testCountryOfOriginMethod() {
		Method countryOfOriginMethod;

		try {
			countryOfOriginMethod = Food.class.getDeclaredMethod("countryOfOrigin");
			if (!countryOfOriginMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your countryOfOrigin method contract in the Food interface returns a String!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a unimplemented method countryOfOrigin in the Food interface!");
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
