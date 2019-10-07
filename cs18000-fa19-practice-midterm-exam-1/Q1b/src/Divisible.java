import java.util.Scanner;

/**
 * This question will prompt the user for a number and a divisor, then display whether or not the specified number is
 * divisible by the specified divisor. You may assume that both numbers are greater than one.
 *
 * Sample Usage:
 *   - 100, 10 //displays "divisible"
 *   - 7, 3    //displays "not divisible"
 *   - 20, 5   //displays "divisible"
 *   - 2, 10   //displays "not divisible"
 *
 * NOTE: When printing the result, be sure to print the result and nothing else using println().
 */
public class Divisible {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int divisor;

        System.out.print("Enter a number: ");

        number = scanner.nextInt();

        System.out.print("Enter a divisor: ");

        divisor = scanner.nextInt();

        scanner.close();

        //Do not modify above this line.

        //TODO: implement your logic here
        if(number%divisor == 0){
            System.out.println("divisible");
        }
        else{
            System.out.println("not divisible");
        }
    } //main
}