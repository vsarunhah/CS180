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

public class AppleTest {
	private final InputStream originalInput = System.in;

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
	public void testAppleFields() {
		Field calories;
		Field carbs;
		Field protein;
		Field fats;
		Field allergens;

		try {
			calories = Apple.class.getDeclaredField("calories");
			if (!calories.getType().equals(int.class)) {
				fail("Ensure that your field calories in class Apple is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field calories in class Apple that is of type int, and is private " +
					"and final!");
			return;
		}

		if (calories.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int calories in class Apple is both private and final!");
			return;
		}

		try {
			carbs = Apple.class.getDeclaredField("carbs");
			if (!carbs.getType().equals(int.class)) {
				fail("Ensure that your field carbs in class Apple is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field carbs in class Apple that is of type int, and is private " +
					"and final!");
			return;
		}

		if (carbs.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int carbs in class Apple is both private and final!");
			return;
		}

		try {
			protein = Apple.class.getDeclaredField("protein");
			if (!protein.getType().equals(int.class)) {
				fail("Ensure that your field protein in class Apple is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field protein in class Apple that is of type int, and is private " +
					"and final!");
			return;
		}

		if (protein.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int protein in class Apple is both private and final!");
			return;
		}

		try {
			fats = Apple.class.getDeclaredField("fats");
			if (!fats.getType().equals(int.class)) {
				fail("Ensure that your field fats in class Apple is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field fats in class Apple that is of type int, and is private " +
					"and final!");
			return;
		}

		if (fats.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int fats in class Apple is both private and final!");
			return;
		}

		try {
			allergens = Apple.class.getDeclaredField("allergens");
			if (!allergens.getType().equals(String[].class)) {
				fail("Ensure that your field allergens in class Apple is of type String[], and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field allergens in class Apple that is of type String[], and is private " +
					"and final!");
			return;
		}

		if (allergens.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int allergens in class Apple is both private and final!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleConstructor() {
		Constructor<?> appleConstructor;
		try {
			appleConstructor = Apple.class.getDeclaredConstructor(int.class, int.class, int.class, int.class,
					String[].class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class Apple that takes four ints and a String array!");
			return;
		}

		if (appleConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Apple is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleGetAllergensMethod() {
		Method getAllergensMethod;

		try {
			getAllergensMethod = Apple.class.getDeclaredMethod("getAllergens");
			if (!getAllergensMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method getAllergens in class Apple returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getAllergens in class Apple that returns a String and is public!");
			return;
		}

		if (getAllergensMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getAllergens in class Apple is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleGetCalorieCountMethod() {
		Method getCaloricCountMethod;

		try {
			getCaloricCountMethod = Apple.class.getDeclaredMethod("getCaloricCount");
			if (!getCaloricCountMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getCaloricCount in class Apple returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getCaloricCount in class Apple that returns an int and is public!");
			return;
		}

		if (getCaloricCountMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getCaloricCount in class Apple is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleGetCarbohydratesMethod() {
		Method getCarbohydratesMethod;

		try {
			getCarbohydratesMethod = Apple.class.getDeclaredMethod("getCarbohydrates");
			if (!getCarbohydratesMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getCarbohydrates in class Apple returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getCarbohydrates in class Apple that returns an int and is public!");
			return;
		}

		if (getCarbohydratesMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getCarbohydrates in class Apple is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleGetProteinMethod() {
		Method getProteinMethod;

		try {
			getProteinMethod = Apple.class.getDeclaredMethod("getProtein");
			if (!getProteinMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getProtein in class Apple returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getProtein in class Apple that returns an int and is public!");
			return;
		}

		if (getProteinMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getProtein in class Apple is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleGetFatsMethod() {
		Method getFatsMethod;

		try {
			getFatsMethod = Apple.class.getDeclaredMethod("getFats");
			if (!getFatsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getFats in class Apple returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getFats in class Apple that returns an int and is public!");
			return;
		}

		if (getFatsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getFats in class Apple is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleIsConsumableMethod() {
		Method isConsumableMethod;

		try {
			isConsumableMethod = Apple.class.getDeclaredMethod("isConsumable");
			if (!isConsumableMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method isConsumable in class Apple returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isConsumable in class Apple that returns a boolean and is public!");
			return;
		}

		if (isConsumableMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method isConsumable in class Apple is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleCountryOfOriginMethod() {
		Method countryOfOriginMethod;

		try {
			countryOfOriginMethod = Apple.class.getDeclaredMethod("countryOfOrigin");
			if (!countryOfOriginMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method countryOfOrigin in class Apple returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method countryOfOrigin in class Apple that returns a String and is public!");
			return;
		}

		if (countryOfOriginMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method countryOfOrigin in class Apple is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleIsHealthyMethod() {
		Method isHealthyMethod;

		try {
			isHealthyMethod = Apple.class.getDeclaredMethod("isHealthy");
			if (!isHealthyMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method isHealthy in class Apple returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isHealthy in class Apple that returns a boolean and is public!");
			return;
		}

		if (isHealthyMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method isHealthy in class Apple is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAppleImplements() {
		Class<?>[] expectedImplements = {Food.class, Consumable.class};
		Class<?>[] studentImplements = Apple.class.getInterfaces();
		Assert.assertArrayEquals("Ensure that you have implemented both the Consumable and Food interfaces in " +
				"class Apple!", expectedImplements, studentImplements);
	}

	@Test(timeout = 1000)
	public void testAppleInnerWorkings() {
		String[] appleAllergens = {"Apple Core", "Apple Skin"};
		Apple a = new Apple(100, 5, 0, 2, appleAllergens);
		Assert.assertEquals("Ensure that your method getAllergens in class Apple returns the allergens array as one " +
				"comma separated String!", "Apple Core, Apple Skin", a.getAllergens());
		Assert.assertEquals("Ensure that your method countryOfOrigin in class Apple returns the correct country of " +
				"origin for an Apple as specified by the Javadoc!", "China", a.countryOfOrigin());
		Assert.assertEquals("Ensure that your method getCaloricCount in class Apple returns the correct caloric count" +
				" of an Apple!", 100, a.getCaloricCount());
		Assert.assertEquals("Ensure that your method getProtein in class Apple returns the correct protein count" +
				" of an Apple!", 0, a.getProtein());
		Assert.assertEquals("Ensure that your method getCarbohydrates in class Apple returns the correct " +
				"carbohydrate count of an Apple!", 5, a.getCarbohydrates());
		Assert.assertEquals("Ensure that your method getFats in class Apple returns the correct fat count" +
				" of an Apple!", 2, a.getFats());
		Assert.assertTrue("Ensure that your method isConsumable in class Apple returns the correct consumablity" +
				" of an Apple!", a.isConsumable());
		Assert.assertTrue("Ensure that your method getCaloricCount in class Apple returns the correct healthiness" +
				" of an Apple!", a.isHealthy());
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
