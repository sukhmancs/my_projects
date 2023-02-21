import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Class to represent a house
 */
public class House {
    private double x;
    private double y;
    private double size;
    private int occupants;
    private Color color;

    /**
     * Constructor of this class
     * @param x double x-coordinate
     * @param y double y-coordinate
     * @param size double size of this house
     * @param occupants int number of people in this house
     * @param color Color representing color of this house
     */
    public House(double x, double y, double size, int occupants, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.occupants = occupants;
        this.color = color;
    }

    /**
     * Constructor to create King's house
     * @param x double x coordinate of this house
     * @param y double y coordinate of this house
     */
    public House(double x, double y) {
        this.x = x;
        this.y = y;
        this.occupants = 1;
        this.size = 120;
        this.color = Color.ORANGE;
    }

    /**
     * Get the size of house
     * @return double size of this house
     */
    public double getSize() {
        return this.size;
    }

    /**
     * Get the number of occupants in a house
     * @return int occupants in a house
     */
    public int getOccupants() {
        return occupants;
    }

    /**
     * Set the number of occupants in a house
     * @param occupants int the number representing population
     */
    public void setOccupants(int occupants) {
        this.occupants = occupants;
    }

    /**
     * Draw this house on canvas
     * @param gc GraphicsContext to draw on canvas
     */
    public void draw(GraphicsContext gc) {
        Door door = new Door();
        Window window = new Window(this.x + this.size/5, this.y + this.size/5, this.size/4);
        gc.setFill(color);
        gc.fillRect(this.x, this.y, this.size, this.size);
        
        // draw door
        door.Gate(this.x, this.y, this.size);
        door.draw(gc);
        window.draw(gc);
    }
}
