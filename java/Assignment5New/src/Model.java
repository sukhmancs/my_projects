import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.util.Random;

/**
 * Class describing the logic of Whack a Mole game
 *
 * @author Sukhmanjeet Singh, Student ID 000838215
 */
public class Model {
    private int score = 0;
    private boolean isCirclePresent = false;
    private final double CIRCLERADIUS = 60;
    private double CircleX = 0;
    private double CircleY = 0;
    private double duration = 2.0;
    Timeline timeline;
    private boolean isWin = false;
    private Random rand = new Random();
    private String difficultyMode = "Easy";

    /**
     * add red circle to represent a mole
     * @param gc GraphicsContext to draw with
     * @param CircleX double position of mole along x-axis on canvas
     * @param CircleY double position of mole along y-axis on canvas
     */
    public void addCircle(GraphicsContext gc, double CircleX, double CircleY) {
        gc.setFill(Color.RED); // set the color to Red to represent mole
        gc.fillOval(CircleX, CircleY, this.CIRCLERADIUS, this.CIRCLERADIUS); // draw the circle
    }

    /**
     * To increment the score and on every successful hit play the sound or vice-versa
     * @param mouseX double representing the position of mouse click along x-axis
     * @param mouseY double representing the position of mouse click along y-axis
     * @param sound Media sound on successful hit
     * @param soundOne Media sound on missed hit
     */
    public void playSoundAndUpdateScore(double mouseX, double mouseY, Media sound, Media soundOne) {

        // distance between mouse click and mole / red circle
        double distance = Math.sqrt(Math.pow(this.CircleX - mouseX, 2) + Math.pow(this.CircleY - mouseY, 2));

        // initialize media player objects with different sounds
        MediaPlayer mediaPlayerOne = new MediaPlayer(sound);
        MediaPlayer mediaPlayerTwo = new MediaPlayer(soundOne);

        // if the distance is less than 30 increment the score by one
        if (distance <= this.CIRCLERADIUS && this.isCirclePresent) {
            mediaPlayerOne.play();  // play the sound on every successful hit
            this.score++;           // increment the score

            if(this.score >= 5) {   // if the score reaches 5 or more user win
                this.isWin = true;  // set isWin to be true
                timeline.stop();    // once user won stop the game
            }
        } else if (!this.isWin) {   // for every miss hit play candycrush_no_hit.mp3 sound
            mediaPlayerTwo.play();  // sound to be played
        }
    }

    /**
     * get the value of isWin representing user is won or loss
     * @return boolean isWin
     */
    public boolean isWin() {
        return isWin;
    }

    /**
     * get the current score of the user on each successful hit
     * @return int representing the score of user
     */
    public int getScore() {
        return score;
    }

    /**
     * representing if mole is present or not
     * @return boolean true of mole is present or vice-versa
     */
    public boolean isCirclePresent() {
        return isCirclePresent;
    }

    /**
     * update score of the user based on successful hits
     * @param score int representing the current score of the user
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * mark the user win or loss
     * @param win boolean true if win or vice-versa
     */
    public void setWin(boolean win) {
        isWin = win;
    }

    /**
     * to make the game harder or easy it sets the duration for the timeline in playWhackAMole() function
     * @param duration double 3.0 for easy, 1.5 for hard, 1.0 for insane
     * @param gc GraphicsContext to draw with
     */
    public void setDuration(double duration, GraphicsContext gc, double canvasDimensionsX, double canvasDimensionsY) {
        this.duration = duration; // set how fast the game should play
        timeline.stop();          // stop the previous game
        gc.setFill(Color.LIGHTGREY);
        gc.fillRect(0, 0, canvasDimensionsX, canvasDimensionsY); // clear the canvas
        this.setScore(0);    // reset the score of the user
        this.setWin(false);  // reset the if won or loss status
        playWhackAMole(gc);  // replay the game
    }

    /**
     * sets the score to zero, clear the canvas and again the play the game
     * @param gc GraphicsContext to draw with
     * @param canvasDimensionsX double representing the canvas size along x-axis
     * @param canvasDimensionsY double representing the canvas size along x-axis
     */
    public void replay(GraphicsContext gc, double canvasDimensionsX, double canvasDimensionsY) {
        this.score = 0;       // reset the users score
        this.duration = 2.0;  // reset the duration
        this.isWin = false;   // reset the win status
        this.setDifficultyMode("Easy"); // update the difficulty level
        this.timeline.stop(); // stop the timeline
        gc.setFill(Color.LIGHTGREY); // background color to represent clear screen in canvas
        gc.fillRect(0, 0, canvasDimensionsX, canvasDimensionsY); // clear the canvas
        playWhackAMole(gc);   // replay the game
    }

    /**
     * get the current difficulty level of this game
     * @return String representing the current difficulty level
     */
    public String getDifficultyMode() {
        return this.difficultyMode;
    }

    /**
     * set the difficulty level of the game
     * @param mode String representing the difficulty level
     */
    public void setDifficultyMode(String mode) {
        this.difficultyMode = mode;
    }

    /**
     * sets the timeline after which to add a circle/mole and to remove a circle/mole
     * @param gc GraphicsContext to draw with
     */
    public void playWhackAMole(GraphicsContext gc) {
        double timelineOneSeconds = this.duration / 2; // duration after which mole should disappear

        // timeline to represent red circles / moles
        timeline = new Timeline(new KeyFrame(Duration.seconds(this.duration), event -> {

            // bound the random number by 3
            int i = this.rand.nextInt(3);
            int j = this.rand.nextInt(3);

            // randomize the values of CircleX and CircleY based on randomize numbers
            this.CircleX = i * 100 + 50;
            this.CircleY = j * 100 + 50;

            this.addCircle(gc,            // add a mole/circle based on CircleX and CircleY position
                    CircleX - 30,
                    CircleY - 30);
            this.isCirclePresent = true;  // circle needs to be present for it to true

            // add a timeline representing the lightGreen Circles/mole holes
            Timeline timelineOne = new Timeline(new KeyFrame(Duration.seconds(timelineOneSeconds), event1 -> {

                gc.setFill(Color.LIGHTGREEN);     // set the fill to be LightGreen for mole holes
                gc.fillOval(this.CircleX - 30,  // position where to remove the red circle or mole
                        this.CircleY - 30,
                        this.CIRCLERADIUS,
                        this.CIRCLERADIUS);
                this.isCirclePresent = false;
            }));
            timelineOne.play();     // play the timeline to remove the red circle or mole
        }));
        timeline.setCycleCount(-1); // play the timeline indefinitely
        timeline.play();            // play the timeline
    }
}
