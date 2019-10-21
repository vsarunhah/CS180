import java.io.*;
import java.util.*;

public class BookInformation {
    private List<String> textInBook;

    public BookInformation(String filename) throws java.io.FileNotFoundException {
        File f = new File(filename);
        textInBook = readBook(filename);
    }

    private ArrayList<String> readBook(String filename) throws FileNotFoundException{
        File f = new File(filename);
        ArrayList<String> text = new ArrayList<String>();
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            throw e;
        }
        while (true) {
            String line = null;
            try {
                line = bfr.readLine();
            } catch (Exception e) {
                throw new FileNotFoundException();
            }
            if (line == null) {
                break;
            }
                text.add(line);
        }
        return text;
    }

    public int instanceFinder(String toFind) {
        int counter = 0;
        for (int i = 0; i < textInBook.size(); i++) {
            String str = textInBook.get(i);
            String[] words = str.split(" ");
            for(String word: words){
                if (word.contains(toFind)){
                    counter++;
                }
            }

        }
        return counter;
    }

    public int charactersInBook() {
        int characters = 0;
        for (int i = 0; i < textInBook.size(); i++) {
            characters += textInBook.get(i).length();
        }
        return characters;
    }

    public int numbersInBook() {
        int numbers = 0;
        for (int i = 0; i < textInBook.size(); i++) {
            String s = textInBook.get(i);
            for (int k = 0; k < s.length(); k++){
                if (Character.isDigit(s.charAt(k))){
                    numbers += 1;
                }
            }
        }
        return numbers;
    }
}
