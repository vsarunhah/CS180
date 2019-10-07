import java.util.ArrayList;
import java.util.Arrays;

public class WordSearcher {
    public static void main(String[] args) {
        ArrayList<String> wordLibrary = new ArrayList<String>(Arrays.asList(args[0].split(",")));
        //creating a string arraylist of the words we're looking for
        ArrayList<String> wordsFound = new ArrayList<String>();
        String puzzle = args[1];
        ArrayList<String> reversed = new ArrayList<String>();
        if (wordLibrary.size() == 1 || puzzle.length() == 1){
            return;
        }
        /**creating a string array to be filled with the reverse of
         the words we're looking for */
        for (int i = 0; i < wordLibrary.size(); i++) {
            reversed.add(reverse(wordLibrary.get(i)));
        } //reversing the word and inputting into reversed.

        for (int i = 0; i < wordLibrary.size(); i++){ //forward word check
            boolean wordFound = DispersedSearch(wordLibrary.get(i), puzzle);
            if (wordFound) {
                if (!wordsFound.contains(wordLibrary.get(i))) {
                    wordsFound.add(wordLibrary.get(i)); //prints out the word if it is found
                }
            }
        }

        for (int i = 0; i < reversed.size(); i++) { //reverse search
            boolean wordFound = DispersedSearch(reversed.get(i), puzzle);
            if (wordFound) {
                if (!wordsFound.contains(wordLibrary.get(i))) {
                    //System.out.println(wordLibrary.get(i)); //prints out the word if it is found
                    wordsFound.add(wordLibrary.get(i));
                }
            }
        }

        for (int i = 0; i < wordsFound.size(); i++) {
            System.out.println(wordsFound.get(i));
        }

    }

    public static String reverse(String word) { //method to reverse a word
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        return reversed;
    }

    public static boolean DispersedSearch(String word, String puzzle){ //method to conduct a word search
        int lastCharIndex = 0; //keep count of the last character index of the word
        boolean found = false; //boolean for if the word has been found
        mainLoop: //naming the loop
        for (int i = 0; i < word.length(); i++){ //looping through the letters of the word
            char currentChar = word.charAt(i); //keeping of the current character being searched for
            boolean charFound = false;  //boolean for whether the character has been found or not
            for (int y = lastCharIndex; y < puzzle.length(); y++){
                /**looping through each letter in the puzzle,
                 * starting from the index of the last character.
                 */
                if (currentChar == puzzle.charAt(y) ){
                    charFound = true;
                    lastCharIndex = y;
                    break;
                }
                if (y == puzzle.length() -1 && !charFound){ //case for if it's the last character in the puzzle and the character hasn't been found yet.
                    return false;
                }
            }
            if (!charFound){
                break mainLoop; //breaking out of mainLoop because the character hasn't been found.
            }
           if (i == word.length()-1 && charFound){
               /** if it's the last character and the last iteration and the character has been found,
                * the word has been found as well.
                */

               found = true;
           }
        }
        return found;
    }

}