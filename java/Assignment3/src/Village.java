import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Class to represent a village
 */
public class Village {
    private double x;
    private double y;
    private double size;
    private Color color;
    private String name;

    /**
     * Constructor of this class
     * @param x double x-coordinate of this village
     * @param y double y-coordinate of this village
     * @param size double size of this village
     * @param color Color representing the color of this village
     * @param name String name of this village
     */
    public Village(double x, double y, double size, Color color, String name) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.name = name;
    }

    /**
     * Draw a village
     * @param gc GraphicsContext to draw on canvas
     */
    public void draw(GraphicsContext gc) {

        // provide random number of occupants
        int occupants = (int)(3 + (Math.random() * 30));
        double spacing = 8 + (Math.random() * 100);
        double villageSize = this.size + spacing;
        House house1 = new House(this.x, this.y, this.size, occupants, this.color);
        House house2 = new House(this.x + this.size + spacing, this.y + this.size / 2, this.size / 2, occupants, this.color);
        House house3 = new House(this.x + this.size + 2 * spacing + this.size / 2, this.y + 2 * this.size / 3, this.size / 3, occupants, this.color);
        House[] houses = {house1, house2, house3};

        // set the initial population to be zero
        int population = 0;

        // Draw number of houses and count the total population
        for (House house : houses) {
            house.draw(gc);
            population += house.getOccupants();
        }

        // Add House name, size and Population
        gc.setFill(Color.WHITE);
        String formatted_text = String.format("%s (size %.2fm population %d)", this.name, villageSize, population);
        gc.fillText(formatted_text, this.x, y + this.size + 13);
    }
}
