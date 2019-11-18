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

public class CroissantTest {
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
	public void testCroissantFields() {
		Field calories;
		Field carbs;
		Field protein;
		Field fats;
		Field allergens;

		try {
			calories = Croissant.class.getDeclaredField("calories");
			if (!calories.getType().equals(int.class)) {
				fail("Ensure that your field calories in class Croissant is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field calories in class Croissant that is of type int, and is private " +
					"and final!");
			return;
		}

		if (calories.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int calories in class Croissant is both private and final!");
			return;
		}

		try {
			carbs = Croissant.class.getDeclaredField("carbs");
			if (!carbs.getType().equals(int.class)) {
				fail("Ensure that your field carbs in class Croissant is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field carbs in class Croissant that is of type int, and is private " +
					"and final!");
			return;
		}

		if (carbs.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int carbs in class Croissant is both private and final!");
			return;
		}

		try {
			protein = Croissant.class.getDeclaredField("protein");
			if (!protein.getType().equals(int.class)) {
				fail("Ensure that your field protein in class Croissant is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field protein in class Croissant that is of type int, and is private " +
					"and final!");
			return;
		}

		if (protein.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int protein in class Croissant is both private and final!");
			return;
		}

		try {
			fats = Croissant.class.getDeclaredField("fats");
			if (!fats.getType().equals(int.class)) {
				fail("Ensure that your field fats in class Croissant is of type int, and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field fats in class Croissant that is of type int, and is private " +
					"and final!");
			return;
		}

		if (fats.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int fats in class Croissant is both private and final!");
			return;
		}

		try {
			allergens = Croissant.class.getDeclaredField("allergens");
			if (!allergens.getType().equals(String[].class)) {
				fail("Ensure that your field allergens in class Croissant is of type String[], and is private and final!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field allergens in class Croissant that is of type String[], and is private " +
					"and final!");
			return;
		}

		if (allergens.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int allergens in class Croissant is both private and final!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantConstructor() {
		Constructor<?> CroissantConstructor;
		try {
			CroissantConstructor = Croissant.class.getDeclaredConstructor(int.class, int.class, int.class, int.class,
					String[].class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class Croissant that takes four ints and a String array!");
			return;
		}

		if (CroissantConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Croissant is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantGetAllergensMethod() {
		Method getAllergensMethod;

		try {
			getAllergensMethod = Croissant.class.getDeclaredMethod("getAllergens");
			if (!getAllergensMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method getAllergens in class Croissant returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getAllergens in class Croissant that returns a String and is public!");
			return;
		}

		if (getAllergensMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getAllergens in class Croissant is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantGetCalorieCountMethod() {
		Method getCaloricCountMethod;

		try {
			getCaloricCountMethod = Croissant.class.getDeclaredMethod("getCaloricCount");
			if (!getCaloricCountMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getCaloricCount in class Croissant returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getCaloricCount in class Croissant that returns an int and is public!");
			return;
		}

		if (getCaloricCountMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getCaloricCount in class Croissant is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantGetCarbohydratesMethod() {
		Method getCarbohydratesMethod;

		try {
			getCarbohydratesMethod = Croissant.class.getDeclaredMethod("getCarbohydrates");
			if (!getCarbohydratesMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getCarbohydrates in class Croissant returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getCarbohydrates in class Croissant that returns an int and is public!");
			return;
		}

		if (getCarbohydratesMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getCarbohydrates in class Croissant is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantGetProteinMethod() {
		Method getProteinMethod;

		try {
			getProteinMethod = Croissant.class.getDeclaredMethod("getProtein");
			if (!getProteinMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getProtein in class Croissant returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getProtein in class Croissant that returns an int and is public!");
			return;
		}

		if (getProteinMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getProtein in class Croissant is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantGetFatsMethod() {
		Method getFatsMethod;

		try {
			getFatsMethod = Croissant.class.getDeclaredMethod("getFats");
			if (!getFatsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method getFats in class Croissant returns an int!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getFats in class Croissant that returns an int and is public!");
			return;
		}

		if (getFatsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getFats in class Croissant is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantIsConsumableMethod() {
		Method isConsumableMethod;

		try {
			isConsumableMethod = Croissant.class.getDeclaredMethod("isConsumable");
			if (!isConsumableMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method isConsumable in class Croissant returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isConsumable in class Croissant that returns a boolean and is public!");
			return;
		}

		if (isConsumableMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method isConsumable in class Croissant is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantCountryOfOriginMethod() {
		Method countryOfOriginMethod;

		try {
			countryOfOriginMethod = Croissant.class.getDeclaredMethod("countryOfOrigin");
			if (!countryOfOriginMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method countryOfOrigin in class Croissant returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method countryOfOrigin in class Croissant that returns a String and is public!");
			return;
		}

		if (countryOfOriginMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method countryOfOrigin in class Croissant is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantIsHealthyMethod() {
		Method isHealthyMethod;

		try {
			isHealthyMethod = Croissant.class.getDeclaredMethod("isHealthy");
			if (!isHealthyMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method isHealthy in class Croissant returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isHealthy in class Croissant that returns a boolean and is public!");
			return;
		}

		if (isHealthyMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method isHealthy in class Croissant is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCroissantImplements() {
		Class<?>[] expectedImplements = {Food.class, Consumable.class};
		Class<?>[] studentImplements = Croissant.class.getInterfaces();
		Assert.assertArrayEquals("Ensure that you have implemented both the Consumable and Food interfaces in " +
				"class Croissant!", expectedImplements, studentImplements);
	}

	@Test(timeout = 1000)
	public void testCroissantInnerWorkings() {
		String[] CroissantAllergens = {"Wheat", "Milk", "Eggs", "Butter", "Flour"};
		Croissant a = new Croissant(272, 31, 6, 14, CroissantAllergens);
		Assert.assertEquals("Ensure that your method getAllergens in class Croissant returns the allergens array as one " +
				"comma separated String!", "Wheat, Milk, Eggs, Butter, Flour", a.getAllergens());
		Assert.assertEquals("Ensure that your method countryOfOrigin in class Croissant returns the correct country of " +
				"origin for an Croissant as specified by the Javadoc!", "France", a.countryOfOrigin());
		Assert.assertEquals("Ensure that your method getCaloricCount in class Croissant returns the correct caloric count" +
				" of an Croissant!", 272, a.getCaloricCount());
		Assert.assertEquals("Ensure that your method getProtein in class Croissant returns the correct protein count" +
				" of an Croissant!", 6, a.getProtein());
		Assert.assertEquals("Ensure that your method getCarbohydrates in class Croissant returns the correct " +
				"carbohydrate count of an Croissant!", 31, a.getCarbohydrates());
		Assert.assertEquals("Ensure that your method getFats in class Croissant returns the correct fat count" +
				" of an Croissant!", 14, a.getFats());
		Assert.assertTrue("Ensure that your method isConsumable in class Croissant returns the correct consumablity" +
				" of an Croissant!", a.isConsumable());
		Assert.assertFalse("Ensure that your method getCaloricCount in class Croissant returns the correct healthiness" +
				" of an Croissant!", a.isHealthy());
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
