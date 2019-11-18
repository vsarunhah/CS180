import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.fail;

public class CollegeTest {
	private final InputStream originalInput = System.in;
	private final String TA_ERROR_MESSAGE = "You bumped into an error! Please contact a TA immediately.";
	private final PrintStream originalOutput = System.out;

	@SuppressWarnings("FieldCanBeLocal")
	private ByteArrayInputStream testIn;

	private ByteArrayOutputStream testOut;

	@Before
	public void outputStart() {
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	@SuppressWarnings("unchecked")
	@Test(timeout = 1000)
	public void testCollegeFields() {
		Field arrayListClasses;
		ArrayList<String> sol = new ArrayList<>();
		ArrayList<String> stu;
		String solType = sol.getClass().getTypeName();
		String stuType;
		Field collegeName;
		Field location;
		Field numClasses;
		Field maxClasses;

		try {
			arrayListClasses = College.class.getDeclaredField("classes");
			arrayListClasses.setAccessible(true);
			stu = (ArrayList<String>) arrayListClasses.get(new College("", -1, ""));
			stuType = stu.getClass().getTypeName();
			if (!stuType.equals(solType)) {
				fail("Ensure that your ArrayList classes in class College is of type String!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have an ArrayList<String> classes in class College that is private!");
			return;
		} catch (IllegalAccessException e) {
			restoreInputAndOutput();
			System.out.println(TA_ERROR_MESSAGE + " ERR CODE " + "CT1AL");
			return;
		}

		if (arrayListClasses.getModifiers() != Modifier.PRIVATE) {
			fail("Ensure that your ArrayList<String> classes in class College is of scope private!");
			return;
		}

		try {
			collegeName = College.class.getDeclaredField("name");
			if (collegeName.getType() != String.class) {
				fail("Ensure that your field name in class College is of type String!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a String name in class College that is private and final!");
			return;
		}

		if (collegeName.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your String name in class College is private and final!");
			return;
		}

		try {
			location = College.class.getDeclaredField("location");
			if (location.getType() != String.class) {
				fail("Ensure that your field location in class College is of type String!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a String location in class College that is private and final!");
			return;
		}

		if (location.getModifiers() != Modifier.PRIVATE + Modifier.FINAL) {
			fail("Ensure that your String location in class college is private and final!");
		}

		try {
			numClasses = College.class.getDeclaredField("numClasses");
			if (numClasses.getType() != int.class) {
				fail("Ensure that your field numClasses in class College is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a int numClasses in class College that is private!");
			return;
		}

		if (numClasses.getModifiers() != Modifier.PRIVATE) {
			fail("Ensure that your int numClasses in class college is private!");
		}

		try {
			maxClasses = College.class.getDeclaredField("maxClasses");
			if (numClasses.getType() != int.class) {
				fail("Ensure that your field maxClasses in class College is of type int!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a int maxClasses in class College that is private!");
			return;
		}

		if (maxClasses.getModifiers() != Modifier.PRIVATE) {
			fail("Ensure that your int maxClasses in class college is private!");
		}
	}

	@Test(timeout = 1000)
	public void testCollegeConstructor() {
		Constructor<?> collegeConstructor;
		try {
			collegeConstructor = College.class.getDeclaredConstructor(String.class, int.class, String.class);
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a constructor in class College that takes in two Strings and an integer and " +
					"is public!");
			return;
		}

		if (collegeConstructor.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your constructor in class College is public!");
		}
	}

	@Test(timeout = 1000)
	public void testAddClassMethod() {
		Method addClassMethod;
		Class<?>[] expectedParameterTypes = {String.class};
		try {
			addClassMethod = College.class.getDeclaredMethod("addClass", String.class);
			if (addClassMethod.getReturnType() != void.class) {
				fail("Ensure that your method addClass in class College returns nothing (void)!");
				return;
			}
			if (!Arrays.equals(addClassMethod.getParameterTypes(), expectedParameterTypes)) {
				fail("Ensure that your method addClass in class College takes one String as a parameter!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method called addClass in class College that takes one String as a " +
					"parameter, returns nothing (void), and is public!");
			return;
		}

		if (addClassMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method addClass is of scope public!");
		}
	}

	@Test(timeout = 1000)
	public void testGetNameMethod() {
		Method getNameMethod;
		try {
			getNameMethod = College.class.getDeclaredMethod("getName");
			if (getNameMethod.getReturnType() != String.class) {
				fail("Ensure that your method getName in class College returns a String!");
				return;
			}
			if (getNameMethod.getParameterTypes().length > 0) {
				fail("Ensure that your method getName in class College takes no parameters!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method called getName in class College takes no parameters, returns a " +
					"String, and is public!");
			return;
		}

		if (getNameMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getName is of scope public!");
		}
	}

	@Test(timeout = 1000)
	public void testGetNumClassesMethod() {
		Method getNumClassesMethod;
		try {
			getNumClassesMethod = College.class.getDeclaredMethod("getNumClasses");
			if (getNumClassesMethod.getReturnType() != int.class) {
				fail("Ensure that your method getNumClasses in class College returns an int!");
				return;
			}
			if (getNumClassesMethod.getParameterTypes().length > 0) {
				fail("Ensure that your method getNumClasses in class College takes no parameters!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method called getNumClasses in class College takes no parameters, returns an "
					+ "int, and is public!");
			return;
		}

		if (getNumClassesMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getNumClasses is of scope public!");
		}
	}

	@Test(timeout = 1000)
	public void testGetMaxNumClasses() {
		Method getMaxNumClassesMethod;
		try {
			getMaxNumClassesMethod = College.class.getDeclaredMethod("getMaxNumClasses");
			if (getMaxNumClassesMethod.getReturnType() != int.class) {
				fail("Ensure that your method getMaxNumClasses in class College returns an int!");
				return;
			}
			if (getMaxNumClassesMethod.getParameterTypes().length > 0) {
				fail("Ensure that your method getMaxNumClasses in class College takes no parameters!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method called getMaxNumClasses in class College takes no parameters, returns" +
					" an int, and is public!");
			return;
		}

		if (getMaxNumClassesMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getMaxNumClasses is of scope public!");
		}
	}

	@Test(timeout = 1000)
	public void testGetLocationMethod() {
		Method getLocationMethod;
		try {
			getLocationMethod = College.class.getDeclaredMethod("getLocation");
			if (getLocationMethod.getReturnType() != String.class) {
				fail("Ensure that your method getLocation in class College returns a String!");
				return;
			}
			if (getLocationMethod.getParameterTypes().length > 0) {
				fail("Ensure that your method getLocation in class College takes no parameters!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method called getLocation in class College takes no parameters, returns a "
					+ "String, and is public!");
			return;
		}

		if (getLocationMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getLocation is of scope public!");
		}
	}

	@Test(timeout = 1000)
	public void testGetClassesMethod() {
		Method getClassesMethod;
		try {
			getClassesMethod = College.class.getDeclaredMethod("getClasses");
			if (getClassesMethod.getReturnType() != String.class) {
				fail("Ensure that your method getClasses in class College returns a String!");
				return;
			}
			if (getClassesMethod.getParameterTypes().length > 0) {
				fail("Ensure that your method getClasses in class College takes no parameters!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method called getClasses in class College takes no parameters, returns a "
					+ "String, and is public!");
			return;
		}

		if (getClassesMethod.getModifiers() != Modifier.PUBLIC) {
			fail("Ensure that your method getClasses is of scope public!");
		}
	}

	@Test(timeout = 1000)
	public void testCollegeInnerWorkings() {
		College purdueUniversity = new College("Purdue University", 500, "West Lafayette");
		College indianaUniversity = new College("Indiana University", 300, "Bloomington");
		String expected_purdue_classes = "CS18000, CS18200, CS24000, CS25000, CS25100, CS25200";
		String expected_indiana_classes = "CSCI110, CSCI-A597, CSCI-B501, CSCI-A201";
		purdueUniversity.addClass("CS18000");
		purdueUniversity.addClass("CS18200");
		purdueUniversity.addClass("CS24000");
		purdueUniversity.addClass("CS25000");
		purdueUniversity.addClass("CS25100");
		purdueUniversity.addClass("CS25200");
		indianaUniversity.addClass("CSCI110");
		indianaUniversity.addClass("CSCI-A597");
		indianaUniversity.addClass("CSCI-B501");
		indianaUniversity.addClass("CSCI-A201");

		Assert.assertEquals("Ensure that your method getLocation in class College returns the appropriate " +
				"location of a College!", "West Lafayette", purdueUniversity.getLocation());
		Assert.assertEquals("Ensure that your method getLocation in class College returns the appropriate " +
				"location of a College!", "Bloomington", indianaUniversity.getLocation());

		Assert.assertEquals("Ensure that your method getName in class College returns " +
				"the appropriate name of a College!", "Purdue University", purdueUniversity.getName());
		Assert.assertEquals("Ensure that your method getName in class College returns " +
				"the appropriate name of a College!", "Purdue University", purdueUniversity.getName());

		Assert.assertEquals("Ensure that your method getMaxNumClasses in class College returns the " +
						"maximum number of classes that a College currently can support!", 500,
				purdueUniversity.getMaxNumClasses());
		Assert.assertEquals("Ensure that your method getMaxNumClasses in class College returns the " +
						"maximum number of classes that a College currently can support!", 300,
				indianaUniversity.getMaxNumClasses());

		Assert.assertEquals("Ensure that your method " +
				"getNumClasses in class College returns the number of classes currently " +
				"offered at a specific College!", 6, purdueUniversity.getNumClasses());
		Assert.assertEquals("Ensure that your method " +
				"getNumClasses in class College returns the number of classes currently " +
				"offered at a specific College!", 4, indianaUniversity.getNumClasses());

		Assert.assertEquals("Ensure that your method getClasses in class College returns every " +
						"class that a specific College offers in a comma separated list format!",
				expected_purdue_classes, purdueUniversity.getClasses());

		Assert.assertEquals("Ensure that your method getClasses in class College returns every " +
						"class that a specific College offers in a comma separated list format!",
				expected_indiana_classes, indianaUniversity.getClasses());


	}

	/**
	 * UTILITY METHODS BELOW
	 */
	@SuppressWarnings({"SameParameterValue", "unused"})
	private void receiveInput(String str) {
		testIn = new ByteArrayInputStream(str.getBytes());
		System.setIn(testIn);
	}

	@SuppressWarnings("unused")
	private String getOutput() {
		return testOut.toString();
	}

	@After
	public void restoreInputAndOutput() {
		System.setIn(originalInput);
		System.setOut(originalOutput);
	}
}
