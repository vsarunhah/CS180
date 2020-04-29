import java.util.Scanner;

/**
 * LAB07 - Array Calculator
 * Performs a user specified operation on the elements of an array that they enter. Elements can be doubles.
 *
 */
public class ArrayCalculator {

    public static void main(String[] args) {
        int numElements;
        double[] toOperate;
        int inputForChoice;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter the number of elements you would like to perform an operation on.");
            numElements = scan.nextInt();
            scan.nextLine();
        } while (numElements < 0);

        toOperate = new double[numElements];

        for (int i = 0; i < toOperate.length; i++) {
            System.out.println("Enter element number " + i + " to perform an operation upon.");
            toOperate[i] = scan.nextDouble();
        }

        do {
            System.out.println("What operation would you like to perform on your elements?");
            System.out.println("(1) Addition");
            System.out.println("(2) Subtraction");
            System.out.println("(3) Multiplication");
            System.out.println("(4) Division");
            System.out.println("(5) Exponential");
            inputForChoice = scan.nextInt();
            scan.nextLine();
        } while (inputForChoice > 6 | inputForChoice < 1);

        switch (inputForChoice) {
            case 1:
                System.out.println("The sum of your entered elements is " + operateArray(toOperate,
                        "ADD"));
                break;
            case 2:
                System.out.println("The difference of your entered elements is " + operateArray(toOperate,
                        "SUB"));
                break;
            case 3:
                System.out.println("The product of your entered elements is " + operateArray(toOperate,
                        "MUL"));
                break;
            case 4:
                System.out.println("The quotient of your entered elements is " + operateArray(toOperate,
                        "DIV"));
                break;
            default:
                System.out.println("The exponential result of your entered elements is " + operateArray(toOperate,
                        "EXP"));
                break;
        }
    }

    private static double operateArray(double[] arr, String operation) {
       /* Do not modify anything above this line.
       * Implement your solution here. 
       */

       operation = operation.toUpperCase();
       double result = 0;
       if(operation.equals("EXP")){
           result = arr[0];
           for (int i = 1; i < arr.length; i++){
               result = Math.pow(result, arr[i]);
           }
       } else if(operation.equals("ADD")){
           result = 0;
           for (double num: arr){
               result += num;
           }
       } else if(operation.equals("SUB")){
           result = 0;
           for (double num: arr){
               result -= num;
           }
       } else if (operation.equals("MUL")){
           result = 1;
           for (double num: arr){
               result *= num;
           }
       } else if (operation.equals("DIV")){
           result = arr[0];
           for (int i = 1; i < arr.length; i++){
               result /= arr[i];
           }
       }
       return result;
    }
}
