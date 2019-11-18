import java.util.Scanner;

/**
 * For this question, you will be implementing a ROT13 encryption mechanism. ROT13 is an encryption form where every
 * letter is rotated 13 places. This means that an 'a' becomes an 'n', and an 'm' becomes a 'z' and so on. You can
 * assume that every String inputted in this question is lowercase. In addition, only Strings consisting of letters
 * and spaces should be considered. Similarly, if a space is part of the word entered, that should remain a space,
 * even post rotation.
 *
 * Sample Usage:
 *   - "curtain"           // displays "phegnva".
 *   - "air force one"     // displays "nve sbepr bar"
 *   - "purdue university" // displays "cheqhr havirefvgl"
 *   - "piazza"            // displays "cvnmmn"
 *
 * NOTE: When printing the result, be sure to print the result and nothing else using println().
 */
public class Rot13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string;

		System.out.print("Enter a String: ");

		string = scanner.nextLine();

		scanner.close();

		//Do not modify above this line.

		//TODO: implement your logic here
		String[] splitWords = string.split(" ");
		String finalSentence = "";
		for (int y = 0; y < splitWords.length; y++){
			String word = splitWords[y];
			String newWord = "";
			for (int i = 0; i < word.length(); i++) {
				int a = word.charAt(i);
				char newChar;
				if (a > 'm') {
					newChar = (char) (a - 13);
				} else {
					newChar = (char) (a + 13);
				}
				System.out.println(newChar);
				newWord += newChar;
			}
			finalSentence += newWord + " ";
		}
		finalSentence = finalSentence.strip();
		System.out.println(finalSentence);
	} //main
}