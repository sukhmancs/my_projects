import java.util.Scanner; // import statement for the Scanner class from java.util package

/**
 * A subclass of TimsProduct representing a Sandwich
 *
 * Inheritance:
 *   TimsProduct
 *
 * @author Sukhmanjeet Singh, 000838215
 */
public class Sandwich extends TimsProduct {
    private String description; // declare an instance variable of type String called description
    private int calorieCount; // declare an instance variable of type int called calorieCount

    /**
     * Define a constructor which initializes the instance variables and calls the constructor of TimsProduct class
     * @param name the name of this mug
     * @param cost the cost of this mug
     * @param price the price of this mug
     * @param description the description of this product
     * @param calorieCount the number of calories inside this product
     */
    public Sandwich(String name, double cost, double price, String description, int calorieCount) {
        super(name, cost, price); // calling constructor of TimsProduct class
        this.description = description; // initializing description variable
        this.calorieCount = calorieCount; // initializing calorieCount variable
    }

    /**
     * Define a static method called create which returns an instance of Sandwich class
     *
     * @return this class constructor
     */
    public static Sandwich create() {
        Scanner sc = new Scanner(System.in); // create a Scanner object to read user input from standard input

        try { // try-catch block to handle any exception thrown while taking input from user
            System.out.println("What name do you want for the Sandwich (ex. mysandwich): ");
            String name = sc.nextLine(); // read a line of text from standard input and store it in name variable

            System.out.println("What kind of sandwich (ex. egg and cheese): ");
            String description = sc.nextLine(); // read a line of text from standard input and store it in description variable

            System.out.println("What is the Cost of the Sandwich (ex. 2.0): ");
            double cost = sc.nextDouble(); // read a double value from standard input and store it in cost variable
            sc.nextLine(); // consume leftover newline character from input buffer

            System.out.println("What is the Price of the Sandwich (ex. 10.0): ");
            double price = sc.nextDouble(); // read a double value from standard input and store it in price variable
            sc.nextLine(); // consume leftover newline character from input buffer

            System.out.println("How much Calories you want (ex. 200): ");
            int calorieCount = sc.nextInt(); // read an integer value from standard input and store it in calorieCount variable
            sc.nextLine(); // consume leftover newline character from input buffer

            return new Sandwich(name, cost, price, description, calorieCount); // return an instance of Sandwich class with the user provided inputs
        } catch (Exception e) { // if an exception occurs during the input process, catch it and return null
            System.out.println("Invalid input. ErrorCode: " + e + "\n");
            return null;
        }
    }

    /**
     * Define a method called getDescription which returns the description of the sandwich
     *
     * @return String description of this product
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Define a method called getCalorieCount which returns the calorie count of the sandwich
     *
     * @return value representing the number of calories
     */
    public int getCalorieCount() {
        return this.calorieCount;
    }

    /**
     * Override the toString() method of TimsProduct class
     *
     * @return String representation of all the instance variables of this class
     */
    @Override
    public String toString() {
        return  super.toString() + "\nType: Sandwich{" + // call the toString() method of the TimsProduct class and concatenate additional information about the Sandwich object
                "description='" + this.getDescription() + '\'' +
                ", calorieCount=" + this.getCalorieCount() +
                "}";
    }
}
