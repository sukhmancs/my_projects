import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class representing collection of die
 *
 * @author SUKHMANJEET SINGH
 */
public class DiceCollection {
    /**
     * A DiceCollection object holds a set of Die objects in an array. The number of sides on each Die is
     * specified by passing an array of integers to the DiceCollection constructor. This array is used to create
     * and store the corresponding Die objects. A DiceCollection object can report the current sum of all the
     * sides showing on the dice, it can report the maximum and minimum possible sums, and it can roll all the
     * dice at once. It has a toString() method that reports all the dice, the minimum possible roll, the
     * maximum possible roll, and the current total showing on the dice. It also has a histogram method,
     * described below. That’s all it can do.
     */

    // Declare and initialize an array with null pointers
    private Die[] die;

    private final int MINROLL = 0;
    private final int MAXROLL = 100000;

    private int currentSum = 0;

    private int[] sums;

    /**
     * Constructor of this class
     * @param sides int array representing the sides of dice
     */
    public DiceCollection(int[] sides) {

        // Initialize an array to null pointers
        this.die = new Die[sides.length];

        // initialize an array with die objects
        for (int i = 0; i < sides.length; i++) {
            this.die[i] = new Die(sides[i]);
        }
    }

    /**
     * Display the current sum of all the dice
     */
    public int getCurrentSumOfSides() {

        // reset the value of sum
        this.currentSum = 0;

        // get the sum of all the sides
        for (Die value : die) currentSum += value.getCurrentSide();

        // return sum if between minimum and maximum value
        return this.currentSum <= this.getMaxPossibleSum() && this.currentSum >= this.getMinPossibleSum() ? this.currentSum : 0;
    }

    /**
     * Get objects representing die
     * @return array of die objects
     */
    public Die[] getDie() {
        return Arrays.copyOf(this.die, this.die.length);
    }

    /**
     * Get the minimum number of sum of sides
     * @return int representing the minimum number of sides
     */
    public int getMinPossibleSum() {
        int min = 0;
        for (Die d : die) {
            min += 1;
        }
        return min;
    }

    /**
     * Get the maximum number of sum of sides
     * @return int representing the maximum number of sides
     */
    public int getMaxPossibleSum() {
        int max = 0;
        for (Die d : die) {
            max += d.getSides();
        }
        return max;
    }

    /**
     * Get the minimum number of roles
     * @return int representing the minimum number of roles
     */
    public int getMINROLL() {
        return this.MINROLL;
    }

    /**
     * Get the maximum number of sum of ROLL
     * @return int representing the maximum number of sides
     */
    public int getMAXROLL() {
        return this.MAXROLL;
    }
    public void rollAllDice() {

        int rollSum = 0;

        // roll all the dice at once
        for (Die value : die) {
            value.roll();
        }
    }

    /**
     * String representation of class variables
     *
     * @return String representing the MINROLL, MAXROLL, and sum variables of this class
     */
    @Override
    public String toString() {
        return "DiceCollection{" +
                "MINROLL=" + MINROLL +
                ", MAXROLL=" + MAXROLL +
                ", sum=" + currentSum +
                '}';
    }

    public int[] getSums() {
        return this.sums;
    }

    /**
     * hostogram to represent rolls and sum of current sides
     * @param rolls int representing number of  rolls
     * @return int array representing number of times current sum appeared
     */
    public int[] histogram(int rolls) {
        int[] sums = new int[rolls];
        int[] counter = new int[rolls];
        int[] currentSum = new int[rolls];
        // check rolls is between min and max value
        if (rolls > this.getMINROLL() && rolls <= this.getMAXROLL()) {
            boolean x = true;

            // roll the dice and keep track of duplicate sums
            while (x) {
                for (int i = 0; i < rolls; i++) {
                    this.rollAllDice();
                    sums[i] = this.getCurrentSumOfSides();
                }

                boolean[] marked = new boolean[rolls];

                // keep track of duplicates
                for (int i = 0; i < rolls; i++) {
                    if (marked[i]) continue;

                    for (int j = 0; j < rolls; j++) {
                        if (sums[i] == sums[j]) {
                            marked[j] = true;
                            currentSum[i] = sums[i];
                            counter[i]++;
                        }
                    }
                }
                x = false;

                // initialize instance variable to sums
                this.sums = currentSum;
            }
        }
        return counter;
    }
}
