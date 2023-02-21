import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Class to create two villages and a King's house
 *
 * @author SUKHMANJEET SINGH
 */
public class TwoVillages extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(600, 400); // canvas size set to 600, 400 pixels
        stage.setTitle("The Village and The Village");
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // set the background to dark blue
        scene.setFill(Color.DARKBLUE);
        Village village = new Village(10, 10, 100, Color.RED, "Bezel");
        Village village2= new Village(200, 250, 100, Color.BLUE, "UI Qoma");
        House emperrorHouse = new House(450, 100);
        emperrorHouse.draw(gc);
        village.draw(gc);
        village2.draw(gc);

        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}

