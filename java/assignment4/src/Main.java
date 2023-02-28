import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declare and initialize Scanner object
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of dice: ");
        int dice = sc.nextInt();

        System.out.print("Enter the number of sides for each die (separated by a comma): ");
        String[] sides = sc.next().split(",");

        // initialize dieSides array containing integer values of die sides
        int[] dieSides = new int[sides.length];

        // convert string array to array of integers
        for (int i = 0; i < sides.length; i++) {
            dieSides[i] = Integer.parseInt(sides[i]);
        }

        // Initialize DiceCollection objects to the number of sides
        DiceCollection dC = new DiceCollection(dieSides);
        Die[] dieArray = dC.getDie();
        System.out.print("\nDice Collection: ");

        // Get total number of sides and the current side of die
        for (int i = 0; i < dice; i++) {

            // get current and number of sides
            System.out.print("d" + dieArray[i].getSides() + "=" + dieArray[i].getCurrentSide() + " ");
        }

        // get overall min and max sum of dies
        System.out.println("\nMIN=" + dC.getMinPossibleSum() + " MAX=" + dC.getMaxPossibleSum() + " current=" + dC.getCurrentSumOfSides());

        // continue loop until user quit or enters 3
        while (true) {

            // ask how many times to roll
            System.out.print("\n1=roll once, 2=roll 100000 times, 3=quit: ");
            int roll = sc.nextInt();

            // if pressed 3 quit
            if (roll == 3) {
                System.out.println("BYE!!");
                break;
            } else if (roll == 2) { // if enter 2 roll 100000 times

                // get maximum rolls allowed
                int rolls = dC.getMAXROLL();

                // roll the dice and get the counter array
                int [] counter = dC.histogram(rolls);

                // get array of sum of current sides everytime die is rolled
                int [] sums = dC.getSums();

                // use bubbleSort algorithm to sort second array based on first array in increasing order
                dC.bubbleSort(sums, counter);

                // Rearrange the elements of arr2 based on the sorted indices array
                for (int i = 0; i < counter.length; i++) {

                    // only display counter that is not zero
                    if (counter[i] !=  0) {
                        System.out.println(String.format("Sums: %4d  Counter: %8d  %s",
                                sums[i], counter[i], "*".repeat(sums[i])));
                    }
                }

                System.out.print("\nDice Collection: ");

                // Get total number of sides and the current side of die
                for (int i = 0; i < dice; i++) {
                    System.out.print("d" + dieArray[i].getSides() + "=" + dieArray[i].getCurrentSide() + " ");
                }
                System.out.println("\nMIN=" + dC.getMinPossibleSum() + " MAX=" + dC.getMaxPossibleSum() + " current=" + dC.getCurrentSumOfSides());
            } else if (roll == 1) { // roll only once

                // roll all the dice once
                dC.rollAllDice();
                System.out.print("\nDice Collection: ");

                // Get total number of sides and the current side of die
                for (int i = 0; i < dice; i++) {
                    System.out.print("d" + dieArray[i].getSides() + "=" + dieArray[i].getCurrentSide() + " ");
                }
                System.out.println("\nMIN=" + dC.getMinPossibleSum() + " MAX=" + dC.getMaxPossibleSum() + " current=" + dC.getCurrentSumOfSides());
            }
        }

    }
}