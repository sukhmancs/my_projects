import javafx.scene.paint.Color; // import statement for the Color class from the JavaFX library
import java.util.Scanner; // import statement for the Scanner class from the Java standard library

/**
 * A subclass of TimsProduct representing a Mug
 * <p>
 * Inheritance:
 *   TimsProduct
 *
 * @author Sukhmanjeet Singh, 000838215
 */
public class Mug extends TimsProduct {

    private Color color; // private instance variable for the color of the mug

    /**
     * Constructor for creating a new Mug object with a name, cost, price, and color
     * @param name the name of this mug
     * @param cost the cost of this mug
     * @param price the price of this mug
     * @param color the color of this mug
     */
    public Mug(String name, double cost, double price, Color color) {
        super(name, cost, price); // call to the constructor of the superclass TimsProduct
        this.color = color; // initialize the color instance variable
    }

    /**
     * Static method for creating a new Mug object from user input
     * @return this class constructor
     */
    public static Mug create() {

        try { // try-catch block for handling any exceptions that may occur
            Scanner sc = new Scanner(System.in); // create a new Scanner object to read user input

            // TODO: Fill in this stub to have a dialog with the user

            System.out.println("What name do you want for the Mug (ex. my mug): ");
            String name = sc.nextLine(); // prompt the user to enter the name of the mug and read in their input

            System.out.println("What Color do you want for the Mug (ex. white): ");
            Color color = Color.valueOf(sc.next()); // prompt the user to enter the color of the mug and read in their input
            sc.nextLine(); // consume the leftover newline character after reading in the color

            System.out.println("What is the Cost of the Mug (ex. 20): ");
            double cost = sc.nextDouble(); // prompt the user to enter the cost of the mug and read in their input
            sc.nextLine(); // consume the leftover newline character after reading in the cost

            System.out.println("What is the Price of the Mug (ex. 3): ");
            double price = sc.nextDouble(); // prompt the user to enter the price of the mug and read in their input
            sc.nextLine(); // consume the leftover newline character after reading in the price

            // create a new Mug object with the user input and return it
            return new Mug(name, cost, price, color);
        } catch (Exception e) { // catch block for handling any exceptions that may occur
            System.out.println("Invalid input. ErrorCode: " + e + "\n"); // print an error message with the exception code
            return null; // return null to indicate that the Mug object could not be created
        }
    }

    /**
     * Public method for getting the color of the mug
     * @return Color value for this product
     */
    public Color getColor() {
        return color;
    }

    /**
     * Overrides the toString method of the TimsProduct superclass
     * @return String representation of all the instance variables of this class
     */
    @Override
    public String toString() {
        return  super.toString() + "\nType: Mug{" +
                "color=" + color +
                "}"; // returns a string representation of the Mug object, including its name, cost, price, and color
    }
}
