/**
 * Class to represent a die
 *
 * @author SUKHMANJEET SINGH
 */
public class Die{
    /**
     * A Die object can have any integer number of sides. The number of sides is specified when a Die is
     * created and cannot be changed. A Die can report its number of sides, can report the side that is
     * currently showing, and can be rolled. When a die is rolled, it generates and stores a new integer from 1
     * to n, where n is its number of sides. It has a toString() method that reports the number of sides and the
     * number that is currently showing. That’s all it can do.
     */
    private int sides;
    private int currentSide;
    /**
     * Constructor of this class
     * @param sides int represent the sides of die
     */
    public Die(int sides) {
        this.sides = sides;
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
