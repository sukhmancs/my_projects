import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * The main method asks the user to enter the number of dice and number of sides for each die. Then it
         * should create the DiceCollection and print it to the screen. Then it should present a menu in a loop that
         * allows them to roll once or roll 100,000 times. The main method should do no calculations at all.
         * If they choose to roll once, show the result by printing the dice they got and the sum. If choose 100,000
         * rolls, call the histogram method described above, and print the non-zero elements of the array, as
         * shown in the example output.
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of dice: ");
        int dice = sc.nextInt();

        System.out.print("Enter the number of sides for each die (separated by a comma): ");
        String[] Sides = sc.next().split(",");
        int[] dieSides = new int[Sides.length];

        // convert string array to array of integers
        for (int i = 0; i < Sides.length; i++) {
            dieSides[i] = Integer.parseInt(Sides[i]);
        }

        DiceCollection dC = new DiceCollection(dieSides);
        Die[] dieArray = dC.getDie();
        System.out.print("Dice Collection: ");

        // Get total number of sides and the current side of die
        for (int i = 0; i < dice; i++) {
            System.out.print("d" + dieArray[i].getSides() + "=" + dieArray[i].getCurrentSide() + " ");
        }
        System.out.println("\nMIN=" + dC.getMinPossibleSum() + " MAX=" + dC.getMaxPossibleSum() + " current=" + dC.getCurrentSumOfSides());

        boolean x = true;
        while (x) {

            // ask how many times to roll
            System.out.print("1=roll once, 2=roll 100000 times, 3=quit: ");
            int roll = sc.nextInt();

            if (roll == 3) {
                x = false;
                break;
            } else if (roll == 2) {

                // get maximum rolls allowed
                int rolls = dC.getMAXROLL();

                // roll the dice and get the counter array
                int [] counter = dC.histogram(rolls);

                // get array of sum of current sides everytime die is rolled
                int [] sums = dC.getSums();

                // Create an array of indices
                Integer[] indices = new Integer[counter.length];
                for (int i = 0; i < indices.length; i++) {
                    indices[i] = i;
                }

                // Rearrange the elements of arr2 based on the sorted indices array
                for (int i = 0; i < counter.length; i++) {

                    // only display counter that is not zero
                    if (counter[i] !=  0) {
                        System.out.println(String.format("counter: %d Sums: %d  %s",
                                counter[i], sums[i], "*".repeat(sums[i])));
                    }
                }
            } else {

                // Get total number of sides and the current side of die
                for (int i = 0; i < dice; i++) {
                    System.out.print("d" + dieArray[i].getSides() + "=" + dieArray[i].getCurrentSide() + " ");
                }
                System.out.println("\nMIN=" + dC.getMinPossibleSum() + " MAX=" + dC.getMaxPossibleSum() + " current=" + dC.getCurrentSumOfSides());
            }
        }

    }
}