import java.util.Scanner;
import java.util.regex.Pattern;

public class AutomatedTellerMachine {
	private static double maxMoney = 1000.00;
	private static final String ONE_DOLLAR =
			"|#######====================########|\n" +
					"|#(1)*UNITED STATES OF AMERICA*(1)##|\n" +
					"|#**          /===\\   ********  ***#|\n" +
					"|*# {G}      | (\") |             ##*|\n" +
					"|#*  ******  | /v\\ |    O N E    *##|\n" +
					"|#(1)         \\===/            (1)##|\n" +
					"|##=========ONE DOLLAR===========###|\n" +
					"------------------------------------";
	private static final String FIVE_DOLLARS =
			"|#######====================##########|\n" +
					"|#(5)*UNITED STATES OF AMERICA*(5)####|\n" +
					"|#**          /===\\   ********   ****#|\n" +
					"|*# {G}      | (\") |              ###*|\n" +
					"|#*  ******  | /v\\ |    F I V E   **##|\n" +
					"|#(5)         \\===/            (5) ###|\n" +
					"|##=========FIVE DOLLARS===========###|\n" +
					"--------------------------------------";
	private static final String TEN_DOLLARS =
			"|#######====================###########|\n" +
					"|#(10)*UNITED STATES OF AMERICA*(10)###|\n" +
					"|#**          /===\\   ********    ****#|\n" +
					"|*# {G}      | (\") |               ###*|\n" +
					"|#*  ******  | /v\\ |    T E N      ***#|\n" +
					"|#(10)         \\===/            (10) ##|\n" +
					"|##==========TEN DOLLARS=============##|\n" +
					"----------------------------------------";
	private static final String TWENTY_DOLLARS =
			"|#######====================################|\n" +
					"|#(20)*UNITED STATES OF AMERICA*(20)########|\n" +
					"|#**          /===\\   ********    #######**#|\n" +
					"|*# {G}      | (\") |               ########*|\n" +
					"|#*  ******  | /v\\ |    T W E N T Y      **#|\n" +
					"|#(20)         \\===/            (20) #######|\n" +
					"|##=========TWENTY DOLLARS===========#######|\n" +
					"---------------------------------------------";

	private static final String FIFTY_DOLLARS =
			"|#######====================############|\n" +
					"|#(50)*UNITED STATES OF AMERICA*(50)####|\n" +
					"|#**          /===\\   ********    *****#|\n" +
					"|*# {G}      | (\") |               ####*|\n" +
					"|#*  ******  | /v\\ |    F I F T Y    **#|\n" +
					"|#(50)         \\===/            (50) ###|\n" +
					"|##=========FIFTY DOLLARS===========####|\n" +
					"-----------------------------------------";

	private static final String HUNDRED_DOLLARS =
			"|#######=========================############|\n" +
					"|#(100)*UNITED STATES OF AMERICA*(100)#######|\n" +
					"|#**          /===\\   ********          ****#|\n" +
					"|*# {G}      | (\") |                     ###*|\n" +
					"|#*  ******  | /v\\ |    H U N D R E D    ***#|\n" +
					"|#(100)         \\===/            (100)   **##|\n" +
					"|##=========HUNDRED DOLLARS================##|\n" +
					"----------------------------------------------";


	public static void main(String[] args) {
		boolean transaction = true;
		double currentBalance = maxMoney;
	 //Do not modify anything above this line.
		System.out.println("Welcome to the CS180 ATM Machine!");
		System.out.println("Please enter a 16 digit card number, with no spaces.");
		Scanner s = new Scanner(System.in);
		String cardNumber = s.nextLine();
		while(cardNumber.matches("[a-zA-Z]+") || cardNumber.length() != 16 || cardNumber.contains(" ") || Pattern.matches("\\p{Punct}", cardNumber)){
			System.out.println("Please enter a 16 digit card number, with no spaces.");
			cardNumber = s.nextLine();
		}

		while(true) {
			transaction = true;
			System.out.printf("Current Balance : $%.2f", currentBalance);
			System.out.println("");
			System.out.println("How much money would you like to withdraw?");
			double amountWanted = s.nextDouble();
			boolean valid = true;
			if (amountWanted > currentBalance) {
				System.out.println("You don't have that much money!");
				System.out.printf("Current Balance : $%.2f", currentBalance);
//				System.out.println("");
//				System.out.printf("Current Balance : $%.2f", currentBalance);
				System.out.println("");
				valid = false;
			}
			if (amountWanted <= 0) {
				System.out.println("You cannot enter a negative number.");
				transaction = false;
				valid = false;
			}
			while (valid) {
				currentBalance -= amountWanted;
				//hundreds
				int numberHundreds = (int) amountWanted / 100;
				for (int i = 0; i < numberHundreds; i++) {
					System.out.println(HUNDRED_DOLLARS);
				}
				amountWanted -= numberHundreds * 100;
				if (amountWanted == 0) {
					break;
				}
				//fifties
				int numberFifty = (int) amountWanted / 50;
				for (int i = 0; i < numberFifty; i++) {
					System.out.println(FIFTY_DOLLARS);
				}
				amountWanted -= numberFifty * 50;
				if (amountWanted == 0) {
					break;
				}
				//twenties
				int numberTwenty = (int) amountWanted / 20;
				for (int i = 0; i < numberTwenty; i++) {
					System.out.println(TWENTY_DOLLARS);
				}
				amountWanted -= numberTwenty * 20;
				if (amountWanted == 0) {
					break;
				}
				//tens
				int numberTens = (int) amountWanted / 10;
				for (int i = 0; i < numberTens; i++) {
					System.out.println(TEN_DOLLARS);
				}
				amountWanted -= 10 * numberTens;
				if (amountWanted == 0) {
					break;
				}
				//fives
				int numberFives = (int) amountWanted / 5;
				for (int i = 0; i < numberFives; i++) {
					System.out.println(FIVE_DOLLARS);
				}
				amountWanted -= 5 * numberFives;
				if (amountWanted == 0) {
					break;
				}
				//ones
				for (int i = 0; i < amountWanted; i++) {
					System.out.println(ONE_DOLLAR);
					amountWanted -= 1;
				}
			}
			if(valid){
			if (transaction) {
				System.out.println("Would you like to perform an additional transaction? Please enter '1' for yes, and '2' for no.");
				s.nextLine();
				String choice = s.nextLine();
				while (choice.matches("[a-zA-Z]+") || choice.contains(" ") || Pattern.matches("\\p{Punct}", choice)) {
					System.out.println("Would you like to perform an additional transaction? Please enter '1' for yes, and '2' for no.");
					choice = s.nextLine();
				}
				while (!choice.equals("2") && !choice.equals("1")) {
					System.out.println("Would you like to perform an additional transaction? Please enter '1' for yes, and '2' for no.");
					choice = s.nextLine();
				}
				if (choice.equals("2")) {
					System.out.println("Thanks for using the Purdue ATM!");
					return;
				}
			}
			}
		}
	}
}
