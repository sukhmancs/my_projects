import javafx.scene.paint.Color; // import the Color class from the javafx.scene.paint package
import javafx.scene.shape.Circle; // import the Circle class from the javafx.scene.shape package

/**
 * The SecondPiece class represents a piece that can be drawn on a board. It extends the Pieces class.
 *
 * @author Sukhmanjeet Singh, Student ID 000838215
 */
public class SecondPiece extends Pieces {

    /**
     * Constructs a new SecondPiece object with the given size and color.
     *
     * @param size  The size of the piece.
     * @param color The color of the piece.
     */
    public SecondPiece(double size, Color color) {
        super(size, color); // call the constructor of the superclass Pieces with the size and color arguments
    }

    /**
     * Draws a circle at the given x and y coordinates.
     *
     * @param x The x coordinate of the center of the circle.
     * @param y The y coordinate of the center of the circle.
     * @return A Circle object representing the drawn piece.
     */
    @Override
    public Circle draw(double x, double y) { // override the draw method of the superclass with a Circle object that takes two double arguments, x and y

        // Create a Circle object with the calculated center point and radius
        Circle circle = new Circle(x, y, this.getSize()); // create a new Circle object with the x, y, and size properties, where size is inherited from the Pieces superclass
        circle.setFill(this.getColor()); // set the fill color of the circle to the color property inherited from the Pieces superclass
        circle.setStroke(Color.BROWN); // set the stroke color of the circle to brown
        circle.setStrokeWidth(2); // set the width of the circle's stroke to 2
        return circle; // return the Circle object
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representing the object.
     */
    @Override
    public String toString() { // override the toString method of the superclass
        return "SecondPiece{} " + super.toString(); // return a string representation of the object that includes "SecondPiece{}" and the result of calling the superclass's toString method
    }
}
