// Import necessary JavaFX classes
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * The Main class is responsible for initializing the JavaFX application and creating the user interface.
 * It includes methods for handling user input and displaying output on the GUI.
 *
 * @author Sukhmanjeet Singh, Student ID 000838215
 */
public class Main extends Application {
    // Declare constants and instance variables
    private final int CELL_SIZE = 80; // Size of each cell in the grid
    private final int CIRCLE_RADIUS = 30; // Radius of each circle
    private TextField rowTextField; // Text field for entering row number
    private TextField columnTextField; // Text field for entering column number
    private Pane pane; // Pane to hold the grid and circles

    private static final int WIDTH = 800; // Width of the window
    private static final int HEIGHT = 400; // Height of the window
    private final int NUM_ROWS = HEIGHT / CELL_SIZE; // Number of rows in the grid
    private final int NUM_COLS = WIDTH / CELL_SIZE; // Number of columns in the grid
    private ArrayList<Circle> circlesList = new ArrayList<>(); // List to hold all the circles on the grid
    private Label error; // Label to display error messages
    private Label errorLabel; // Label to display error message for invalid input
    private Label rowLabel; // Label for row text field
    private Label columnLabel; // Label for column text field
    private Button addButton; // Button to add a circle to the grid
    private Button clearButton; // Button to clear all circles from the grid
    private Button addButtonTwo; // Button to add a second type of circle to the grid
    private Button undoButton; // Button to undo the last circle added to the grid
    private Circle existingCircle; // Circle object to hold the circle that was last added to the grid
    private FirstPiece firstPiece = new FirstPiece(CIRCLE_RADIUS, Color.RED); // Instance of the FirstPiece class
    private SecondPiece secondPiece = new SecondPiece(CIRCLE_RADIUS, Color.GREEN); // Instance of the SecondPiece class

    /**
     * The start method is responsible for initializing the JavaFX application and creating the user interface.
     * It creates all the necessary UI elements, including buttons, text fields, and labels, and sets up event
     * handlers for user input. It also initializes the pane with an empty background.
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage primaryStage) {

        // Canvas object to use GraphicsContent2D object
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create the input fields and button
        rowLabel = new Label("Row:"); // Label to represent row
        columnLabel = new Label("Column:"); // Label to represent row
        error = new Label("Status: "); // Label to display error messages
        errorLabel = new Label("No Error."); // Error label with default value "No Error"

        // default font style for the Error message
        error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
        errorLabel.setWrapText(true); // To wrap error message
        errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
        rowTextField = new TextField("1"); // TextField to accept row values
        columnTextField = new TextField("2"); // TextField to accept column values
        addButton = new Button("Add Circle 1"); // Button to add first piece
        addButtonTwo = new Button("Add Circle 2"); // Button to add second piece
        clearButton = new Button("Clear Screen"); // Clear the screen and empty out any current Circle objects in the list
        undoButton = new Button("Undo"); // undo the previous action
        addButton.setOnAction(event -> addCircle()); // Add first piece on button pressed
        addButtonTwo.setOnAction(event -> addCircleTwo()); // Add second piece on second button pressed
        clearButton.setOnAction(event -> { // clear screen on button press
            if (!circlesList.isEmpty()) { // Check if list is not empty
                pane.getChildren().clear(); // Clear any piece from pane object
                circlesList.clear(); // Empty out the Arraylist containing all the Circle/pieces
                errorLabel.setText("Screen cleared"); // Display Status message
            } else { // Otherwise
                errorLabel.setText("Nothing to clear. Canvas is already empty");
            }

            // Set the style for messages
            error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
            errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
        });
        undoButton.setOnAction(event -> { // Undo action on undoButton press

            // Check if there are any circles to undo
            if (!circlesList.isEmpty()) {

                // Remove the last circle from the pane and the list
                Circle lastCircle = circlesList.remove(circlesList.size() - 1);
                pane.getChildren().remove(lastCircle); // Remove recently added piece
                errorLabel.setText("Undo successfully."); // Display the warning
            } else { // Otherwise
                errorLabel.setText("Nothing to Undo. Canvas is empty.");
            }

            // Set the error message style
            error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
            errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
        });

        // Set up event handlers to validate the inputs when the text changes
        columnTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int value = Integer.parseInt(newValue);
                if (value < 1 || value > NUM_COLS) {
                    columnTextField.setText(oldValue);
                    errorLabel.setText("Input must be an integer between 1 and 10");
                    error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                    errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                } else {
                    errorLabel.setText("No Error");
                    error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
                    errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input type.");
                columnTextField.setText(oldValue);
                errorLabel.setText("Invalid input type. Input must be an integer.");
                error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
            }
        });

        // Set up event handlers to validate the inputs when the text changes
        rowTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int value = Integer.parseInt(newValue);
                if (value < 1 || value > NUM_ROWS) {
                    rowTextField.setText(oldValue);
                    errorLabel.setText("Input must be an integer between 1 and 5");
                    error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                    errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                } else {
                    errorLabel.setText("No Error");
                    error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
                    errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: green;");
                }
            } catch (NumberFormatException e) {
                rowTextField.setText(oldValue);
                errorLabel.setText("Invalid input type. Input must be an integer.");
                error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
            }
        });

        // Mouse event
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {

            // Unselect previously selected circle/piece
            if (existingCircle != null) {
                existingCircle.setStroke(Color.BROWN);
                existingCircle.setStrokeWidth(2);
            }
            // Get the row and column indices based on the mouse coordinates
            double mouseX = event.getX(); // Mouse x coordinates
            double mouseY = event.getY(); // Mouse y coordinates
            int row = (int) (mouseY / CELL_SIZE); // Get the Row index based on mouse y coordinates
            int column = (int) (mouseX / CELL_SIZE); // Get the Column index based on mouse x coordinates

            // Get the center of the cell based on its cell size, row and column numbers
            double x = (column * CELL_SIZE) + (CELL_SIZE / 2.0);
            double y = (row * CELL_SIZE) + (CELL_SIZE / 2.0);

            existingCircle = null; // Initialize existingCircle to null

            // Find out what circle needs to be outlined based on where the mouse is pressed
            for (int i = 0; i < circlesList.size(); i++) {
                Circle circle = circlesList.get(i);
                if (circle.getCenterX() == x && circle.getCenterY() == y) { // Compare against coordinates of each Circle in the list
                    existingCircle = circle;
                    break;
                }
            }

            // If there is an existing circle, change the outline of that circle
            if (existingCircle != null) {
                existingCircle.setStroke(Color.BLUE); // Set up outline color
                existingCircle.setStrokeWidth(6); // Set up its width
            }

            // If a circle does not exist in the cell, show the popup
            if (existingCircle == null) {

                // Create and configure the popup
                Popup popup = new Popup();
                popup.setX(event.getScreenX()); // Set the popup x-coordinates according to mouse event x-coordinates
                popup.setY(event.getScreenY()); // Set the popup y-coordinates according to mouse event y-coordinates
                Label label = new Label("You clicked outside a circle!"); // Pop up message
                label.setStyle("-fx-background-color: white; -fx-padding: 10px;"); // Style
                popup.getContent().add(label);
                popup.setAutoHide(true); // Auto hide the popup if clicked somewhere else after the popup message
                popup.show(canvas.getScene().getWindow()); // Display on canvas.
            }
        });


        // Create the grid pane and add the input fields and button to it
        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10); // Set Horizontal gap between grid cells (default to 0)
        inputGrid.setVgap(10); // Set Vertical gap between grid cells  (default to 0)
        inputGrid.setPadding(new Insets(10)); // Set up padding
        inputGrid.addRow(0, rowLabel, rowTextField); // First row containing rowLabel and rowTextField
        inputGrid.addRow(1, columnLabel, columnTextField); // Second row
        inputGrid.add(error, 3, 0); // First Row and fourth column
        inputGrid.add(errorLabel, 4, 0); // First Row and fifth column
        inputGrid.addRow(2, addButton, addButtonTwo, undoButton, clearButton); // Third Row

        // Draw the grid on Canvas
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                gc.setStroke(Color.BLACK);
                gc.strokeRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        // Create the pane for displaying the circles
        pane = new Pane();

        // Create the root pane and add the input grid and display pane to it
        GridPane root = new GridPane();
        root.setHgap(10); // Horizontal gap between cells of the grid
        root.setVgap(10); // Vertical gap between cells of the grid
        root.setPadding(new Insets(10)); // padding
        root.add(inputGrid, 0, 0); // column first and row first
        root.add(pane, 0, 1); // column first and row second
        root.add(canvas, 0, 1); // column first and row second

        int startUpCircles = 4; // Number of Circles to initialize on startup

        // Initialize some circles on startup
        for (int i = 1; i <= startUpCircles; i++) {
            rowTextField.setText(String.valueOf(i)); // Setup row
            columnTextField.setText(String.valueOf(i+1)); // Setup column
            addCircle(); // then add circle based on row and column
            rowTextField.setText(String.valueOf(i)); // row
            columnTextField.setText(String.valueOf(i+2)); // column
            addCircleTwo(); // then add second circle based on previous row and column
        }

        // Create the scene and set it as the primary stage's scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grid Circle");
        primaryStage.show();
    }

    /**
     * Adds a new circle to the pane at the specified row and column values entered in the text fields.
     *
     * If the row and column values are not valid, an error message is displayed.
     */
    private void addCircle() {
        // Get the row and column values from the text fields
        int row = Integer.parseInt(rowTextField.getText()) - 1;
        int column = Integer.parseInt(columnTextField.getText()) - 1;

        // Calculate the x and y coordinates of the center of the cell
        double x = (column * CELL_SIZE) + (CELL_SIZE / 2.0);
        double y = (row * CELL_SIZE) + (CELL_SIZE / 2.0);

        for (Circle circle: circlesList) { // Loop over all the circles
            if (circle.getCenterX() == x && circle.getCenterY() == y) { // Check if Circle already exists
                System.out.println("Circle already exists");
                errorLabel.setText("Circle already exists"); // Error message

                // Error message style
                error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                return; // stop the execution here
            }
        }

        // Create a Circle object with the calculated center point and radius
        Circle circle = firstPiece.draw(x, y);

        // Keep track of everytime circle is created
        circlesList.add(circle);

        // Add the Circle object to the display pane
        pane.getChildren().add(circle);
    }

    /**
     * Adds a another type of circle to the pane at the specified row and column values entered in the text fields.
     *
     * If the row and column values are not valid, an error message is displayed.
     */
    private void addCircleTwo() {
        // Get the row and column values from the text fields
        int row = Integer.parseInt(rowTextField.getText()) - 1;
        int column = Integer.parseInt(columnTextField.getText()) - 1;

        // Calculate the x and y coordinates of the center of the cell
        double x = (column * CELL_SIZE) + (CELL_SIZE / 2.0);
        double y = (row * CELL_SIZE) + (CELL_SIZE / 2.0);

        for (Circle circle: circlesList) { // loop over all the circles in the circleList
            if (circle.getCenterX() == x && circle.getCenterY() == y) { // Check if Circle already exists
                System.out.println("Circle already exists");
                errorLabel.setText("Circle already exists"); // Error message

                // Error message style
                error.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-font-style: italic; -fx-text-fill: red;");
                return; // stop the execution here.
            }
        }

        // Create a Circle object with the calculated center point and radius
        Circle circle = secondPiece.draw(x, y);

        // Keep track of everytime circle is created
        circlesList.add(circle);

        // Add the Circle object to the display pane
        pane.getChildren().add(circle);
    }

    /**
     * The main entry point for the JavaFX application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
