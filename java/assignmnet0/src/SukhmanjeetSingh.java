import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
public class SukhmanjeetSingh {
    public static void main(String arg[]) {
        //print the it should output your name, student
        //number and current program.
        // roll the dice and u'll get the question and answer
        String[] questions = new String[] {"Did you take any computer science courses before coming to Mohawk? If so, where did you take them and what did you learn?",
                "Have you ever programmed in a language other than Python before?",
                "If yes, list the languages you have had experience with?",
                "Have you ever done any computer programming for a job? If so, what did you do?",
                "What are your main interests or hobbies?",
                "What do you like to do in your spare time?",
                "What was your favorite thing about the Python programming course?",
                "What challenges did you face in your Python course?",
                "What are you looking forward to and/or what are you concerned about for this course in Java?",
                "What else (if anything) would you like me to know about you or your learning preferences?"};
        String[] answers = {"..."};
        System.out.print("Sukhmanjeet Singh\n000838215\nComputer Science - Software development - 559\n");
        //random.nextInt(10);get the random values between [0 - 9]
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wanna roll(y or n): ");
        boolean roll = sc.nextBoolean();
        if (roll) {
            Random random = new Random();
            int questionNumber = random.nextInt(10);
            System.out.println("rolling " + questionNumber);
            if (questionNumber < 0 || questionNumber > 10) {
                List<String> questionsList = List.of(questions); // convert array of strings to list
                System.out.println("question: " + questionsList.get(questionNumber) + "\nanswer: " + answers + "\n");
            }else {
                System.out.print("questionNumber out of range");
            }
        }else {
            for (String q : questions) {
                System.out.println("question: " + questions + "\nanswer: " + answers + "\n");
            }
        }

    }
}
