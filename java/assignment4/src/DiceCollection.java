import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class representing collection of die
 *
 * @author SUKHMANJEET SINGH
 */
public class DiceCollection {

    // Declare and initialize an array with null pointers
    private Die[] die;

    // constant value of minimum number of rolls
    private final int MINROLL = 1;

    // constant value of maximum number of rolls
    private final int MAXROLL = 100000;

    // set current sum of sides to zero
    private int currentSum = 0;

    // to store number of sums
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

        // initialize minimum possible sum to zero
        int min = 0;

        // loop over to calculate the total sum of dies sides
        for (Die d : die) {

            // increment by one
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

        // initialize current Sum to zero
        int rollSum = 0;

        // roll all the dice at once
        for (Die value : die) {

            // roll the dice
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

    /**
     * Sort an array using bubble sort algorithm
     * @param arr1 integer array first array to be sorted
     * @param arr2 integer array second array to be sorted
     */
    public void bubbleSort(int[] arr1, int[] arr2) {
        int n = arr1.length;

        // Perform bubble sort on the first array and rearrange the second array based on the sorted indices
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    int temp1 = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp1;
                    int temp2 = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp2;
                }
            }
        }
    }

    /**
     * get total number of sums on each die
     * @return int array to represent sums on each die
     */
    public int[] getSums() {
        return this.sums;
    }

    /**
     * histogram to represent rolls and sum of current sides
     * @param rolls int representing number of  rolls
     * @return int array representing number of times current sum appeared
     */
    public int[] histogram(int rolls) {
        int[] sums = new int[rolls];
        int[] counter = new int[rolls];
        int[] currentSum = new int[rolls];

        // check rolls is between min and max value
        if (rolls > this.getMINROLL() && rolls <= this.getMAXROLL()) {
            // set the boolean x to true
            boolean x = true;

            // roll the dice and keep track of duplicate sums
            while (x) {

                // roll all the dice rolls number of times
                for (int i = 0; i < rolls; i++) {

                    // roll all the dice at once
                    this.rollAllDice();

                    // keep track of the current sum of sides of dice
                    sums[i] = this.getCurrentSumOfSides();
                }

                // mask out duplicates using marked array of booleans
                boolean[] marked = new boolean[rolls];

                // keep track of duplicates
                for (int i = 0; i < rolls; i++) {
                    if (marked[i]) continue;

                    // loop over all the rolls and check the current sum
                    for (int j = 0; j < rolls; j++) {

                        // if sum are the same increment the counter
                        if (sums[i] == sums[j]) {

                            // set marked index to true
                            marked[j] = true;

                            // set the current sum to this sum
                            currentSum[i] = sums[i];

                            // increment the counter by one
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
