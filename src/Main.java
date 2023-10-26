import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Array with different pizzas
        String[] pizzas = {"Margherita", "Pepperoni", "Meat Lover", "Kebab", "Hawaiian", "Ham", "Vegetarian", "Beef", "Napoli", "Calzone"};
        //Array with pizza prices
        int[] pizzaPrices = {60, 75, 85, 80, 90, 70, 90, 80, 70, 75};
        //Array with toppings
        String[] toppings = {"Mushrooms", "Cheese", "Onions"};
        //Array with pizza size prices
        double[] pizzaSize = {0.75, 1, 1.5};
        //Array with topping prices
        int[] toppingPrices = {15, 10, 5};

        double totalPrice = 0;
        double currentPizzaPrice = 0;

        boolean sizeDone = true;
        boolean toppingsDone = true;

        int amountOfPizzasChosen = 0;

        //While loop that runs while true
        do {
            //Sets the variable to 0 every time it loops
            currentPizzaPrice = 0;
            sizeDone = true;
            toppingsDone = true;
            System.out.println("What pizza would you like to order?");
            System.out.println("0. Exit");
            //Displays a list of the pizzas including price
            for (int i = 0; i < pizzas.length; i++) {
                System.out.println((i + 1) + ". " + pizzas[i] + " - DKK " + pizzaPrices[i]);
            }

            System.out.println("Please select a pizza (0-10): ");

            //Assigns the method userInput to an int
            int pizzaChoice = userInput();

            //If the users choice is 0 then it stops, else if its under 1 or above 10 then prints invalid choice
            if (pizzaChoice == 0) {
                break;
            } else if (pizzaChoice < 1 || pizzaChoice > 10) {
                System.out.println("Invalid choice. Please select a valid option");
                //Continue skips the current iteration and goes back
                continue;

            } else {
                System.out.println("You selected " + pizzas[pizzaChoice - 1] + " - DKK " + pizzaPrices[pizzaChoice - 1]);
                currentPizzaPrice += pizzaPrices[pizzaChoice - 1];
                amountOfPizzasChosen++;
            }



            while (toppingsDone){
                System.out.println("What toppings do you want?");
                System.out.println("0. No toppings");

                //Prints out list of toppings with their corresponding price
                for (int i = 0; i < toppings.length; i++) {
                    System.out.println((i + 1) + ". " + toppings[i] + " - DKK" + toppingPrices[i]);
                }

                System.out.println("Please select a topping (1-3, 0 for no toppings): ");

                //Reads the users input as a string and then parses it to an int
                int toppingChoice = userInput();

                //If the user inputs 0 then it stops, and if the user inputs either less than 1 or more than 3
                //then its invalid. If the user input 1 - 3 then it prints out the chosen topping with price
                if (toppingChoice == 0) {
                    System.out.println("You selected no extra toppings");
                    toppingsDone = false;
                } else if (toppingChoice < 1 || toppingChoice > 3) {
                    System.out.println("Invalid option. Please selected a valid option");

                } else {
                    System.out.println("You selected " + toppings[toppingChoice - 1] + toppingPrices[toppingChoice - 1]);
                    currentPizzaPrice += toppingPrices[toppingChoice - 1];
                    toppingsDone = false;
                }

            }

            while(sizeDone){
                //Prints out the different sizes of pizzas
                System.out.println("What size pizza do you want?");
                for (int i = 0; i < pizzaSize.length; i++) {
                    System.out.println((i + 1) + ". " + pizzaSize[i]);
                }

                int sizeChoice = userInput();

                if (sizeChoice == 0) {
                    System.out.println("Please input a valid option");
                    //Continue skips the current iteration, and goes back
                    continue;
                } else if (sizeChoice < 1 || sizeChoice > 3) {
                    System.out.println("Invalid option. Please selected a valid option");
                    continue;
                } else {
                    //Calculates the correct price of the pizza, when the size is chosen
                    currentPizzaPrice *= pizzaSize[sizeChoice - 1];
                    sizeDone = false;
                }


                //Assigning the total price for the pizza with the topping price included


                System.out.println("The price of the pizza is: " + currentPizzaPrice);
            }
            //Adds the current pizza price to the variable totalPrice
            totalPrice += currentPizzaPrice;

        } while (true);

        System.out.println("Total price is: " + totalPrice + " DKK " + "\nYou've ordered: " + amountOfPizzasChosen + " pizzas");
        System.out.println("Thank you for ordering!");
    }

    //Method with a scanner, that validates a users input
    public static int userInput() {
        Scanner input = new Scanner(System.in);
        int returnValue;

        do {
            if (input.hasNextInt()) {
                returnValue = input.nextInt();

                if (returnValue > -1) {
                    return returnValue;

                } else {
                    System.out.println("Please enter a valid number.");
                }

            } else {
                System.out.println("Please enter a valid number. " + input.nextLine());
            }

        } while (true);
    }

}