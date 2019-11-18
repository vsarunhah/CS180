import java.util.Scanner;

/**
 * This question will prompt the user for a number. It will then print every prime number out in descending
 * order from the number that the user entered. You can assume that the numbers will always be integers.
 *
 * You may recall that the definition of a prime number is as follows:
 * 		A number is prime if its only factors are one and itself. That is, the only whole numbers that can evenly
 * 		divide a prime number are itself and one. Be aware that one is not a prime number.
 *
 * Sample Usage:
 *   - 11 //displays 11
 *                   7
 *                   5
 *                   3
 *                   2
 *
 * NOTE: When printing the numbers, be sure to print the number and nothing else using println().
 */
public class PrimeCountdown {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int startingNum;

		System.out.print("Enter a starting number: ");

		startingNum = scanner.nextInt();

		scanner.close();

		//Do not modify above this line.

		//TODO: implement your logic here
		int number = startingNum;
		for (int i = number; i > 1; i--){
			if(primeChecker(i)){
				System.out.println(i);
			}
		}
	} //main
	public static boolean primeChecker(int num){
		if (num == 2 || num == 3 || num == 5 || num == 7){
			return true;
		}
		boolean prime = true;
		int max = num/2;
		for(int i = 2; i < max; i++){
			if (num%i == 0){
				prime = false;
				break;
			}
		}
		return prime;
	}
}
