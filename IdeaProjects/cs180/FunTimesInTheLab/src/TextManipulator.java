public class TextManipulator {

	public static void main(String[] args) {
		String textToModify = "Here is some fancy text!";
		String beeMovieIntroduction = "According to all known laws of aviation, there is no way that a bee should be " +
				"able to fly. Its wings are too small to get its fat little body off the ground. The bee, " +
				"of course, flies anyways. Because bees don't care what humans think is impossible.";
		/*
		  Implement the following tasks below, for the String textToModify.

		  1) Display the original text.
		  2) Change the word 'Here' to 'Below'.
		  3) Find and print the starting index of the letter 'f' in the word fancy.
		  4) Change the word 'fancy' to 'cool'.
		  5) Replace the exclamation mark with a period.
		  6) Display the updated text.
		 */
		System.out.println(textToModify);
		System.out.println("");
		textToModify = textToModify.replace("Here", "Below");

		System.out.println(textToModify.indexOf('f'));
		System.out.println("");
		textToModify = textToModify.replace("fancy", "cool");

		textToModify = textToModify.replace("!", ".");

		System.out.println(textToModify);
		System.out.println("");
		/*
		  Implement the following tasks below, for the String beeMovieIntroduction.

		  1) Display the original text.
		  2) Change every instance of the word 'bee' to the word 'grasshopper'.
		  3) Display the updated script.
		  3) Display only the last sentence of the ORIGINAL script.
		  4) Display the entire ORIGINAL script in upper case.
		  5) Display the entire ORIGINAL script in lower case.
		  6) Display the entire ORIGINAL script's length.
		 */

		System.out.println(beeMovieIntroduction);
		System.out.println("");

		String modified = beeMovieIntroduction.replaceAll("bee", "grasshopper");

		System.out.println(modified);
		System.out.println("");

		System.out.println(beeMovieIntroduction.substring(beeMovieIntroduction.lastIndexOf(". ") + 2, beeMovieIntroduction.length()));
		System.out.println("");

		System.out.println(beeMovieIntroduction.toUpperCase());
		System.out.println("");

		System.out.println(beeMovieIntroduction.toLowerCase());
		System.out.println("");

		System.out.println(beeMovieIntroduction.length());
	}
}
