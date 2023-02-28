/**
 * Class to represent a die
 *
 * @author SUKHMANJEET SINGH
 */
public class Die{

    // to store number of sides on this die
    private int sides;

    // to store the current side after roll on this die
    private int currentSide;
    /**
     * Constructor of this class
     * @param sides int represent the sides of die
     */
    public Die(int sides) {
        this.sides = sides;

        // set the current side to random value greater than one but less than number of sides
        this.currentSide = (int)(Math.random() * this.sides) + 1;
    }

    /**
     * Get number of sides in die
     * @return int number of sides of this die
     */
    public int getSides() {
        return this.sides;
    }

    /**
     * Get the current side of this die
     * @return int current side of this die is showing
     */
    public int getCurrentSide() {
        return currentSide;
    }

    /**
     * Roll this die
     */
    public void roll() {

        // generate random number between 1 to sides
        this.currentSide = (int)(Math.random() * this.sides) + 1;
    }

    /**
     * String representation of number of sides and current side
     * @return String displaying the number of sides and the current side
     */
    @Override
    public String toString() {
        return "Die{" +
                "sides=" + sides +
                ", currentSide=" + currentSide +
                '}';
    }
}
