import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.fail;

public class FileInsertionTests {
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

	@Test(timeout = 1000)
	public void testFileInsertionFields() {
		Field scanner;
		Field insertion;
		Field arrayListContents;
		ArrayList<String> solArrayList = new ArrayList<>();
		ArrayList<?> stuArrayList;

		try {
			scanner = FileInsertion.class.getDeclaredField("sIn");
			if (!scanner.getType().equals(Scanner.class)) {
				fail("Ensure that your field sIn is of type Scanner, and is private and static!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field sIn in class FileInsertion that is of type Scanner, and that is " +
					"private and static!");
			return;
		}

		if (scanner.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your Scanner sIn in class FileInsertion is both private and static!");
			return;
		}

		try {
			insertion = FileInsertion.class.getDeclaredField("insertion");
			if (!insertion.getType().equals(String.class)) {
				fail("Ensure that your field insertion is of type String, and is private and static!");
				return;
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field insertion in class FileInsertion that is of type String, and that is " +
					"private and static!");
			return;
		}

		if (insertion.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your String insertion in class FileInsertion is both private and static!");
			return;
		}

		try {
			arrayListContents = FileInsertion.class.getDeclaredField("contents");
			if (!arrayListContents.getType().equals(ArrayList.class)) {
				fail("Ensure that your field contents is of type ArrayList<String>, and is private and static!");
				return;
			}
			arrayListContents.setAccessible(true);
			receiveInput("\n");
			FileInsertion.main(new String[0]);
			stuArrayList = (ArrayList<?>) arrayListContents.get(null);
			resetNamesFile();
			if (!stuArrayList.getClass().getTypeName().equals(solArrayList.getClass().getTypeName())) {
				fail("Ensure that your ArrayList contents is of type String in class FileInsertion!");
			}
		} catch (NoSuchFieldException e) {
			fail("Ensure that you have a field contents in class FileInsertion that is of type ArrayList, and that is" +
					" private and static!");
			return;
		} catch (IllegalAccessException e) {
			fail(TA_ERROR_MESSAGE + " FIIllAcc");
			return;
		}

		if (arrayListContents.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your ArrayList<String> contents in class FileInsertion is both private and static!");
		}
	}

	@Test(timeout = 1000)
	public void testReadFromFileMethod() {
		ArrayList<String> solArrayList = new ArrayList<>();
		Method readFromFileMethod;

		try {
			readFromFileMethod = FileInsertion.class.getDeclaredMethod("readFromFile");
			if (!readFromFileMethod.getReturnType().equals(ArrayList.class)) {
				fail("Ensure that your method readFromFile in class FileInsertion returns an ArrayList<String>!");
				return;
			}
			if (!readFromFileMethod.getReturnType().getTypeName().equals(solArrayList.getClass().getTypeName())) {
				fail("Ensure that your method readFromFile in class FileInsertion returns an ArrayList<String>!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method readFromFile in class FileInsertiont that takes no parameters, " +
					"returns an ArrayList<String>, and is private and static!");
			return;
		}

		if (readFromFileMethod.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your method readFromFile in class FileInsertion is both private and static!");
		}
	}

	@Test(timeout = 1000)
	public void testPrintToFileMethod() {
		ArrayList<String> solArrayList = new ArrayList<>();
		Method printToFileMethod;

		try {
			printToFileMethod = FileInsertion.class.getDeclaredMethod("printToFile", ArrayList.class);
			if (!printToFileMethod.getReturnType().equals(void.class)) {
				fail("Ensure that your method printToFile in class FileInsertion returns nothing (void)!");
				return;
			}
			if (!printToFileMethod.getParameterTypes()[0].getTypeName().equals(solArrayList.getClass().getTypeName())) {
				fail("Ensure that your method printToFile in class FileInsertion takes an ArrayList<String> as a " +
						"parameter!");
				return;
			}
		} catch (NoSuchMethodException e) {
			fail("Ensure that you have a method printToFile in class FileInsertiont that takes a parameter of an " +
					"ArrayList<String>, returns nothing (void), and is private and static!");
			return;
		}

		if (printToFileMethod.getModifiers() != Modifier.PRIVATE + Modifier.STATIC) {
			fail("Ensure that your method printToFile in class FileInsertion is both private and static!");
		}
	}

	@Test(timeout = 1000)
	public void testOutputOne() {
		resetNamesFile();
		String inFile = "Pearly  \n" +
				"Temple  \n" +
				"Drew  \n" +
				"Jeanetta  \n" +
				"Rocco  \n" +
				"Elmo  \n" +
				"Rosy  \n" +
				"Stacey  \n" +
				"Lakeshia  \n" +
				"Annika  \n" +
				"Thea  \n" +
				"Vinnie  \n" +
				"Elisha  \n" +
				"Ora  \n" +
				"Shaun  \n" +
				"Sang  \n" +
				"Maxima  \n" +
				"Paz  \n" +
				"Carissa  \n" +
				"Creola  \n" +
				"Trudie  \n" +
				"Chae  \n" +
				"Rey  \n" +
				"Lyn  \n" +
				"Landon  \n" +
				"Ellie  \n" +
				"Donetta  \n" +
				"Awilda  \n" +
				"Tanner  \n" +
				"Delisa  \n" +
				"Irwin  \n" +
				"Celestine  \n" +
				"Margaret  \n" +
				"Luis  \n" +
				"Marjory  \n" +
				"Sabine  \n" +
				"Lanette  \n" +
				"Daphine  \n" +
				"Ela  \n" +
				"Ailene  \n" +
				"Kaitlin  \n" +
				"Lupita  \n" +
				"Blanche  \n" +
				"Jacelyn  \n" +
				"Leann  \n" +
				"Vanessa  \n" +
				"Aiko  \n" +
				"Lorraine  \n" +
				"Un  \n" +
				"Bettie  \n";
		ArrayList<String> expected = stringArrayList("Aiko  \n" +
				"Ailene  \n" +
				"Annika  \n" +
				"Awilda  \n" +
				"Bettie  \n" +
				"Blanche  \n" +
				"Carissa  \n" +
				"Celestine  \n" +
				"Chae  \n" +
				"Cordae\n" +
				"Creola  \n" +
				"Daphine  \n" +
				"Delisa  \n" +
				"Donetta  \n" +
				"Drew  \n" +
				"Ela  \n" +
				"Elisha  \n" +
				"Ellie  \n" +
				"Elmo  \n" +
				"Irwin  \n" +
				"Jacelyn  \n" +
				"Jeanetta  \n" +
				"Kaitlin  \n" +
				"Lakeshia  \n" +
				"Landon  \n" +
				"Lanette  \n" +
				"Leann  \n" +
				"Lorraine  \n" +
				"Luis  \n" +
				"Lupita  \n" +
				"Lyn  \n" +
				"Margaret  \n" +
				"Marjory  \n" +
				"Maxima  \n" +
				"Ora  \n" +
				"Paz  \n" +
				"Pearly  \n" +
				"Rey  \n" +
				"Rocco  \n" +
				"Rosy  \n" +
				"Sabine  \n" +
				"Sang  \n" +
				"Shaun  \n" +
				"Stacey  \n" +
				"Tanner  \n" +
				"Temple  \n" +
				"Thea  \n" +
				"Trudie  \n" +
				"Un  \n" +
				"Vanessa  \n" +
				"Vinnie  \n");
		setNames(inFile);
		String input = "Cordae\n";
		receiveInput(input);
		FileInsertion.main(new String[0]);
		try {
			ArrayList<String> studentOutput = (ArrayList<String>) Files.readAllLines(Path.of("output.txt"));
			Assert.assertEquals("Ensure that your program sorts the names, then asks for input, places the input in " +
							"the file, and then resorts the file again, before outputting all the information to output.txt!",
					expected,
					studentOutput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(timeout = 1000)
	public void testOutputTwo() {
		resetNamesFile();
		String inFile = "Kasandra  \n" +
				"Ofelia  \n" +
				"Savannah  \n" +
				"Una  \n" +
				"Trista  \n" +
				"Le  \n" +
				"Janean  \n" +
				"Celine  \n" +
				"Deshawn  \n" +
				"Kacy  \n" +
				"Serita  \n" +
				"Jeffie  \n" +
				"Jacquelynn  \n" +
				"Bernadine  \n" +
				"Burl  \n" +
				"Tama  \n" +
				"Nickolas  \n" +
				"Wilhelmina  \n" +
				"Matt  \n" +
				"Milissa  \n" +
				"Cuc  \n" +
				"Alisia  \n" +
				"Sheena  \n" +
				"Desiree  \n" +
				"Frank  \n" +
				"Dennis  \n" +
				"Sunshine  \n" +
				"Hoyt  \n" +
				"Callie  \n" +
				"Kemberly  \n" +
				"Evita  \n" +
				"Waneta  \n" +
				"Lashawnda  \n" +
				"Erwin  \n" +
				"Mina  \n" +
				"Georgine  \n" +
				"Lia  \n" +
				"Arvilla  \n" +
				"Antoine  \n" +
				"Britta  \n" +
				"Loni  \n" +
				"Elke  \n" +
				"Ana  \n" +
				"Simona  \n" +
				"Vicente  \n" +
				"Viva  \n" +
				"Cherise  \n" +
				"Terri  \n" +
				"Gina  \n" +
				"Pamelia  \n";
		ArrayList<String> expected = stringArrayList("Alisia  \n" +
				"Ana  \n" +
				"Antoine  \n" +
				"Arvilla  \n" +
				"Bernadine  \n" +
				"Britta  \n" +
				"Burl  \n" +
				"Callie  \n" +
				"Celine  \n" +
				"Cherise  \n" +
				"Cuc  \n" +
				"Dennis  \n" +
				"Deshawn  \n" +
				"Desiree  \n" +
				"Elke  \n" +
				"Erwin  \n" +
				"Evita  \n" +
				"Frank  \n" +
				"Georgine  \n" +
				"Gina  \n" +
				"Hoyt  \n" +
				"Jacquelynn  \n" +
				"Janean  \n" +
				"Jeffie  \n" +
				"Kacy  \n" +
				"Kanye\n" +
				"Kasandra  \n" +
				"Kemberly  \n" +
				"Lashawnda  \n" +
				"Le  \n" +
				"Lia  \n" +
				"Loni  \n" +
				"Matt  \n" +
				"Milissa  \n" +
				"Mina  \n" +
				"Nickolas  \n" +
				"Ofelia  \n" +
				"Pamelia  \n" +
				"Savannah  \n" +
				"Serita  \n" +
				"Sheena  \n" +
				"Simona  \n" +
				"Sunshine  \n" +
				"Tama  \n" +
				"Terri  \n" +
				"Trista  \n" +
				"Una  \n" +
				"Vicente  \n" +
				"Viva  \n" +
				"Waneta  \n" +
				"Wilhelmina  \n");
		setNames(inFile);
		String input = "Kanye\n";
		receiveInput(input);
		FileInsertion.main(new String[0]);
		try {
			ArrayList<String> studentOutput = (ArrayList<String>) Files.readAllLines(Path.of("output.txt"));
			Assert.assertEquals("Ensure that your program sorts the names, then asks for input, places the input in " +
							"the file, and then resorts the file again, before outputting all the information to output.txt!",
					expected,
					studentOutput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(timeout = 1000)
	public void testOutputThree() {
		resetNamesFile();
		String inFile = "Zola  \n" +
				"Stewart  \n" +
				"Carrie  \n" +
				"Ira  \n" +
				"Mi  \n" +
				"Wai  \n" +
				"Shaniqua  \n" +
				"Armando  \n" +
				"Shalon  \n" +
				"Inocencia  \n" +
				"Karma  \n" +
				"Caryl  \n" +
				"Teressa  \n" +
				"Rema  \n" +
				"Maryjane  \n" +
				"Anabel  \n" +
				"Starr  \n" +
				"Nada  \n" +
				"Janett  \n" +
				"Carey  \n" +
				"Sylvie  \n" +
				"Genna  \n" +
				"Jasper  \n" +
				"Margareta  \n" +
				"Lan  \n" +
				"Ralph  \n" +
				"Christie  \n" +
				"Tashina  \n" +
				"Ramonita  \n" +
				"Paz  \n" +
				"Ileen  \n" +
				"Tambra  \n" +
				"Karren  \n" +
				"Hedwig  \n" +
				"Eugenie  \n" +
				"See  \n" +
				"Juan  \n" +
				"Ellis  \n" +
				"Noah  \n" +
				"Nida  \n" +
				"Diamond  \n" +
				"Evette  \n" +
				"Bibi  \n" +
				"Autumn  \n" +
				"Jillian  \n" +
				"May  \n" +
				"Ulysses  \n" +
				"Shawana  \n" +
				"Grayce  \n" +
				"Lauryn  \n";
		ArrayList<String> expected = stringArrayList("Anabel  \n" +
				"Armando  \n" +
				"Autumn  \n" +
				"Bibi  \n" +
				"Carey  \n" +
				"Carrie  \n" +
				"Caryl  \n" +
				"Christie  \n" +
				"Diamond  \n" +
				"Ellis  \n" +
				"Eugenie  \n" +
				"Evette  \n" +
				"Genna  \n" +
				"Grayce  \n" +
				"Hedwig  \n" +
				"Ileen  \n" +
				"Inocencia  \n" +
				"Ira  \n" +
				"Janett  \n" +
				"Jasper  \n" +
				"Jillian  \n" +
				"Juan  \n" +
				"Karma  \n" +
				"Karren  \n" +
				"Kedar\n" +
				"Lan  \n" +
				"Lauryn  \n" +
				"Margareta  \n" +
				"Maryjane  \n" +
				"May  \n" +
				"Mi  \n" +
				"Nada  \n" +
				"Nida  \n" +
				"Noah  \n" +
				"Paz  \n" +
				"Ralph  \n" +
				"Ramonita  \n" +
				"Rema  \n" +
				"See  \n" +
				"Shalon  \n" +
				"Shaniqua  \n" +
				"Shawana  \n" +
				"Starr  \n" +
				"Stewart  \n" +
				"Sylvie  \n" +
				"Tambra  \n" +
				"Tashina  \n" +
				"Teressa  \n" +
				"Ulysses  \n" +
				"Wai  \n" +
				"Zola  \n");
		setNames(inFile);
		String input = "Kedar\n";
		receiveInput(input);
		FileInsertion.main(new String[0]);
		try {
			ArrayList<String> studentOutput = (ArrayList<String>) Files.readAllLines(Path.of("output.txt"));
			Assert.assertEquals("Ensure that your program sorts the names, then asks for input, places the input in " +
							"the file, and then resorts the file again, before outputting all the information to output.txt!",
					expected,
					studentOutput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * UTILITY METHODS BELOW
	 */

	private void resetNamesFile() {
		String original = "Yetta  \n" +
				"Elois  \n" +
				"Dominica  \n" +
				"Adaline  \n" +
				"Verlie  \n" +
				"Remona  \n" +
				"Rutha  \n" +
				"Kimbra  \n" +
				"Kasey  \n" +
				"Maisie  \n" +
				"Juli  \n" +
				"Emilio  \n" +
				"Salvador  \n" +
				"Joeann  \n" +
				"Len  \n" +
				"Taisha  \n" +
				"Chester  \n" +
				"Malik  \n" +
				"Alishia  \n" +
				"Shanita  \n" +
				"Micah  \n" +
				"Cary  \n" +
				"Yuonne  \n" +
				"Pattie  \n" +
				"Emogene  \n" +
				"Kimberly  \n" +
				"Charleen  \n" +
				"Misti  \n" +
				"Bernardina  \n" +
				"Chae  \n" +
				"Gabrielle  \n" +
				"Joanie  \n" +
				"Concepcion\n" +
				"Kaila  \n" +
				"Chanda  \n" +
				"Quinn  \n" +
				"Echo  \n" +
				"Daine  \n" +
				"Paige  \n" +
				"Imogene  \n" +
				"Petrina  \n" +
				"Sade  \n" +
				"Ka  \n" +
				"Jamison  \n" +
				"Desmond  \n" +
				"Miriam  \n" +
				"Gwyneth  \n" +
				"Bobbye  \n" +
				"Louisa  \n" +
				"Cari";
		try (
				PrintWriter pw = new PrintWriter("Names.txt");
				PrintWriter pw2 = new PrintWriter("output.txt")
		) {
			pw.print(original);
			pw.flush();
			pw2.print(original);
			pw.flush();
		} catch (IOException e) {
			fail(TA_ERROR_MESSAGE + " FIResFilOrig");
		}
	}

	private void setNames(String input) {
		try {
			PrintWriter pw = new PrintWriter("Names.txt");
			pw.print(input);
			pw.flush();
		} catch (FileNotFoundException e) {
			fail(TA_ERROR_MESSAGE + "FISetNames");
		}
	}

	private ArrayList<String> stringArrayList(String input) {
		String[] inputSplit = input.split("\n");
		return new ArrayList<>(Arrays.asList(inputSplit));
	}

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
