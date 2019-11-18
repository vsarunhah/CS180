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

public class CapybaraTest {
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
	public void testCapybaraFields() {
		Field isColdBloodedField;
		Field isWarmBloodedField;

		try {
			isColdBloodedField = Capybara.class.getDeclaredField("isColdBlooded");
			if (!isColdBloodedField.getType().equals(boolean.class)) {
				fail("Ensure that your isColdBlooded field in class Capybara is of type boolean!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field isColdBlooded in class Capybara that is of type boolean and is private" +
					" and final!");
			return;
		}

		if (isColdBloodedField.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your isColdBlooded field in class Capybara is both private and final!");
		}

		try {
			isWarmBloodedField = Capybara.class.getDeclaredField("isWarmBlooded");
			if (!isWarmBloodedField.getType().equals(boolean.class)) {
				fail("Ensure that your isWarmBlooded field in class Capybara is of type boolean!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field isWarmBlooded in class Capybara that is of type boolean and is private" +
					" and final!");
			return;
		}

		if (isWarmBloodedField.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your isWarmBlooded field in class Capybara is both private and final!");
		}
	}

	@Test(timeout = 1000)
	public void checkCapybaraSuperClass() {
		Assert.assertEquals("Ensure that class Capybara extends class Mammmal!", Mammal.class,
				Capybara.class.getSuperclass());
	}

	@Test(timeout = 1000)
	public void checkCapybaraConstructor() {
		Constructor<?> capybaraConstructor;
		try {
			capybaraConstructor = Capybara.class.getDeclaredConstructor(String.class, int.class, boolean.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that your constructor in class Capybara takes one String, one int, and one boolean!");
			return;
		}

		if (capybaraConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class Capybara is public!");
		}
	}

	@Test(timeout = 1000)
	public void testIsColdBloodedMethod() {
		Method isColdBlooded;
		try {
			isColdBlooded = Capybara.class.getDeclaredMethod("isColdBlooded");
			if (!isColdBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that the method isColdBlooded in class Capybara returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isColdBlooded in class Capybara that returns a boolean and is " +
					"public!");
			return;
		}

		if (isColdBlooded.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method isColdBlooded in class Capybara is public!");
		}
	}

	@Test(timeout = 1000)
	public void testIsWarmBloodedMethod() {
		Method isWarmBlooded;
		try {
			isWarmBlooded = Capybara.class.getDeclaredMethod("isWarmBlooded");
			if (!isWarmBlooded.getReturnType().equals(boolean.class)) {
				fail("Ensure that the method isWarmBlooded in class Capybara returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method isWarmBlooded in class Capybara that returns a boolean and is " +
					"public!");
			return;
		}

		if (isWarmBlooded.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method isWarmBlooded in class Capybara is public!");
		}
	}

	@Test(timeout = 1000)
	public void testConsumeFoodMethod() {
		Method consumeFoodMethod;
		try {
			consumeFoodMethod = Capybara.class.getDeclaredMethod("consumeFood", int.class);
			if (!consumeFoodMethod.getReturnType().equals(void.class)) {
				fail("Ensure that the method consumeFood in class Capybara returns nothing (void)!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method consumeFood in class Capybara that returns nothing (void) and is " +
					"public!");
			return;
		}

		if (consumeFoodMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method consumeFood in class Capybara is public!");
		}
	}

	@Test(timeout = 1000)
	public void testReproduceMethod() {
		Method reproduceMethod;
		try {
			reproduceMethod = Capybara.class.getDeclaredMethod("reproduce");
			if (!reproduceMethod.getReturnType().equals(Mammal.class)) {
				fail("Ensure that the method reproduce in class Capybara returns a new Mammal object!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method reproduce in class Capybara that returns a new Mammal object and is " +
					"public!");
			return;
		}

		if (reproduceMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method reproduce in class Capybara is public!");
		}
	}

	@Test(timeout = 1000)
	public void testDieMethod() {
		Method dieMethod;
		try {
			dieMethod = Capybara.class.getDeclaredMethod("die");
			if (!dieMethod.getReturnType().equals(void.class)) {
				fail("Ensure that the method die in class Capybara returns nothing (void)!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method die in class Capybara that returns nothing (void) and is " +
					"public!");
			return;
		}

		if (dieMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method die in class Capybara is public!");
		}
	}

	@Test(timeout = 1000)
	public void testEqualsMethod() {
		Method equalsMethod;
		try {
			equalsMethod = Capybara.class.getDeclaredMethod("equals", Object.class);
			if (!equalsMethod.getReturnType().equals(boolean.class)) {
				fail("Ensure that the method equals in class Capybara returns a boolean!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method equals in class Capybara that returns a boolean and is " +
					"public!");
			return;
		}

		if (equalsMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method equals in class Capybara is public!");
		}
	}

	@Test(timeout = 1000)
	public void testToStringMethod() {
		Method toStringMethod;
		try {
			toStringMethod = Capybara.class.getDeclaredMethod("toString");
			if (!toStringMethod.getReturnType().equals(String.class)) {
				fail("Ensure that the method equals in class Capybara returns a String!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method toString in class Capybara that returns a String and is " +
					"public!");
			return;
		}

		if (toStringMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that the method toString in class Capybara is public!");
		}
	}

	@Test(timeout = 1000)
	public void testCapybaraOutputs() {
		Animal animal = new Capybara("Swamp", 4, true);
		Mammal mammal = new Capybara("Swamp", 4, true);
		Assert.assertEquals("Ensure that two Capybaras of the same properties but different instantiation classes " +
				"are considered the same animal! (equals method)", animal, mammal);
		Assert.assertTrue("Ensure that a Capybara can only have live births since it is a mammal!", mammal.isLiveBirth());
		Assert.assertTrue("Ensure that a Capybara can only be warm blooded!", mammal.isWarmBlooded());
		Assert.assertFalse("Ensure that no Capybaras can be cold blooded!", mammal.isColdBlooded());
		Assert.assertEquals("Ensure that when an animal is born, it's energy is 0!", 0, mammal.energy);
		mammal.consumeFood(10);
		mammal.consumeFood(10);
		Capybara c = (Capybara) mammal.reproduce();
		Assert.assertEquals("Ensure that a reproduction has the same properties as its parent!", c, mammal);
		Assert.assertEquals("Ensure that the animal's energy field is updated when they consume food!", 20,
				mammal.energy);
		mammal.die();
		Assert.assertNull("Ensure that when an animal has died, they can no longer reproduce a new Animal, but " +
				"instead reproduce a null object!", mammal.reproduce());
		Assert.assertEquals("Ensure that the toString method follows the Javadoc for Capybara!", "Capybara[false, " +
				"true, true, 4, Swamp]", mammal.toString());
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
