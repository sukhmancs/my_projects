// Import the Scanner class from the java.util package
import java.util.Scanner;

/**
 * A Class to represent Tim's Order
 *
 * @author Sukhmanjeet Singh, 000838215
 */
public class TimsOrder {

    // Declare instance variables
    private String customerName; // String variable to store customer name
    private int size; // Integer variable to store number of items in the order
    private static TimsProduct[] items; // Array of TimsProduct objects to store items in the order

    /**
     * Define a constructor with two parameters to set the customer name and size of the order
     *
     * @param customerName name of the customer
     * @param size size of the order
     */
    private TimsOrder(String customerName, int size) {
        this.customerName = customerName;
        this.size = size;
    }

    /** Define a static method named create to create a new order
     *
     * @return TimsOrder
     */
    public static TimsOrder create() {

        // Use try-catch block to handle exceptions that may occur during input
        try {
            // Create a new Scanner object to read input from the console
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter the customer name and read the input
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            // Prompt the user to enter the number of items and read the input
            System.out.print("Enter number of items: ");
            int itemCount = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Create a new array of TimsProduct objects to store the items in the order
            items = new TimsProduct[itemCount];

            // Loop through the array and prompt the user to select the type of each item
            for (int i = 0; i < itemCount; i++) {
                System.out.println("Select item type:\n1. Mug\n2. Donut\n3. CoffeeCup\n4. Sandwich");
                int itemType = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Use a switch statement to create a new object of the selected type and add it to the array
                switch (itemType) {
                    case 1 -> items[i] = Mug.create();
                    case 2 -> items[i] = Donut.create();
                    case 3 -> items[i] = CoffeeCup.create();
                    case 4 -> items[i] = Sandwich.create();
                    default -> {
                        // If an invalid item type is selected, print an error message and try again for the same item
                        System.out.println("Invalid item type selected. Please try again.");
                        i--; // Decrement i to try again for the same item
                    }
                }
            }

            // Return a new TimsOrder object with the customer name and size
            return new TimsOrder(customerName, itemCount);

        } catch (Exception e) {
            // If an exception occurs during input, print an error message and return null
            System.out.println("Invalid input. ErrorCode: " + e + "\n");
            return null;
        }
    }

    /** Define a method named getAmountDue to calculate the total amount due for the order
     *
     * @return the amount due for the customer
     */
    public double getAmountDue() {
        double total = 0; // Initialize a double variable to store the total amount due

        // Loop through the array of items and add the retail price of each item to the total
        for (TimsProduct item : items) {
            total += item.getRetailPrice();
        }

        // Return the total amount due
        return total;
    }

    /** Override the toString method to return a string representation of the order
     *
     * @return String representation of all the instance variables of this class
     */
    @Override
    public String toString() {

        // new way to store a string
        StringBuilder sb = new StringBuilder();

        // append the string values to the object sb
        sb.append("\nOrder for: ").append(customerName).append("\n");

        // go through all the items and add them to the stringbuilder
        for (TimsProduct item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString(); // finally return
    }
}
