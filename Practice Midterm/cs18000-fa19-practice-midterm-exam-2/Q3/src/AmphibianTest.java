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

public class AmphibianTest {
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
		Class<?>[] studentImplements = Amphibian.class.getInterfaces();
		Class<?>[] expectedImplements = {Animal.class};
		Assert.assertArrayEquals("Ensure that the Amphibian class implements only the Animal interface!",
				expectedImplements, studentImplements);
	}

	@Test(timeout = 1000)
	public void testClassIsAbstract() {
		int classModifiers = Amphibian.class.getModifiers();
		Assert.assertEquals("Ensure that your class Amphibian is public and abstract!",
				Modifier.PUBLIC + Modifier.ABSTRACT, classModifiers);
	}

	@Test(timeout = 1000)
	public void testAmphibianFields() {
		Field habitat;
		Field numLegs;
		Field energy;

		try {
			habitat = Amphibian.class.getDeclaredField("habitat");
			if (!habitat.getType().equals(String.class)) {
				fail("Ensure that your field habitat in class Amphibian is of type String!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field habitat in class Amphibian, that is of type String, and is private and" +
					" final!");
			return;
		}

		if (habitat.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your String habitat in class Amphibian is both private and final!");
			return;
		}

		try {
			numLegs = Amphibian.class.getDeclaredField("numLegs");
			if (!numLegs.getType().equals(int.class)) {
				fail("Ensure that your field numLegs in class Amphibian is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field numLegs in class Amphibian, that is of type int, and is private and" +
					" final!");
			return;
		}

		if (numLegs.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your String numLegs in class Amphibian is both private and final!");
			return;
		}

		try {
			energy = Amphibian.class.getDeclaredField("energy");
			if (!energy.getType().equals(int.class)) {
				fail("Ensure that your field energy in class Amphibian is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field energy in class Amphibian, that is of type int, and is protected!");
			return;
		}

		if (energy.getModifiers() != Modifier.PROTECTED) {
			fail("Ensure that your int energy in class Amphibian is protected!");
		}
	}

	@Test(timeout = 1000)
	public void testAmphibianConstructor() {
		Constructor<?> amphibianConstructor;

		try {
			amphibianConstructor = Amphibian.class.getDeclaredConstructor(String.class, int.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class Amphibian that takes one String and one int!");
			return;
		}

		if (amphibianConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Amphibian is public!");
		}
	}

	@Test(timeout = 1000)
	public void testHasLegsMethod() {
		Method hasLegsMethod;
		try {
			hasLegsMethod = Amphibian.class.getDeclaredMethod("hasLegs");
			if (!hasLegsMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that your method hasLegs in class Amphibian returns a boolean!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method hasLegs that returns a boolean in class Amphibian!");
		}
	}

	@Test(timeout = 1000)
	public void testNumLegsMethod() {
		Method numLegsMethod;
		try {
			numLegsMethod = Amphibian.class.getDeclaredMethod("numLegs", boolean.class);
			if (!numLegsMethod.getReturnType().equals(int.class)) {
				fail("Ensure that your method numLegs in class Amphibian will return an int!");
			}
			if (!numLegsMethod.getParameterTypes()[0].equals(boolean.class)) {
				fail("Ensure that your method numLegs in class Amphibian will take a boolean as a parameter");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method numLegs that returns an int in class Amphibian!");
		}
	}

	@Test(timeout = 1000)
	public void testGetHabitatMethod() {
		Method getHabitatMethod;
		try {
			getHabitatMethod = Amphibian.class.getDeclaredMethod("getHabitat");
			if (!getHabitatMethod.getReturnType().equals(String.class)) {
				fail("Ensure that your method getHabitat in class Amphibian returns a String!");
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method getHabitat that returns a String in class Amphibian!");
		}
	}

	@Test(timeout = 1000)
	public void testUnimplementedMethodIsColdBlooded() {
		Method isColdBlooded;
		try {
			isColdBlooded = Amphibian.class.getDeclaredMethod("isColdBlooded");
			if (!isColdBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that your abstract method isColdBlooded in class Amphibian will return a boolean when " +
						"implemented!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method contract for the abstract method isColdBlooded in class Amphibian " +
					"that will return a boolean when implemented!");
			return;
		}
		if (isColdBlooded.getModifiers() != Modifier.PUBLIC + Modifier.ABSTRACT) {
			fail("Ensure that your method contract for isColdBlooded in class Amphibian is public and abstract!");
		}
	}

	@Test(timeout = 1000)
	public void testUnimplementedMethodIsWarmBlooded() {
		Method isWarmBlooded;
		try {
			isWarmBlooded = Amphibian.class.getDeclaredMethod("isWarmBlooded");
			if (!isWarmBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that your abstract method isWarmBlooded in class Amphibian will return a boolean when " +
						"implemented!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method contract for the abstract method isWarmBlooded in class Amphibian " +
					"that will return a boolean when implemented!");
			return;
		}
		if (isWarmBlooded.getModifiers() != Modifier.PUBLIC + Modifier.ABSTRACT) {
			fail("Ensure that your method contract for isWarmBlooded in class Amphibian is public and abstract!");
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
