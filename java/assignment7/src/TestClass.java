/**
 * The TestClass class demonstrates how to use the TimsOrder class to create and print a Tim Hortons order.
 *
 * @author Sukhmanjeet Singh, 000838215
 */
public class TestClass {

    /**
     * The main method creates a TimsOrder object, prints it to the console, and prints the total price of the order.
     */
    public static void main(String[] args) {
        // Create a new TimsOrder object using the static factory method create()
        TimsOrder t = TimsOrder.create();

        // Print the order to the console using the default toString() method
        System.out.println(t);

        // Print the total price of the order to the console with two decimal places
        System.out.printf("Total Price: $%.2f\n", t.getAmountDue());
    }
}
