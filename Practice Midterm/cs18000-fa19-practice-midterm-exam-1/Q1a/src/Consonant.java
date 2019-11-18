import java.util.Scanner;

/**
 * This question will prompt the user for a String, then display the number of consonants contained in it. A consonant
 * is a letter in the alphabet that is not a vowel. The letters considered vowels are "a", "e", "i", "o" and "u".
 *
 * It is safe to assume that
 *   - All characters in the specified String are alphabetic letters
 *   - All of the letters are lowercase
 *   - There are no spaces
 *
 * Special Cases:
 *   - If there are no consonants, display 0
 *   - If all the letters are consonants, display Integer.MAX_VALUE
 *
 * Sample Usage:
 *   - "aeiou" //displays 0
 *   - "hello" //displays 3
 *   - "gym"   //displays 2147483647 (Integer.MAX_VALUE)
 *
 * NOTE: When printing the result, be sure to print the result and nothing else using println().
 */
public class Consonant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;

        System.out.print("Enter a String: ");

        string = scanner.nextLine();
        scanner.close();

        //Do not modify above this line.
        int counter = 0;
        for(int i = 0; i < string.length(); i++){
            char letter = string.charAt(i);
            if(letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o' && letter != 'u'){
                counter += 1;
            }
        }
        if(counter == string.length()){
            counter = Integer.MAX_VALUE;
        }

        System.out.println(counter);
        //TODO: implement your logic here
    } //main
}