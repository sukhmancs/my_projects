import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Class representing a door
 */
public class Door {
    private double x;
    private double y;
    private double height;

    /**
     * function to initialize class variables
     * @param x double x-coordinate of this door
     * @param y double y-coordinate of this door
     * @param height double height of this door
     */
    public void Gate(double x, double y, double height) {
        this.x = x + height - ((height / 2 ) / 2) - 4;
        this.y = y + height - height / 2;
        this.height = height / 2;
    }

    /**
     * Draw this door on canvas
     * @param gc GraphicsContext to draw on canvas
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(this.x, this.y, this.height/2, this.height);
    }
}
