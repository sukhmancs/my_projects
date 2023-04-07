import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * The Pieces class is an abstract class that represents a piece that can be drawn on a board.
 *
 * @author Sukhmanjeet Singh, Student ID 000838215
 */
public abstract class Pieces {
    private double x;
    private double y;
    private double size;
    private Color color;

    /**
     * Constructs a new Pieces object with the given size and color.
     *
     * @param size  The size of the piece.
     * @param color The color of the piece.
     */
    public Pieces(double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
     * Gets the x coordinate of the piece.
     *
     * @return The x coordinate of the piece.
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the piece.
     *
     * @param x The new x coordinate of the piece.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the y coordinate of the piece.
     *
     * @return The y coordinate of the piece.
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the piece.
     *
     * @param y The new y coordinate of the piece.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets the size of the piece.
     *
     * @return The size of the piece.
     */
    public double getSize() {
        return size;
    }

    /**
     * Sets the size of the piece.
     *
     * @param size The new size of the piece.
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Gets the color of the piece.
     *
     * @return The color of the piece.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the piece.
     *
     * @param color The new color of the piece.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws a piece at the given x and y coordinates.
     *
     * @param x The x coordinate of the center of the piece.
     * @param y The y coordinate of the center of the piece.
     * @return A Circle object representing the drawn piece.
     */
    public abstract Circle draw(double x, double y);

    /**
     * Returns a string representation of the object.
     *
     * @return A string representing the object.
     */
    @Override
    public String toString() {
        return "Pieces{" +
                "x=" + x +
                ", y=" + y +
                ", size=" + size +
                '}';
    }
}
