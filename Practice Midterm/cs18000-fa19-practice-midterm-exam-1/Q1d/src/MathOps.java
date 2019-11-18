import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This question will prompt the user for an operation and two operands, then display the result.
 *
 * The operations that can be performed with the two operands are:
 *
 *      - "add" -- adds the two specified operands together
 *      - "subtract" -- subtracts the two specified operands; specifically, op1 - op2
 *      - "multiply" -- multiplies the two specified operands
 *      - "divide" -- divides the two specified operations; specifically, op1 by op2; if op2 is 0.0, you should print
 *        "Invalid operand!"
 *
 * Sample Usage:
 *   - "add", 1.0, 2.0      // displays 3.0
 *   - "multiply", 5.0, 5.0 // displays 25.0
 *   - "divide", 1.0, 0.0   // displays "Invalid operand!"
 *   - "java", 4.0, 2.0     // displays "Invalid operation!"
 *
 * If the specified operation provided is not any of the above, you should print "Invalid operation!".
 *
 * NOTE: When printing the result, be sure to print the result and nothing else using println().
 */
public class MathOps{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation;
        double op1;
        double op2;

        System.out.print("Enter an operation: ");

        operation = scanner.nextLine();

        System.out.print("Enter the first operand: ");

        op1 = scanner.nextDouble();

        System.out.print("Enter the second operand: ");

        op2 = scanner.nextDouble();

        scanner.close();

        //Do not modify above this line.

        //TODO: implement your logic here
        operation = operation.toLowerCase();
        if (op2 == 0f && operation.equals("divide")){
            System.out.println("Invalid operand!");
            return;
        }
        double sum = 0;
        if(operation.equals("add")){
            sum = op1+op2;
        }
        else if(operation.equals("subtract")){
            sum = op1-op2;
        }
        else if(operation.equals("multiply")){
            sum = op1*op2;
        }
        else if(operation.equals("divide")){
            sum = op1/op2;
        }
        else{
            System.out.println("Invalid operation!");
            return;
        }
        DecimalFormat myFormatter = new DecimalFormat("#.0");
        sum = Double.valueOf(myFormatter.format(sum));
        System.out.println(sum);
    } //main
}