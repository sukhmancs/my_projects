import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Class representing a window
 */
public class Window {
    private double x;
    private double y;
    private double diameter;

    /**
     * Constructor of this class
     * @param x double x-coordinate of window
     * @param y double y-coordinate of window
     * @param diameter double diameter of window
     */
    public Window(double x, double y, double diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    /**
     * Draw on canvas
     * @param gc GraphicsContext to draw on canvas
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillOval(this.x, this.y, this.diameter, this.diameter);
    }
}
