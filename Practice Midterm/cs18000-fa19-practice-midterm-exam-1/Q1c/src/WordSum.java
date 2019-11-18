import java.util.Scanner;

/**
 * This question will prompt the user for a String, then display the sum of the spelled out numbers found in it.
 * You only need to consider the words "zero", "one", "two", "six", and "ten". If no spelled out numbers are found in
 * the String, just display 0.
 *
 * Sample Usage:
 *   - "onedunsmoretwo"         // displays 3
 *   - "100TENokaysIX"          // displays 116
 *   - "TheTurkstraThree"       // displays 0
 *   - "LoganKulsixki3"         // displays 6
 *   - "CantSpellLonelyWithout" // displays 1
 *   - "zerozero"               // displays 0
 *
 * NOTE: When printing the result, be sure to print the result and nothing else using println().
 */
public class WordSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;

        System.out.print("Enter a String: ");

        string = scanner.nextLine();

        scanner.close();

        //Do not modify above this line.

        //TODO: implement your logic
        string = string.toLowerCase();
        int sum = 0;
        sum += wordIdentifier(string, "one");
        sum += 2*wordIdentifier(string, "two");
        sum += 6*wordIdentifier(string, "six");
        sum += 10*wordIdentifier(string, "ten");
        System.out.println(sum);

    } //main
    public static int wordIdentifier(String string, String word){
        int sum = 0;
        int index = string.indexOf(word);
        while(index != -1){
            sum += 1;
            string = string.substring(0,index) + string.substring(index+word.length());
            index = string.indexOf(word);
        }
        return sum;
    }
}