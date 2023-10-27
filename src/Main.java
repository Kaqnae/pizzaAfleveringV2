//Noah B. Hvidt-Pedersen

//Tested by Alexander Jacob Gerckens

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

        //Variable for the total price of all pizzas ordered
        double totalPrice = 0;
        //Variable for the pizza that is currently being ordered
        double currentPizzaPrice = 0;
        //Booleans for the size and toppings loop, in order to make them finish
        boolean sizeDone = true;
        boolean toppingsDone = true;
        //Variable for the amount of pizzas that have been ordered
        int amountOfPizzasOrdered = 0;

        //While loop that runs while true
        do {
            //Sets the variable to 0 every time it loops
            currentPizzaPrice = 0;
            //Sets the booleans to be true, in order for the loops to be able to run again
            sizeDone = true;
            toppingsDone = true;

            System.out.println("\nWhat pizza would you like to order?");
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
                //Prints out the selected pizza including the price
                System.out.println("\nYou selected " + pizzas[pizzaChoice - 1] + " - DKK " + pizzaPrices[pizzaChoice - 1]);
                currentPizzaPrice += pizzaPrices[pizzaChoice - 1];
                //Adds one pizza to the total amount of pizzas being ordered
                amountOfPizzasOrdered++;
            }
            //While loops that makes sure that it stays on toppings until a valid option is given
            while (toppingsDone){
                System.out.println("\nWhat toppings do you want?");
                System.out.println("0. No toppings");

                //Prints out list of toppings with their corresponding price
                for (int i = 0; i < toppings.length; i++) {
                    System.out.println((i + 1) + ". " + toppings[i] + " - DKK " + toppingPrices[i]);
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
                    System.out.println("\nYou selected " + toppings[toppingChoice - 1] + " - " + toppingPrices[toppingChoice - 1] + " DKK");
                    currentPizzaPrice += toppingPrices[toppingChoice - 1];
                    toppingsDone = false;
                }

            }
            //While loop that makes sure that it stays on sizes until a valid option is given
            while(sizeDone){
                //Prints out the different sizes of pizzas
                System.out.println("\nWhat size pizza do you want?");
                for (int i = 0; i < pizzaSize.length; i++) {
                    System.out.println((i + 1) + ". " + pizzaSize[i]);
                }

                int sizeChoice = userInput();

                //If statements that makes sure that valid options is being given
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
                    //Sets the boolean sizeDone to false, in order to get out of the while loop
                    sizeDone = false;
                }
                //Displays the current price for the pizza that has been chosen
                System.out.println("\nThe price of the pizza is: " + currentPizzaPrice);
            }
            //Adds the current pizza price to the variable totalPrice, inorder to be able to calculate a total
            totalPrice += currentPizzaPrice;

        } while (true);
        //Displays the total price for the order and the amount of pizzas that have been ordered
        System.out.println("\nTotal price is: " + totalPrice + " DKK " + "\nYou've ordered: " + amountOfPizzasOrdered + " pizza(s)");
        System.out.println("\nThank you for ordering!");
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