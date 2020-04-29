import java.util.Scanner;

public class Restaurant {

    //DO NOT EDIT BELOW
	private static final double SODA_PRICE = 2.99;
	private static final double WATER_PRICE = 0.00;
	private static final double COFFEE_PRICE = 3.99;
	private static final double TEA_PRICE = 2.59;

	private static final double NACHOS_PRICE = 8.99;
	private static final double BREADSTICKS_PRICE = 6.79;
	private static final double WINGS_PRICE = 7.29;
	private static final double CALAMARI_PRICE = 9.49;

	private static final double SPAGHETTI_PRICE = 15.43;
	private static final double BURGER_PRICE = 14.99;
	private static final double STIRFRY_PRICE = 16.99;
	private static final double FISHNCHIPS_PRICE = 18.99;

	private static final double BOILERTRACKS_PRICE = 5.96;
	private static final double BROWNIE_PRICE = 4.57;
	private static final double APPLEPIE_PRICE = 5.88;
	private static final double SUNDAE_PRICE = 4.77;

	private static final String NO_ITEM_PURCHASED = "You didn't choose any of the specified choices, so you were not given anything.";

	private static final String SODA = "SODA";
	private static final String WATER = "WATER";
	private static final String COFFEE = "COFFEE";
	private static final String TEA = "TEA";

	private static final String NACHOS = "NACHOS";
	private static final String BREADSTICKS = "BREADSTICKS";
	private static final String WINGS = "WINGS";
	private static final String CALAMARI = "CALAMARI";

	private static final String SPAGHETTI = "SPAGHETTI";
	private static final String BURGER = "BURGER";
	private static final String STIRFRY = "STIR FRY";
	private static final String FISHNCHIPS = "FISH N CHIPS";

	private static final String BOILERTRACKS = "BOILERTRACKS";
	private static final String BROWNIE = "BROWNIE";
	private static final String APPLEPIE = "APPLE PIE";
	private static final String SUNDAE = "SUNDAE";

	private static final String NONE = "NONE";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String drink;
		String appetizer;
		String mainDish;
		String dessert;
		double total = 0.0;
		double drinkPrice;
		double appPrice;
		double mainDishPrice;
		double dessertPrice;

		System.out.println("Welcome to Purdue Pete's Restaurant!");
		System.out.println("What would you like as your drink?");
		System.out.println("- - - - - - - - - -");
		System.out.println("(1) Soda");
		System.out.println("(2) Water");
		System.out.println("(3) Coffee");
		System.out.println("(4) Tea");
		System.out.println("- - - - - - - - - -");

		drink = scan.nextLine();


		System.out.println("What would you like as your appetizer?");
		System.out.println("- - - - - - - - - -");
		System.out.println("(1) Boiler Nachos");
		System.out.println("(2) Pete's 'HAMMER DOWN' Breadsticks");
		System.out.println("(3) Pete's 'BOILER UP' Chicken Wings");
		System.out.println("(4) The Boilermaker Special Calamari");
		System.out.println("- - - - - - - - - -");

		appetizer = scan.nextLine();

		System.out.println("What would you like as your main dish?");
		System.out.println("- - - - - - - - - -");
		System.out.println("(1) Pete's Spaghetti and Meatballs");
		System.out.println("(2) The Daniels Burger and Fries");
		System.out.println("(3) The Boilermaker Special Stir Fry");
		System.out.println("(4) The Boilermaker XTRA-Special Fish and Chips");
		System.out.println("- - - - - - - - - -");

		mainDish = scan.nextLine();

		System.out.println("What would you like as your dessert?");
		System.out.println("- - - - - - - - - -");
		System.out.println("(1) Boiler Tracks Ice Cream");
		System.out.println("(2) Brownie A La Mode");
		System.out.println("(3) The Acres Apple Pie");
		System.out.println("(4) Memorial Sundae");
		System.out.println("- - - - - - - - - -");

		dessert = scan.nextLine();

        //DO NOT EDIT ABOVE
        switch(drink) {
			case "1":
				drinkPrice = SODA_PRICE;
				drink = SODA;
				break;

			case "2":
				drinkPrice = WATER_PRICE;
				drink = WATER;
				break;

			case "3":
				drinkPrice = COFFEE_PRICE;
				drink = COFFEE;
				break;

			case "4":
				drinkPrice = TEA_PRICE;
				drink = TEA;
				break;

			default:
				drinkPrice = 0;
				drink = NONE;
				break;

		}

		switch (appetizer) {
			case "1":
				appPrice = NACHOS_PRICE;
				appetizer = NACHOS;
				break;

			case "2":
				appPrice = BREADSTICKS_PRICE;
				appetizer = BREADSTICKS;
				break;

			case "3":
				appPrice = WINGS_PRICE;
				appetizer = WINGS;
				break;

			case "4":
				appPrice = CALAMARI_PRICE;
				appetizer = CALAMARI;
				break;

			default:
				appPrice = 0;
				appetizer = NONE;
				break;
		}

		switch (mainDish){
			case "1":
				mainDishPrice = SPAGHETTI_PRICE;
				mainDish = SPAGHETTI;
				break;

			case "2":
				mainDishPrice = BURGER_PRICE;
				mainDish = BURGER;
				break;

			case "3":
				mainDishPrice = STIRFRY_PRICE;
				mainDish = STIRFRY;
				break;

			case "4":
				mainDishPrice = FISHNCHIPS_PRICE;
				mainDish = FISHNCHIPS;
				break;

			default:
				mainDishPrice = 0;
				mainDish = NONE;
				break;
		}

		switch (dessert){
			case "1":
				dessertPrice = BOILERTRACKS_PRICE;
				dessert = BOILERTRACKS;
				break;

			case "2":
				dessertPrice = BROWNIE_PRICE;
				dessert = BROWNIE;
				break;

			case "3":
				dessertPrice = APPLEPIE_PRICE;
				dessert = APPLEPIE;
				break;

			case "4":
				dessertPrice = SUNDAE_PRICE;
				dessert = SUNDAE;
				break;

			default:
				dessertPrice = 0;
				dessert = NONE;
		}

		total = drinkPrice + appPrice + mainDishPrice + dessertPrice;
        if (total == 0){
			System.out.println(NO_ITEM_PURCHASED);
		}

        
        //DO NOT EDIT BELOW
		System.out.println("Thank you for dining at Purdue Pete's Restaurant!");
		System.out.println("Here is your receipt: ");
		System.out.println("DRINK : " + drink + " - $" + String.format("%.2f", drinkPrice));
		System.out.println("APPETIZER : " + appetizer + " - $" + String.format("%.2f", appPrice));
		System.out.println("MAIN DISH : " + mainDish + " - $" + String.format("%.2f", mainDishPrice));
		System.out.println("DESSERT : " + dessert + " - $" + String.format("%.2f", dessertPrice));
		System.out.println("- - - - - - - - - -");
		System.out.println(String.format("TOTAL : $%.2f", total));
		System.out.println("- - - - - - - - - -");
	}
}


