import java.util.Scanner; // Import statement for the Scanner class from the java.util package.

/**
 * A subclass of TimsProduct representing a Donut
 *
 * Inheritance:
 *   TimsProduct
 *
 * @author Sukhmanjeet Singh, 000838215
 */
public class Donut extends TimsProduct implements Consumable {
    private String description; // Private instance variable to store the description of the donut.
    private int calorieCount; // Private instance variable to store the calorie count of the donut.

    /**
     * Constructor for the Donut class, which takes in the name, cost, price, description, and calorie count of the donut.
     * @param name name of the donut
     * @param cost cost of this donut
     * @param price price of this donut
     * @param description description of this donut
     * @param calorieCount calorieCount for this donut
     */
    private Donut(String name, double cost, double price, String description, int calorieCount) {
        super(name, cost, price); // Call to the constructor of the superclass, TimsProduct, passing in the name, cost, and price parameters.
        this.description = description; // Set the description instance variable to the value passed in as the description parameter.
        this.calorieCount = calorieCount; // Set the calorieCount instance variable to the value passed in as the calorieCount parameter.
    }

    /**
     * Static factory method for creating instances of the Donut class.
     *
     * @return Donut object
     */
    public static Donut create() {

        try { // Begin try block.
            Scanner sc = new Scanner(System.in); // Create a new Scanner object to read user input from the console.

            System.out.println("What name do you want for the Donut: (ex. choco)"); // Print a prompt for the user to enter the name of the donut.
            String name = sc.nextLine(); // Read in the user's input for the name of the donut.

            System.out.println("What kind of donut (ex. double chocolate): "); // Print a prompt for the user to enter the kind of donut.
            String description = sc.nextLine(); // Read in the user's input for the description of the donut.

            System.out.println("What is the Cost of the Donut (ex. 3.0): "); // Print a prompt for the user to enter the cost of the donut.
            double cost = sc.nextDouble(); // Read in the user's input for the cost of the donut.
            sc.nextLine(); // Consume the leftover newline character from the previous input.

            System.out.println("What is the Price of the Donut (ex. 1.60): "); // Print a prompt for the user to enter the price of the donut.
            double price = sc.nextDouble(); // Read in the user's input for the price of the donut.
            sc.nextLine(); // Consume the leftover newline character from the previous input.

            System.out.println("How much Calories you want (ex. 200): "); // Print a prompt for the user to enter the calorie count of the donut.
            int calorieCount = sc.nextInt(); // Read in the user's input for the calorie count of the donut.
            sc.nextLine(); // Consume the leftover newline character from the previous input.

            //and create a TimsOrder.
            return new Donut(name, cost, price, description, calorieCount); // Return a new instance of the Donut class with the values read in from the user input.
        } catch (Exception e) { // Catch block to handle any exceptions thrown during the input process.
            System.out.println("Invalid input. ErrorCode: " + e + "\n"); // Print an error message indicating that the user input
            return null; // return null otherwise
        }
    }

    /**
     * Getter method to get the description of this donut
     * @return description of this donut
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Implement getCalorieCount function for Consumable
     * @return calorieCount of this donut
     */
    @Override
    public int getCalorieCount() {
        return this.calorieCount;
    }

    /**
     * Implement getConsumptionMethod function for Consumable
     * @return String representing consumption status of this donut
     */
    @Override
    public String getConsumptionMethod() {
        return "Eat it.";
    }

    /**
     * Override the toString method of TimsProduct
     * @return String representation of all the instance variables of this donut
     */
    @Override
    public String toString() {
        return  super.toString() + "\nType: Donut{" +
                "description='" + this.getDescription() + '\'' +
                ", calorieCount=" + this.getCalorieCount() +
                "}";
    }
}
