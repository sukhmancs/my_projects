import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class StudentsQuiz {
    /**Write a program that gives the user a five-question quiz. Put the quiz into a do-while loop and
     don’t let the user exit the program until they have answered all five questions correctly
     * **/
    public void askQuestions() {
        Scanner sc = new Scanner(System.in);
        /*ask for input 5 times
        if they answered all the questions exit()
        * */
        boolean x;
        do {
            System.out.println("Please enter your first qusetion here: ");
            String questionFirst = sc.nextLine();
            System.out.println("Please enter your second qusetion here: ");
            String questionSecond = sc.nextLine();
            System.out.println("Please enter your third qusetion here: ");
            String questionThird = sc.nextLine();
            System.out.println("Please enter your fourth qusetion here: ");
            String questionFourth = sc.nextLine();
            System.out.println("Please enter your fifth qusetion here: ");
            String questionFifth = sc.nextLine();
            if (questionFirst.length() > 0 && questionFifth.length() > 0 && questionThird.length() > 0 && questionFourth.length() > 0) {
                x = true;
            } else {
                x = false;
            }
        } while (!x);
    }
}
