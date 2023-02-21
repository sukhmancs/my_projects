import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;
public class StudentsQuizVersion2 {
    public void askQuestions() {
        Scanner sc = new Scanner(System.in);
        int correctAnswers = 0;
        do {
            System.out.println("Please enter your first question here: ");
            String questionFirst = sc.nextLine();
            if (questionFirst.length() > 0) {
                correctAnswers++;
            }
            System.out.println("Please enter your second question here: ");
            String questionSecond = sc.nextLine();
            if (questionSecond.length() > 0) {
                correctAnswers++;
            }
            // Repeat for the remaining questions
            // ...
        } while (correctAnswers < 5);
    }

}
