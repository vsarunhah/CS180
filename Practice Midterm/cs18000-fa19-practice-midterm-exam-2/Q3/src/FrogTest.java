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

public class FrogTest {
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
	public void testFrogFields() {
		Field isColdBloodedField;
		Field isWarmBloodedField;

		try {
			isColdBloodedField = Frog.class.getDeclaredField("isColdBlooded");
			if (!isColdBloodedField.getType().equals(boolean.class)) {
				fail("Ensure that your isColdBlooded field in class Frog is of type boolean!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field isColdBlooded in class Frog that is of type boolean and is private" +
					" and final!");
			return;
		}

		if (isColdBloodedField.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your isColdBlooded field in class Frog is both private and final!");
		}

		try {
			isWarmBloodedField = Frog.class.getDeclaredField("isWarmBlooded");
			if (!isWarmBloodedField.getType().equals(boolean.class)) {
				fail("Ensure that your isWarmBlooded field in class Frog is of type boolean!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field isWarmBlooded in class Frog that is of type boolean and is private" +
					" and final!");
			return;
		}

		if (isWarmBloodedField.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your isWarmBlooded field in class Frog is both private and final!");
		}
	}

	@Test(timeout = 1000)
	public void checkFrogSuperClass() {
		Assert.assertEquals("Ensure that class Frog extends class Amphibian!", Amphibian.class,
				Frog.class.getSuperclass());
	}

	@Test(timeout = 1000)
	public void checkFrogConstructor() {
		Constructor<?> FrogConstructor;
		try {
			FrogConstructor = Frog.class.getDeclaredConstructor(String.class, int.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that your constructor in class Frog takes one String and one int!");
			return;
		}

		if (FrogConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Frog is public!");
		}
	}

	@Test(timeout = 1000)
	public void testIsColdBloodedMethod() {
		Method isColdBlooded;
		try {
			isColdBlooded = Frog.class.getDeclaredMethod("isColdBlooded");
			if (!isColdBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that the method isColdBlooded in class Frog returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isColdBlooded in class Frog that returns a boolean and is " +
					"public!");
			return;
		}

		if (isColdBlooded.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method isColdBlooded in class Frog is public!");
		}
	}

	@Test(timeout = 1000)
	public void testIsWarmBloodedMethod() {
		Method isWarmBlooded;
		try {
			isWarmBlooded = Frog.class.getDeclaredMethod("isWarmBlooded");
			if (!isWarmBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that the method isWarmBlooded in class Frog returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isWarmBlooded in class Frog that returns a boolean and is " +
					"public!");
			return;
		}

		if (isWarmBlooded.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method isWarmBlooded in class Frog is public!");
		}
	}

	@Test(timeout = 1000)
	public void testConsumeFoodMethod() {
		Method consumeFoodMethod;
		try {
			consumeFoodMethod = Frog.class.getDeclaredMethod("consumeFood", int.class);
			if (!consumeFoodMethod.getReturnType().equals(void.class)) {
				fail("Ensure that the method consumeFood in class Frog returns nothing (void)!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method consumeFood in class Frog that returns nothing (void) and is " +
					"public!");
			return;
		}

		if (consumeFoodMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method consumeFood in class Frog is public!");
		}
	}

	@Test(timeout = 1000)
	public void testReproduceMethod() {
		Method reproduceMethod;
		try {
			reproduceMethod = Frog.class.getDeclaredMethod("reproduce");
			if (!reproduceMethod.getReturnType().equals(Amphibian.class)) {
				fail("Ensure that the method reproduce in class Frog returns a new Amphibian object!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method reproduce in class Frog that returns a new Amphibian object and is " +
					"public!");
			return;
		}

		if (reproduceMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method reproduce in class Frog is public!");
		}
	}

	@Test(timeout = 1000)
	public void testDieMethod() {
		Method dieMethod;
		try {
			dieMethod = Frog.class.getDeclaredMethod("die");
			if (!dieMethod.getReturnType().equals(void.class)) {
				fail("Ensure that the method die in class Frog returns nothing (void)!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method die in class Frog that returns nothing (void) and is " +
					"public!");
			return;
		}

		if (dieMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method die in class Frog is public!");
		}
	}

	@Test(timeout = 1000)
	public void testEqualsMethod() {
		Method equalsMethod;
		try {
			equalsMethod = Frog.class.getDeclaredMethod("equals", Object.class);
			if (!equalsMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that the method equals in class Frog returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method equals in class Frog that returns a boolean and is " +
					"public!");
			return;
		}

		if (equalsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method equals in class Frog is public!");
		}
	}

	@Test(timeout = 1000)
	public void testToStringMethod() {
		Method toStringMethod;
		try {
			toStringMethod = Frog.class.getDeclaredMethod("toString");
			if (!toStringMethod.getReturnType().equals(String.class)) {
				fail("Ensure that the method equals in class Frog returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method toString in class Frog that returns a String and is " +
					"public!");
			return;
		}

		if (toStringMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method toString in class Frog is public!");
		}
	}

	@Test(timeout = 1000)
	public void testFrogOutputs() {
		Animal animal = new Frog("Rainforest", 4);
		Amphibian amp = new Frog("Marshland", 4);
		Assert.assertNotEquals("Ensure that two Frogs of different properties but different instantiation " +
				"classes are considered different animals! (equals method)", animal, amp);
		Assert.assertFalse("Ensure that no Frogs can be warm blooded!", amp.isWarmBlooded());
		Assert.assertTrue("Ensure that Frogs can only be cold blooded!", amp.isColdBlooded());
		Assert.assertEquals("Ensure that when an animal is born, it's energy is 0!", 0, amp.energy);
		amp.consumeFood(10);
		amp.consumeFood(10);
		Frog f = (Frog) amp.reproduce();
		Assert.assertEquals("Ensure that a reproduction has the same properties as its parent!", f, amp);
		Assert.assertEquals("Ensure that the animal's energy field is updated when they consume food!", 20,
				amp.energy);
		amp.die();
		Assert.assertNull("Ensure that when an animal has died, they can no longer reproduce a new Animal, but " +
				"instead reproduce a null object!", amp.reproduce());
		Assert.assertEquals("Ensure that the toString method follows the Javadoc for Frog!", "Frog[true, " +
				"false, 4, Marshland]", amp.toString());
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

