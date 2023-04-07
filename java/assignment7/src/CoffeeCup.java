import javafx.scene.paint.Color;
import java.util.Scanner;

/**
 * A subclass of TimsProduct representing a CoffeeCup
 *
 * Inheritance:
 *   TimsProduct
 *
 * @author Sukhmanjeet Singh, 000838215
 */
public class CoffeeCup extends TimsProduct {

    private Color color; // declaring a private instance variable of type Color

    /**
     * Defining a constructor for the CoffeeCup class
     * @param name name for this coffeecup
     * @param cost cost of this cup
     * @param price price of this cup
     * @param color color of this cup
     */
    public CoffeeCup(String name, double cost, double price, Color color) {
        super(name, cost, price); // calling the superclass constructor with the name, cost, and price parameters
        this.color = color; // setting the value of the private instance variable color
    }

    /**
     * Defining a static method named create that returns a CoffeeCup object
     * @return CoffeeCup constructor
     */
    public static CoffeeCup create() {

        // Validate the inputs
        try {
            Scanner sc = new Scanner(System.in); // creating a new Scanner object to read input from the console

            // TODO: Fill in this stub to have a dialog with the user
            System.out.println("What name do you want for the CoffeCup (ex. my cup): ");
            String name = sc.nextLine(); // prompting the user to enter a name for the coffee cup and storing it in the name variable

            System.out.println("What Color do you want for the CoffeCup (ex. white): ");
            Color color = Color.valueOf(sc.next()); // prompting the user to enter a color for the coffee cup and storing it in the color variable

            System.out.println("What is the Cost of the CoffeeCup (ex. 30): ");
            double cost = sc.nextDouble(); // prompting the user to enter a cost for the coffee cup and storing it in the cost variable
            sc.nextLine(); // consuming the leftover newline character

            System.out.println("What is the Price of the CoffeeCup (ex. 5): ");
            double price = sc.nextDouble(); // prompting the user to enter a price for the coffee cup and storing it in the price variable
            sc.nextLine(); // consuming the leftover newline character

            //and create a TimsOrder.
            return new CoffeeCup(name, cost, price, color); // creating a new CoffeeCup object with the name, cost, price, and color variables, and returning it
        } catch (Exception e) { // catching any exception that might occur
            System.out.println("Invalid input. ErrorCode: " + e + "\n"); // printing out an error message
            return null; // returning null if an exception occurs
        }
    }

    /**
     * Defining a method that returns the color of the coffee cup
     * @return Color value of this product
     */
    public Color getColor() {
        return color; // returning the value of the color instance variable
    }

    /**
     * Overriding the toString method to print out information about the coffee cup
     * @return String representation of all the instance variables of this class
     */
    @Override
    public String toString() {
        return  super.toString() + "\nType: CoffeeCup{" +
                "color=" + color +
                "}"; // returning a string that contains information about the coffee cup, including its color
    }
}
