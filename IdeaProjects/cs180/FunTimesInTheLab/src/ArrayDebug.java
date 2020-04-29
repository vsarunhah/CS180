import java.util.Scanner;

/**
 * LAB07 - Array Debug
 * Prints out the contents of three arrays.
 *
 */
public class ArrayDebug {
    
      public static void main(String[] args) { 
          Scanner scan = new Scanner(System.in); 
          double [] arrOne = {1,2,3};
          int arrTwo[] = {7,8,9,10,11,12};
          int[] arrThree;
              
          for(int i =0; i < arrOne.length; i++) {
              int x = (int) arrOne[i];
              System.out.print("["+x+"]\t");
          }
          
          int numElements; 
          
          System.out.println("\nHow many elements for arrThree?"); 
          numElements = scan.nextInt(); 
          arrThree = new int[numElements];
          for(int i =0; i < numElements; i++) {
              System.out.println("Enter element " + (i+1) + ": ");
              arrThree[i] = scan.nextInt(); 
          }
          
          
          for(int i = 0; i < arrTwo.length-1; i++) {
              System.out.print("[" + arrTwo[i] + "]\t");
          }
          System.out.println(" ");

          for(int i =0; i < arrThree.length; i++) {
              int x = arrThree[i];
              System.out.print("["+x+"]\t");
          }

          System.out.print("\n"); 
          
      }
    
}