import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * This class uses javaFX to draw shapes, images on canvas of size 600, 400 in pixels
 *
 * @author Sukhmanjeet Singh
 */
public class StarsConstellation extends Application {

    /**
     * This method creates a scene and draw Stars constellation on it using GraphicsContext or gc object
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    int x = 0; // reset the animation to zero
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(600, 400); // canvas size set to 600, 400 pixels
        stage.setTitle("Constellation of Stars");
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // set the background to dark blue
        scene.setFill(Color.BLACK);

        // Create a randomly placed stars
        for (int i = 0; i < 100; i++) {
            double x = Math.random() * 600;
            double y = Math.random() * 400;
            gc.setFill(Color.WHITE);
            gc.fillOval(x, y, 2, 2);
        }

        // Ask the user to enter a series of X and Y values
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();
        ArrayList<Double> sizeArray = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of stars in your constellation: ");
        int numStars = scanner.nextInt();
        for (int i = 0; i < numStars; i++) {
            System.out.printf("Enter the X value for star %d: ", i+1);
            double x = scanner.nextDouble();
            while (x < 0 || x > 600) {
                System.out.println("Invalid value. X must be between 0 and 600.");
                System.out.printf("Enter the X value for star %d: ", i+1);
                x = scanner.nextDouble();
            }
            xValues.add(x);
            System.out.printf("Enter the Y value for star %d: ", i+1);
            double y = scanner.nextDouble();
            while (y < 0 || y > 400) {
                System.out.println("Invalid value. Y must be between 0 and 400.");
                System.out.printf("Enter the Y value for star %d: ", i+1);
                y = scanner.nextDouble();
            }
            yValues.add(y);
            double s = Math.random() * 30;
            sizeArray.add(s);
            Color original = Color.BLUE;
            gc.setFill(original.deriveColor(1, 1, 40, 1));
            gc.fillOval(x, y, s, s);
        }

        // Draw the constellation by connecting each star to the last one
        gc.setStroke(Color.PINK);
        for (int i = 0; i < xValues.size(); i++) {
            double x1 = xValues.get(i);
            double y1 = yValues.get(i);
            double sizePrevious = sizeArray.get(i);
            double size = 0;
            double x2, y2;

            // connect the last oval to the first oval
            if (i == xValues.size() - 1) {
                x2 = xValues.get(0);
                y2 = yValues.get(0);
                size = sizeArray.get(0);
            } else {
                x2 = xValues.get(i + 1);
                y2 = yValues.get(i + 1);
                size = sizeArray.get(i + 1);
            }
            gc.strokeLine(x1 + sizePrevious/2, y1 + sizePrevious/2, x2 + size/2, y2 + size/2);
        }

        stage.show();

        // CIRCLE ANIMATION
        // Create a timeline for the animation
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Add a key frame to the timeline to move the circle to the right
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            gc.setStroke(Color.RED);
            gc.strokeRect(50, 50, 150, 100);
            gc.setStroke(Color.BLUE);
            gc.strokeOval(75+x, 75, 100, 50);
            x+=10;
        });
        timeline.getKeyFrames().add(keyFrame);

        // Start the animation
        timeline.play();

        // ask the user to enter the constellation title and provide credit as well
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Constellation Title");
        dialog.setHeaderText("Enter a title for your constellation:");
        Optional<String> result = dialog.showAndWait();

        // only show the result if user have entered something
        if (result.isPresent()) {
            String title = result.get() + " (app created by Sukhmanjeet Singh)";
            Text text = new Text(title);
            text.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
            text.setFill(Color.WHITE);
            text.setX(1);
            text.setY(390);
            root.getChildren().add(text);
        }
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

