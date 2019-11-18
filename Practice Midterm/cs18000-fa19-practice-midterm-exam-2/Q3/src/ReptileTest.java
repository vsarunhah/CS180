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

public class ReptileTest {
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
	public void testImplements() {
		Class<?>[] studentImplements = Reptile.class.getInterfaces();
		Class<?>[] expectedImplements = {Animal.class};
		Assert.assertArrayEquals("Ensure that the Reptile class implements only the Animal interface!",
				expectedImplements, studentImplements);
	}

	@Test(timeout = 1000)
	public void testClassIsAbstract() {
		int classModifiers = Reptile.class.getModifiers();
		Assert.assertEquals("Ensure that your class Reptile is public and abstract!",
				Modifier.PUBLIC + Modifier.ABSTRACT, classModifiers);
	}

	@Test(timeout = 1000)
	public void testReptileFields() {
		Field habitat;
		Field numLegs;
		Field energy;
		Field laysEggs;
		Field isNocturnal;

		try {
			habitat = Reptile.class.getDeclaredField("habitat");
			if (!habitat.getType().equals(String.class)) {
				fail("Ensure that your field habitat in class Reptile is of type String!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field habitat in class Reptile, that is of type String, and is private and" +
					" final!");
			return;
		}

		if (habitat.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your String habitat in class Reptile is both private and final!");
			return;
		}

		try {
			numLegs = Reptile.class.getDeclaredField("numLegs");
			if (!numLegs.getType().equals(int.class)) {
				fail("Ensure that your field numLegs in class Reptile is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field numLegs in class Reptile, that is of type int, and is private and" +
					" final!");
			return;
		}

		if (numLegs.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your String numLegs in class Reptile is both private and final!");
			return;
		}

		try {
			energy = Reptile.class.getDeclaredField("energy");
			if (!energy.getType().equals(int.class)) {
				fail("Ensure that your field energy in class Reptile is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field energy in class Reptile, that is of type int, and is protected!");
			return;
		}

		if (energy.getModifiers() != Modifier.PROTECTED) {
			fail("Ensure that your int energy in class Reptile is both protected!");
			return;
		}

		try {
			isNocturnal = Reptile.class.getDeclaredField("isNocturnal");
			if (!isNocturnal.getType().equals(boolean.class)) {
				fail("Ensure that your field isNocturnal in class Reptile is of type boolean!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field isNocturnal in class Reptile, that is of type boolean, and is " +
					"private and final!");
			return;
		}

		if (isNocturnal.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your boolean isNocturnal in class Reptile is protected!");
			return;
		}

		try {
			laysEggs = Reptile.class.getDeclaredField("laysEggs");
			if (!laysEggs.getType().equals(boolean.class)) {
				fail("Ensure that your field laysEggs in class Reptile is of type boolean!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field laysEggs in class Reptile, that is of type boolean, and is private " +
					"and final!");
			return;
		}

		if (laysEggs.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your boolean laysEggs in class Reptile is both protected!");
		}
	}

	@Test(timeout = 1000)
	public void testReptileConstructor() {
		Constructor<?> ReptileConstructor;

		try {
			ReptileConstructor = Reptile.class.getDeclaredConstructor(String.class, int.class, boolean.class,
					boolean.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class Reptile that takes one String, one int, and two " +
					"booleans!");
			return;
		}

		if (ReptileConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Reptile is public!");
		}
	}

	@Test(timeout = 1000)
	public void testHasLegsMethod() {
		Method hasLegsMethod;
		try {
			hasLegsMethod = Reptile.class.getDeclaredMethod("hasLegs");
			if (!hasLegsMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method hasLegs in class Reptile returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method hasLegs that returns a boolean in class Reptile!");
			return;
		}
		if (hasLegsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method hasLegs in class Reptile is public!");
		}
	}

	@Test(timeout = 1000)
	public void testNumLegsMethod() {
		Method numLegsMethod;
		try {
			numLegsMethod = Reptile.class.getDeclaredMethod("numLegs", boolean.class);
			if (!numLegsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method numLegs in class Reptile will return an int!");
				return;
			}
			if (!numLegsMethod.getParameterTypes()[0].equals(boolean.class)) {
				fail("Ensure that your method numLegs in class Reptile will take a boolean as a parameter");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method numLegs that returns an int in class Reptile!");
			return;
		}
		if (numLegsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method numLegs in class Reptile is public!");
		}
	}

	@Test(timeout = 1000)
	public void testGetHabitatMethod() {
		Method getHabitatMethod;
		try {
			getHabitatMethod = Reptile.class.getDeclaredMethod("getHabitat");
			if (!getHabitatMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method getHabitat in class Reptile returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getHabitat that returns a String in class Reptile!");
			return;
		}
		if (getHabitatMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getHabitat in class Reptile is public!");
		}
	}

	@Test(timeout = 1000)
	public void testLaysEggsMethod() {
		Method laysEggsMethod;
		try {
			laysEggsMethod = Reptile.class.getDeclaredMethod("laysEggs");
			if (!laysEggsMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method laysEggs in class Reptile returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method laysEggs that returns a boolean in class Reptile!");
			return;
		}
		if (laysEggsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method laysEggs in class Reptile is public!");
		}
	}

	@Test(timeout = 1000)
	public void testIsNocturnalMethod() {
		Method isNocturnalMethod;
		try {
			isNocturnalMethod = Reptile.class.getDeclaredMethod("isNocturnal");
			if (!isNocturnalMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method isNocturnal in class Reptile returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isNocturnal that returns a boolean in class Reptile!");
			return;
		}
		if (isNocturnalMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method isNocturnal in class Reptile is public!");
		}
	}

	@Test(timeout = 1000)
	public void testUnimplementedMethodIsColdBlooded() {
		Method isColdBlooded;
		try {
			isColdBlooded = Reptile.class.getDeclaredMethod("isColdBlooded");
			if (!isColdBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that your abstract method isColdBlooded in class Reptile will return a boolean when " +
						"implemented!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method contract for the abstract method isColdBlooded that will return a " +
					"boolean when implemented!");
			return;
		}
		if (isColdBlooded.getModifiers() != Modifier.PUBLIC + Modifier.ABSTRACT) {
			fail("Ensure that your method contract for isColdBlooded in class Reptile is public and abstract!");
		}
	}

	@Test(timeout = 1000)
	public void testUnimplementedMethodIsWarmBlooded() {
		Method isWarmBlooded;
		try {
			isWarmBlooded = Reptile.class.getDeclaredMethod("isWarmBlooded");
			if (!isWarmBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that your abstract method isWarmBlooded in class Reptile will return a boolean when " +
						"implemented!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method contract for the abstract method isWarmBlooded that will return a " +
					"boolean when implemented!");
			return;
		}
		if (isWarmBlooded.getModifiers() != Modifier.PUBLIC + Modifier.ABSTRACT) {
			fail("Ensure that your method contract for isWarmBlooded in class Reptile is public and abstract!");
		}
	}

	@Test(timeout = 1000)
	public void testUnimplementedMethodShedSkin() {
		Method shedSkinMethod;
		try {
			shedSkinMethod = Reptile.class.getDeclaredMethod("shedSkin");
			if (!shedSkinMethod.getReturnType().equals(void.class)) {
				fail("Ensure that your abstract method isWarmBlooded in class Reptile will return nothing (void) when" +
						" implemented!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method contract for the abstract method isWarmBlooded that will return " +
					"nothing (void) when implemented!");
			return;
		}
		if (shedSkinMethod.getModifiers() != Modifier.PUBLIC + Modifier.ABSTRACT) {
			fail("Ensure that your method contract for shedSkin in class Reptile is public and abstract!");
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
