package Q1.Q1d;

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

public class BagelTest {
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
	public void testBagelFields() {
		Field calories;
		Field carbs;
		Field protein;
		Field fats;
		Field allergens;

		try {
			calories = Bagel.class.getDeclaredField("calories");
			if (!calories.getType().equals(int.class)) {
				fail("Ensure that your field calories in class Bagel is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field calories in class Bagel that is of type int, and is private " +
					"and final!");
			return;
		}

		if (calories.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int calories in class Bagel is both private and final!");
			return;
		}

		try {
			carbs = Bagel.class.getDeclaredField("carbs");
			if (!carbs.getType().equals(int.class)) {
				fail("Ensure that your field carbs in class Bagel is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field carbs in class Bagel that is of type int, and is private " +
					"and final!");
			return;
		}

		if (carbs.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int carbs in class Bagel is both private and final!");
			return;
		}

		try {
			protein = Bagel.class.getDeclaredField("protein");
			if (!protein.getType().equals(int.class)) {
				fail("Ensure that your field protein in class Bagel is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field protein in class Bagel that is of type int, and is private " +
					"and final!");
			return;
		}

		if (protein.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int protein in class Bagel is both private and final!");
			return;
		}

		try {
			fats = Bagel.class.getDeclaredField("fats");
			if (!fats.getType().equals(int.class)) {
				fail("Ensure that your field fats in class Bagel is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field fats in class Bagel that is of type int, and is private " +
					"and final!");
			return;
		}

		if (fats.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int fats in class Bagel is both private and final!");
			return;
		}

		try {
			allergens = Bagel.class.getDeclaredField("allergens");
			if (!allergens.getType().equals(String[].class)) {
				fail("Ensure that your field allergens in class Bagel is of type String[], and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field allergens in class Bagel that is of type String[], and is private " +
					"and final!");
			return;
		}

		if (allergens.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int allergens in class Bagel is both private and final!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelConstructor() {
		Constructor<?> BagelConstructor;
		try {
			BagelConstructor = Bagel.class.getDeclaredConstructor(int.class, int.class, int.class, int.class,
					String[].class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class Bagel that takes four ints and a String array!");
			return;
		}

		if (BagelConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Bagel is public!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelGetAllergensMethod() {
		Method getAllergensMethod;

		try {
			getAllergensMethod = Bagel.class.getDeclaredMethod("getAllergens");
			if (!getAllergensMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method getAllergens in class Bagel returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getAllergens in class Bagel that returns a String and is public!");
			return;
		}

		if (getAllergensMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getAllergens in class Bagel is public!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelGetCalorieCountMethod() {
		Method getCaloricCountMethod;

		try {
			getCaloricCountMethod = Bagel.class.getDeclaredMethod("getCaloricCount");
			if (!getCaloricCountMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getCaloricCount in class Bagel returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getCaloricCount in class Bagel that returns an int and is public!");
			return;
		}

		if (getCaloricCountMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getCaloricCount in class Bagel is public!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelGetCarbohydratesMethod() {
		Method getCarbohydratesMethod;

		try {
			getCarbohydratesMethod = Bagel.class.getDeclaredMethod("getCarbohydrates");
			if (!getCarbohydratesMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getCarbohydrates in class Bagel returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getCarbohydrates in class Bagel that returns an int and is public!");
			return;
		}

		if (getCarbohydratesMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getCarbohydrates in class Bagel is public!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelGetProteinMethod() {
		Method getProteinMethod;

		try {
			getProteinMethod = Bagel.class.getDeclaredMethod("getProtein");
			if (!getProteinMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getProtein in class Bagel returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getProtein in class Bagel that returns an int and is public!");
			return;
		}

		if (getProteinMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getProtein in class Bagel is public!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelGetFatsMethod() {
		Method getFatsMethod;

		try {
			getFatsMethod = Bagel.class.getDeclaredMethod("getFats");
			if (!getFatsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getFats in class Bagel returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getFats in class Bagel that returns an int and is public!");
			return;
		}

		if (getFatsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getFats in class Bagel is public!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelIsConsumableMethod() {
		Method isConsumableMethod;

		try {
			isConsumableMethod = Bagel.class.getDeclaredMethod("isConsumable");
			if (!isConsumableMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method isConsumable in class Bagel returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isConsumable in class Bagel that returns a boolean and is public!");
			return;
		}

		if (isConsumableMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method isConsumable in class Bagel is public!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelCountryOfOriginMethod() {
		Method countryOfOriginMethod;

		try {
			countryOfOriginMethod = Bagel.class.getDeclaredMethod("countryOfOrigin");
			if (!countryOfOriginMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method countryOfOrigin in class Bagel returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method countryOfOrigin in class Bagel that returns a String and is public!");
			return;
		}

		if (countryOfOriginMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method countryOfOrigin in class Bagel is public!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelIsHealthyMethod() {
		Method isHealthyMethod;

		try {
			isHealthyMethod = Bagel.class.getDeclaredMethod("isHealthy");
			if (!isHealthyMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method isHealthy in class Bagel returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isHealthy in class Bagel that returns a boolean and is public!");
			return;
		}

		if (isHealthyMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method isHealthy in class Bagel is public!");
		}
	}

	@Test(timeout = 1000)
	public void testBagelImplements() {
		Class<?>[] expectedImplements = {Food.class, Consumable.class};
		Class<?>[] studentImplements = Bagel.class.getInterfaces();
		Assert.assertArrayEquals("Ensure that you have implemented both the Consumable and Food interfaces in " +
				"class Bagel!", expectedImplements, studentImplements);
	}

	@Test(timeout = 1000)
	public void testBagelInnerWorkings() {
		String[] BagelAllergens = {"Yeast", "Wheat"};
		Bagel b = new Bagel(289, 56, 11, 2, BagelAllergens);
		Assert.assertEquals("Ensure that your method getAllergens in class Bagel returns the allergens array as one " +
				"comma separated String!", "Yeast, Wheat", b.getAllergens());
		Assert.assertEquals("Ensure that your method countryOfOrigin in class Bagel returns the correct country of " +
				"origin for an Bagel as specified by the Javadoc!", "Poland", b.countryOfOrigin());
		Assert.assertEquals("Ensure that your method getCaloricCount in class Bagel returns the correct caloric count" +
				" of an Bagel!", 289, b.getCaloricCount());
		Assert.assertEquals("Ensure that your method getProtein in class Bagel returns the correct protein count" +
				" of an Bagel!", 11, b.getProtein());
		Assert.assertEquals("Ensure that your method getCarbohydrates in class Bagel returns the correct " +
				"carbohydrate count of an Bagel!", 56, b.getCarbohydrates());
		Assert.assertEquals("Ensure that your method getFats in class Bagel returns the correct fat count" +
				" of an Bagel!", 2, b.getFats());
		Assert.assertTrue("Ensure that your method isConsumable in class Bagel returns the correct consumablity" +
				" of an Bagel!", b.isConsumable());
		Assert.assertFalse("Ensure that your method getCaloricCount in class Bagel returns the correct healthiness" +
				" of an Bagel!", b.isHealthy());
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
