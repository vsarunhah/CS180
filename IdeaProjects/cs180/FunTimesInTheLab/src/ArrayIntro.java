import java.util.Scanner;
/**
 * LAB07 - Array Intro
 * Stores words the user enters and then prints them back using formatting. 
 *
 */
public class ArrayIntro {
    
     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         
         String[] wordStorage;
         
         System.out.println("How many words?"); 
         
         int numElements = scan.nextInt();
         scan.nextLine();

         wordStorage = new String[numElements];
         
         for (int i = 0; i < numElements; i++) {
             System.out.println("Please enter word " + (i + 1) + " of" + numElements + ": ");
             wordStorage[i] = scan.nextLine();
         }
         
         for (String word: wordStorage) {
             System.out.println("Word is: " + word);
         }
         
        
         
     }
    
}