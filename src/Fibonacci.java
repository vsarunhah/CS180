import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Fibonacci Sequencer");
        System.out.println();
        System.out.println("Enter an Option:\nA for Sequence\nB for Matrix\nC for Fibonacci String");
        String mode = s.nextLine().toUpperCase();
        while (true) {
            while (!mode.equals("A") && !mode.equals("B") && !mode.equals("C")) {
                System.out.println("Input not valid \nPress Y to run again");
                if (s.nextLine().toUpperCase().equals("Y")) {
                    System.out.println("Enter an Option:\nA for Sequence\nB for Matrix\nC for Fibonacci String");
                    mode = s.nextLine();
                } else {
                    System.out.println("Thank you using Fibonacci Sequencer");
                    System.exit(0);
                }

            }
            int counter = 0;
            while (mode.equals("A")) {
                if (counter < 1) {
                    System.out.println("Enter 0 to exit\nEnter Sequence:");
                    counter++;
                }
                String termNumber = s.nextLine();
                if (termNumber.matches("^[a-zA-z]*$")) {
                    System.out.println("Input not valid \nPress Y to run again");
                    if (s.nextLine().toUpperCase().equals("Y")) {
                        System.out.println("Enter an Option:\nA for Sequence\nB for Matrix\nC for Fibonacci String");
                        mode = s.nextLine().toUpperCase();
                    }
                    else{
                        System.exit(0);
                    }
                } else if (Integer.valueOf(termNumber) == 0) {
                    System.out.println("Press Y to run again");
                    if (s.nextLine().toUpperCase().equals("Y")) {
                        System.out.println("Enter an Option:\nA for Sequence\nB for Matrix\nC for Fibonacci String");
                        mode = s.nextLine().toUpperCase();
                        if (mode.toUpperCase().equals("A")) {
                            counter = 0;
                        }
                    } else {
                        System.out.println("Thank you using Fibonacci Sequencer");
                        System.exit(0);
                    }
                } else {
                    System.out.println(sequence(Integer.valueOf(termNumber)));
                }

            }

            while (mode.equals("B")) {
                System.out.println("Enter Dimensions:");
                String[] dim = s.nextLine().split(" ");
                if (dim[0].matches("^[a-zA-z]*$") || dim[1].matches("^[a-zA-z]*$")) {
                    System.out.println("Input not valid");
                } else {
                    matrix(Integer.valueOf(dim[0]), Integer.valueOf(dim[1]));
                }
                System.out.println("Press Y to run again");
                if (s.nextLine().toUpperCase().equals("Y")) {
                    System.out.println("Enter an Option:\nA for Sequence\nB for Matrix\nC for Fibonacci String");
                    mode = s.nextLine().toUpperCase();
                }
                else{
                    System.out.println("Thank you using Fibonacci Sequencer");
                    System.exit(0);
                }
            }
            while(mode.equals("C")){
                System.out.println("Enter Fibonacci String:");
                String fib = s.nextLine();
                System.out.println(fibString(fib));
                System.out.println("Press Y to run again");
                if (s.nextLine().toUpperCase().equals("Y")) {
                    System.out.println("Enter an Option:\nA for Sequence\nB for Matrix\nC for Fibonacci String");
                    mode = s.nextLine().toUpperCase();
                }
                else{
                    System.out.println("Thank you using Fibonacci Sequencer");
                    System.exit(0);
                }
            }
        }
    }

    public static int sequence ( int termNumber){
            if (termNumber < 2) {
                return termNumber;
            }
            int n1 = 0;
            int n2 = 1;
            int n3 = 0;
            for (int i = 0; i < termNumber - 1; ++i) {
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;
            }
            return n3;
        }
        public static void matrix ( int rows, int columns){
            int counter = 1;
            for (int i = 0; i < columns; i++) {
                String row = "";
                for (int y = 0; y < rows; y++) {
                    row += " " + sequence(counter);
                    counter++;
                }
                row = row.trim();
                System.out.println(row);
            }
        }

        public static String fibString(String fib){
            String finalized = "";
            String[] digits = fib.split("");
            Collections.reverse(Arrays.asList(digits));
            for(int i = 0; i < digits.length; i++){
                if (digits[i].equals("0")){
                    digits[i] = "1";
                }
                else{
                    digits[i] = "0";
                }
                finalized += digits[i];
            }

            return finalized;
        }
    }
