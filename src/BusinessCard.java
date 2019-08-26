import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * Homework 1 - Business Card
 *
 * Takes input from the user using the scanner to create a business card like output.
 *
 * @author Varun Shah, CS180 BLK, B13
 * @version 8/26/2019
 *
 */
public class BusinessCard {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in); //s is the scanner that will take the input from the user.'

        System.out.print("Enter your name: "); //Prompting the user for their name.
        String name = s.nextLine(); //Taking in the user's input for their name and storing it in the variable name.

        System.out.print("Enter your birth year: "); //Prompting the user for their birth year.
        int byear = s.nextInt(); //Taking in the user's input for their birth year and storing it in the variable byear.
        int age = 2019 - byear; //Calculating age using 2019

        System.out.print("Enter your GPA: "); //Prompting the user for their GPA
        DecimalFormat df = new DecimalFormat("#.00");
        String GPA = df.format(s.nextDouble()); //Taking GPA input and formatting to 2 decimal places


        System.out.print("Enter your major: "); //Prompting the user for their major
        s.nextLine();
        String major = s.nextLine(); //Taking major input.
        System.out.print("Enter your email: "); //Prompting the user for their email address
        String email = s.nextLine(); //Taking email input

        //delineate between input print statements and output print statements. Helps clear the console. 
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        //output as requested
        System.out.println("Name:  " + name);
        System.out.println("Age:   " + age);
        System.out.println("GPA:   " + GPA);
        System.out.println("Major: " + major);
        System.out.println("Email: " + email);

    }
}