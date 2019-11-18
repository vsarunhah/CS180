package Q3;

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

public class IguanaTest {
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
	public void testIguanaFields() {
		Field isColdBloodedField;
		Field isWarmBloodedField;

		try {
			isColdBloodedField = Iguana.class.getDeclaredField("isColdBlooded");
			if (!isColdBloodedField.getType().equals(boolean.class)) {
				fail("Ensure that your isColdBlooded field in class Iguana is of type boolean!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field isColdBlooded in class Iguana that is of type boolean and is private" +
					" and final!");
			return;
		}

		if (isColdBloodedField.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your isColdBlooded field in class Iguana is both private and final!");
		}

		try {
			isWarmBloodedField = Iguana.class.getDeclaredField("isWarmBlooded");
			if (!isWarmBloodedField.getType().equals(boolean.class)) {
				fail("Ensure that your isWarmBlooded field in class Iguana is of type boolean!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field isWarmBlooded in class Iguana that is of type boolean and is private" +
					" and final!");
			return;
		}

		if (isWarmBloodedField.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your isWarmBlooded field in class Iguana is both private and final!");
		}
	}

	@Test(timeout = 1000)
	public void checkIguanaSuperClass() {
		Assert.assertEquals("Ensure that class Iguana extends class Mammmal!", Reptile.class,
				Iguana.class.getSuperclass());
	}

	@Test(timeout = 1000)
	public void checkIguanaConstructor() {
		Constructor<?> IguanaConstructor;
		try {
			IguanaConstructor = Iguana.class.getDeclaredConstructor(String.class, int.class, boolean.class,
					boolean.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that your constructor in class Iguana takes one String, one int, and two booleans!");
			return;
		}

		if (IguanaConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Iguana is public!");
		}
	}

	@Test(timeout = 1000)
	public void testIsColdBloodedMethod() {
		Method isColdBlooded;
		try {
			isColdBlooded = Iguana.class.getDeclaredMethod("isColdBlooded");
			if (!isColdBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that the method isColdBlooded in class Iguana returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isColdBlooded in class Iguana that returns a boolean and is " +
					"public!");
			return;
		}

		if (isColdBlooded.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method isColdBlooded in class Iguana is public!");
		}
	}

	@Test(timeout = 1000)
	public void testIsWarmBloodedMethod() {
		Method isWarmBlooded;
		try {
			isWarmBlooded = Iguana.class.getDeclaredMethod("isWarmBlooded");
			if (!isWarmBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that the method isWarmBlooded in class Iguana returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isWarmBlooded in class Iguana that returns a boolean and is " +
					"public!");
			return;
		}

		if (isWarmBlooded.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method isWarmBlooded in class Iguana is public!");
		}
	}

	@Test(timeout = 1000)
	public void testConsumeFoodMethod() {
		Method consumeFoodMethod;
		try {
			consumeFoodMethod = Iguana.class.getDeclaredMethod("consumeFood", int.class);
			if (!consumeFoodMethod.getReturnType().equals(void.class)) {
				fail("Ensure that the method consumeFood in class Iguana returns nothing (void)!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method consumeFood in class Iguana that returns nothing (void) and is " +
					"public!");
			return;
		}

		if (consumeFoodMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method consumeFood in class Iguana is public!");
		}
	}

	@Test(timeout = 1000)
	public void testReproduceMethod() {
		Method reproduceMethod;
		try {
			reproduceMethod = Iguana.class.getDeclaredMethod("reproduce");
			if (!reproduceMethod.getReturnType().equals(Reptile.class)) {
				fail("Ensure that the method reproduce in class Iguana returns a new Reptile object!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method reproduce in class Iguana that returns a new Reptile object and is " +
					"public!");
			return;
		}

		if (reproduceMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method reproduce in class Iguana is public!");
		}
	}

	@Test(timeout = 1000)
	public void testDieMethod() {
		Method dieMethod;
		try {
			dieMethod = Iguana.class.getDeclaredMethod("die");
			if (!dieMethod.getReturnType().equals(void.class)) {
				fail("Ensure that the method die in class Iguana returns nothing (void)!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method die in class Iguana that returns nothing (void) and is " +
					"public!");
			return;
		}

		if (dieMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method die in class Iguana is public!");
		}
	}

	@Test(timeout = 1000)
	public void testShedSkinMethod() {
		Method shedSkinMethod;
		try {
			shedSkinMethod = Iguana.class.getDeclaredMethod("shedSkin");
			if (!shedSkinMethod.getReturnType().equals(void.class)) {
				fail("Ensure that the method shedSkin in class Iguana returns nothing (void)!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method shedSkin in class Iguana that returns nothing (void) and is " +
					"public!");
			return;
		}

		if (shedSkinMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method shedSkin in class Iguana is public!");
		}
	}

	@Test(timeout = 1000)
	public void testEqualsMethod() {
		Method equalsMethod;
		try {
			equalsMethod = Iguana.class.getDeclaredMethod("equals", Object.class);
			if (!equalsMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that the method equals in class Iguana returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method equals in class Iguana that returns a boolean and is " +
					"public!");
			return;
		}

		if (equalsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method equals in class Iguana is public!");
		}
	}

	@Test(timeout = 1000)
	public void testToStringMethod() {
		Method toStringMethod;
		try {
			toStringMethod = Iguana.class.getDeclaredMethod("toString");
			if (!toStringMethod.getReturnType().equals(String.class)) {
				fail("Ensure that the method equals in class Iguana returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method toString in class Iguana that returns a String and is " +
					"public!");
			return;
		}

		if (toStringMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method toString in class Iguana is public!");
		}
	}

	@Test(timeout = 1000)
	public void testIguanaOutputs() {
		Animal animal = new Iguana("Craggy Rocks", 6, true, false);
		Reptile rep = new Iguana("Desert", 8, false, true);
		Assert.assertNotEquals("Ensure that two Reptiles of different properties but different instantiation " +
				"classes are considered different animals! (equals method)", animal, rep);
		Assert.assertFalse("Ensure that no Iguanas can be warm blooded!", rep.isWarmBlooded());
		Assert.assertTrue("Ensure that Iguanas can only be cold blooded!", rep.isColdBlooded());
		Assert.assertEquals("Ensure that when an animal is born, it's energy is 0!", 0, rep.energy);
		rep.consumeFood(10);
		rep.consumeFood(10);
		Reptile r = (Reptile) rep.reproduce();
		Assert.assertEquals("Ensure that a reproduction has the same properties as its parent!", r, rep);
		Assert.assertEquals("Ensure that the animal's energy field is updated when they consume food!", 20,
				rep.energy);
		rep.shedSkin();
		Assert.assertEquals("Ensure that a reptile shedding its skin would reset its energy to 0!", 0, rep.energy);
		rep.die();
		Assert.assertNull("Ensure that when an animal has died, they can no longer reproduce a new Animal, but " +
				"instead reproduce a null object!", rep.reproduce());
		Assert.assertEquals("Ensure that the toString method follows the Javadoc for Iguana!", "Iguana[true, " +
				"false, true, false, 8, Desert]", rep.toString());
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
