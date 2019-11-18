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

public class MammalTest {
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
		Class<?>[] studentImplements = Mammal.class.getInterfaces();
		Class<?>[] expectedImplements = {Animal.class};
		Assert.assertArrayEquals("Ensure that the Mammal class implements only the Animal interface!",
				expectedImplements, studentImplements);
	}

	@Test(timeout = 1000)
	public void testClassIsAbstract() {
		int classModifiers = Mammal.class.getModifiers();
		Assert.assertEquals("Ensure that your class Mammal is public and abstract!",
				Modifier.PUBLIC + Modifier.ABSTRACT, classModifiers);
	}

	@Test(timeout = 1000)
	public void testMammalFields() {
		Field habitat;
		Field numLegs;
		Field energy;
		Field isLiveBirth;

		try {
			habitat = Mammal.class.getDeclaredField("habitat");
			if (!habitat.getType().equals(String.class)) {
				fail("Ensure that your field habitat in class Mammal is of type String!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field habitat in class Mammal, that is of type String, and is private and" +
					" final!");
			return;
		}

		if (habitat.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your String habitat in class Mammal is both private and final!");
			return;
		}

		try {
			numLegs = Mammal.class.getDeclaredField("numLegs");
			if (!numLegs.getType().equals(int.class)) {
				fail("Ensure that your field numLegs in class Mammal is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field numLegs in class Mammal, that is of type int, and is private and" +
					" final!");
			return;
		}

		if (numLegs.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your String numLegs in class Mammal is both private and final!");
			return;
		}

		try {
			energy = Mammal.class.getDeclaredField("energy");
			if (!energy.getType().equals(int.class)) {
				fail("Ensure that your field energy in class Mammal is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field energy in class Mammal, that is of type int, and is protected!");
			return;
		}

		if (energy.getModifiers() != Modifier.PROTECTED) {
			fail("Ensure that your int energy in class Mammal is protected!");
			return;
		}

		try {
			isLiveBirth = Mammal.class.getDeclaredField("isLiveBirth");
			if (!isLiveBirth.getType().equals(boolean.class)) {
				fail("Ensure that your field isLiveBirth in class Mammal is of type boolean!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field isLiveBirth in class Mammal, that is of type boolean, and is " +
					"private and final!");
			return;
		}

		if (isLiveBirth.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your int isLiveBirth in class Mammal is private and final!");
		}
	}

	@Test(timeout = 1000)
	public void testMammalConstructor() {
		Constructor<?> MammalConstructor;

		try {
			MammalConstructor = Mammal.class.getDeclaredConstructor(String.class, int.class, boolean.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class Mammal that takes one String, one int, and one " +
					"boolean!");
			return;
		}

		if (MammalConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Mammal is public!");
		}
	}

	@Test(timeout = 1000)
	public void testHasLegsMethod() {
		Method hasLegsMethod;
		try {
			hasLegsMethod = Mammal.class.getDeclaredMethod("hasLegs");
			if (!hasLegsMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method hasLegs in class Mammal returns a boolean!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method hasLegs that returns a boolean in class Mammal!");
		}
	}

	@Test(timeout = 1000)
	public void testNumLegsMethod() {
		Method numLegsMethod;
		try {
			numLegsMethod = Mammal.class.getDeclaredMethod("numLegs", boolean.class);
			if (!numLegsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method numLegs in class Mammal will return an int!");
			}
			if (!numLegsMethod.getParameterTypes()[0].equals(boolean.class)) {
				fail("Ensure that your method numLegs in class Mammal will take a boolean as a parameter");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method numLegs that returns an int in class Mammal!");
		}
	}

	@Test(timeout = 1000)
	public void testGetHabitatMethod() {
		Method getHabitatMethod;
		try {
			getHabitatMethod = Mammal.class.getDeclaredMethod("getHabitat");
			if (!getHabitatMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method getHabitat in class Mammal returns a String!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getHabitat that returns a String in class Mammal!");
		}
	}

	@Test(timeout = 1000)
	public void testUnimplementedMethodIsColdBlooded() {
		Method isColdBlooded;
		try {
			isColdBlooded = Mammal.class.getDeclaredMethod("isColdBlooded");
			if (!isColdBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that your abstract method isColdBlooded in class Mammal will return a boolean when " +
						"implemented!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method contract for the abstract method isColdBlooded in class Mammal " +
					"that will return a boolean when implemented!");
			return;
		}
		if (isColdBlooded.getModifiers() != Modifier.PUBLIC + Modifier.ABSTRACT) {
			fail("Ensure that your method contract for isColdBlooded in class Mammal is public and abstract!");
		}
	}

	@Test(timeout = 1000)
	public void testUnimplementedMethodIsWarmBlooded() {
		Method isWarmBlooded;
		try {
			isWarmBlooded = Mammal.class.getDeclaredMethod("isWarmBlooded");
			if (!isWarmBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that your abstract method isWarmBlooded in class Mammal will return a boolean when " +
						"implemented!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method contract for the abstract method isWarmBlooded in class Mammal " +
					"that will return a boolean when implemented!");
			return;
		}
		if (isWarmBlooded.getModifiers() != Modifier.PUBLIC + Modifier.ABSTRACT) {
			fail("Ensure that your method contract for isWarmBlooded in class Mammal is public and abstract!");
		}
	}

	@Test(timeout = 1000)
	public void testIsLiveBirthMethod() {
		Method isLiveBirth;
		try {
			isLiveBirth = Mammal.class.getDeclaredMethod("isLiveBirth");
			if (!isLiveBirth.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method isLiveBirth in class Mammal will return a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isWarmBlooded in class Mammal " +
					"that will return a boolean!");
			return;
		}
		if (isLiveBirth.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method isLiveBirth in class Mammal is public!");
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
