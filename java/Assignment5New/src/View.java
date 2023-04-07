import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;

/**
 * Class representing the GUI of Whack a Mole game
 *
 * @author Sukhmanjeet Singh, Student ID 000838215
 * Note: Sometimes, when mouse is clicked very quickly the MediaPlayer object, which plays the sounds effects, will not be able to keep up and will throw an error
 */

public class View extends Application {

    private Model model = new Model();
    private final double[] canvasDimensions = {320, 300};
    private final double BACKGROUND_HEIGHT = 100;
    private Label scoreLabel;
    private Label scoreLabelOne;
    private final double INSTRUCTIONS_TIME = 4;
    private VBox instructionsPane;
    private Label difficultyMode;
    private Label instructionsLabel;
    private Label instructionsText;

    /**
     * This is where we create components, models and add event handlers.
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws Exception
     */

    @Override
    public void start(Stage stage) throws Exception {

        // add a canvas where we draw stuff
        Canvas canvas = new Canvas(canvasDimensions[0], canvasDimensions[1]);

        // add graphics context object we use to draw stuff with
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // add background color to canvas
        gc.setFill(Color.LIGHTGREY);
        gc.fillRect(0, 0, canvasDimensions[0], canvasDimensions[1]);

        // hit sound for successful hit on mole
        String hitSound = "sound_effects/candy_crush_hit.mp3";
        Media sound = new Media(new File(hitSound).toURI().toString());

        // missed sound on unsuccessful hit on mole
        String missedSound = "sound_effects/candycrush_no_hit.mp3";
        Media soundOne = new Media(new File(missedSound).toURI().toString());

        // initialize font MonoSpaced for buttons
        Font mono = new Font("MonoSpaced", 12);

        // add gui components
        scoreLabel = new Label("Score " + model.getScore());    // add label representing user score
        scoreLabelOne = new Label("You Win " + model.isWin());  // add label representing user's win status
        difficultyMode = new Label("Mode " + model.getDifficultyMode());  // label representing difficulty level of the game
        difficultyMode.setTextFill(Color.RED);  // change the color to red for difficultyMode

        Button btnEasy = new Button("Easy");     // button representing difficulty mode Easy
        Button btnHard = new Button("Hard");     // button representing difficulty mode Hard
        Button btnInsane = new Button("Insane"); // button representing difficulty mode Insane
        Button replay = new Button("Replay");    // button to first stop the previous game and then play a new game

        instructionsPane = new VBox();   // add an instructions pane
        instructionsPane.setSpacing(10); // set spacing by 10
        instructionsPane.setPadding(new Insets(10)); // padding can be 10
        instructionsPane.setStyle("-fx-font-color: #ffffff;"); // set background color

        Pane root = new Pane(); // initialize the root node
        root.getChildren().addAll(instructionsPane);  // add instruction pane to the parent node

        instructionsLabel = new Label("Instructions:");   // label representing the instructions heading
        instructionsLabel.setFont(new Font("Arial", 30)); // set instructions heading font

        instructionsText = new Label(
                "Hit the moles as they appear on the screen\nto score points."); // label representing the actual instructions
        instructionsText.setFont(new Font("Arial", 16));    // set actual instructions fonts style
        instructionsPane.getChildren().addAll(instructionsLabel, instructionsText); // add both the instructions label, actual instructions to the instructionsPane

        // play this timeline after 5 seconds to first remove the instructions pane and play the game
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(INSTRUCTIONS_TIME), event -> {
            root.getChildren().clear();  // remove the instruction pane

            scoreLabel.relocate(5,
                    canvasDimensions[1] + BACKGROUND_HEIGHT - 20); // relocate scoreLabel to the bottom left of scene
            scoreLabelOne.relocate(5,
                    canvasDimensions[1] + BACKGROUND_HEIGHT - 50); // relocate scoreLabelOne to the bottom left of scene
            difficultyMode.relocate(5,
                    canvasDimensions[1] + BACKGROUND_HEIGHT - 70); // relocate mode difficulty label to the bottom left of scene

            Button[] nodes = {btnEasy, btnHard, btnInsane, replay};  // buttons array to relocate

            double offset = 0;   // offset if we have 2 or more than 2 buttons
            double offsetX = 90; // initialize the offset for x-axis for buttons
            double offsetY =
                    canvasDimensions[1] +
                    BACKGROUND_HEIGHT - 30;  // initialize the offset for y-axis for buttons by scene dimensions

            // relocate all the buttons by offset of 50 on each loop on x-axis
            for (Button n : nodes){
                n.relocate(offsetX, offsetY);
                n.setFont(mono);  // set font to mono for all the buttons

                // increase the offsetX by 10 if the encountered 2 or more than 2 buttons
                if (offset >= 2) {
                    offsetX += 10;
                }
                offsetX += 50;  // increase the offsetX by 50 for each button
                offset++;       // keep track of number of buttons
            }

            model.playWhackAMole(gc); // function to add and remove circle after certain keyframes

            // add event listener for mouse clicks and increase the score based on clicks
            canvas.setOnMouseClicked(e -> {

                // update the score and play the corresponding sound effect based on where the mouse clicked
                model.playSoundAndUpdateScore(e.getX(),
                        e.getY(),
                        sound,
                        soundOne);

                scoreLabel.setText("Score " + model.getScore());   // display the updated score
                scoreLabelOne.setText("You Win " + model.isWin()); // display the updated Win value

                // relocate all the labels once the user win
                if (model.isWin()) {

                    // relocate score label one
                    scoreLabelOne.relocate(
                            canvasDimensions[0] / 2 - 40, canvasDimensions[1] / 2);

                    // relocate score label
                    scoreLabel.relocate(
                            canvasDimensions[0] / 2 - 20, canvasDimensions[1] / 2 + 20);
                } else {  // for all the other cases reset labels positions

                    // relocate score labels to the initial position
                    scoreLabel.relocate(5,
                            canvasDimensions[1] + BACKGROUND_HEIGHT - 20);

                    // relocate scoreLabelOne to the initial position
                    scoreLabelOne.relocate(5,
                            canvasDimensions[1] + BACKGROUND_HEIGHT - 50);
                }
            });

            // when Easy button is pressed
            btnEasy.setOnAction(e -> {

                // after stopping the previous animation and set the duration for current animation to be 3.0
                model.setDuration(3.0,
                        gc,
                        canvasDimensions[0],
                        canvasDimensions[1]);

                model.setDifficultyMode("Easy");    // change the difficulty level to Easy
                difficultyMode.setText("Mode " + model.getDifficultyMode()); // change the display of difficultyMode in canvas

                // reset the position of scoreLabel to the bottom left corner of scene
                scoreLabel.relocate(5,
                        canvasDimensions[1] + BACKGROUND_HEIGHT - 20);

                // reset the position of scoreLabelOne to the bottom left corner of scene
                scoreLabelOne.relocate(5,
                        canvasDimensions[1] + BACKGROUND_HEIGHT - 50);
            });

            // when Hard button is pressed
            btnHard.setOnAction(e -> {

                // after stopping the previous animation and set the duration for current animation to be 1.5
                model.setDuration(1.5,
                        gc,
                        canvasDimensions[0],
                        canvasDimensions[1]);

                model.setDifficultyMode("Hard"); // change the difficulty level of this game to Hard
                difficultyMode.setText("Mode " + model.getDifficultyMode()); // update the difficulty level in canvas

                // reset the position of scoreLabel to the bottom left corner of scene
                scoreLabel.relocate(5,
                        canvasDimensions[1] + BACKGROUND_HEIGHT - 20);

                // reset the position of scoreLabelOne to the bottom left corner of scene
                scoreLabelOne.relocate(5,
                        canvasDimensions[1] + BACKGROUND_HEIGHT - 50);
            });

            // when Insane button is pressed
            btnInsane.setOnAction(e -> {

                // after stopping the previous animation and set the duration for current animation to be 1.0
                model.setDuration(1.0,
                        gc,
                        canvasDimensions[0],
                        canvasDimensions[1]);

                model.setDifficultyMode("Insane"); // set the difficulty level of this game to Insane
                difficultyMode.setText("Mode " + model.getDifficultyMode()); // update the difficulty level label in canvas

                // reset the position of scoreLabel to the bottom left corner of scene
                scoreLabel.relocate(5,
                        canvasDimensions[1] + BACKGROUND_HEIGHT - 20);

                // reset the position of scoreLabelOne to the bottom left corner of scene
                scoreLabelOne.relocate(5,
                        canvasDimensions[1] + BACKGROUND_HEIGHT - 50);
            });

            // when replay button is pressed
            replay.setOnAction(e -> {

                // after stopping the previous game play a new game
                model.replay(gc,
                        canvasDimensions[0],
                        canvasDimensions[1]);

                difficultyMode.setText("Mode " + model.getDifficultyMode()); // update the difficulty level Label in canvas

                // reset the position of scoreLabel to the bottom left corner of scene
                scoreLabel.relocate(5,
                        canvasDimensions[1] + BACKGROUND_HEIGHT - 20);

                // reset the position of scoreLabelOne to the bottom left corner of scene
                scoreLabelOne.relocate(5,
                        canvasDimensions[1] + BACKGROUND_HEIGHT - 50);

                scoreLabel.setText("Score " + model.getScore());   // display the updated score
                scoreLabelOne.setText("You Win " + model.isWin()); // display the updated Win value
            });

            // add all the nodes to the root node for them to be added to the scene
            root.getChildren().addAll(canvas,
                    scoreLabel,
                    scoreLabelOne,
                    difficultyMode,
                    btnEasy, btnHard,
                    btnInsane, replay);
        }));

        // add parent node to the scene
        Scene scene = new Scene(root,
                canvasDimensions[0],
                canvasDimensions[1] + BACKGROUND_HEIGHT);

        stage.setTitle("Whack A Mole"); // set title of the window
        stage.setScene(scene); // set the stage
        stage.show();          // display the stage
        timeline.play();       // play the timeline
    }

    /**
     * Make no changes here.
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
