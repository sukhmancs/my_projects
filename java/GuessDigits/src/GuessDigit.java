import java.util.Scanner;
import java.util.*;
public class GuessDigit {
    /*ask for users guess
    secret word
    loop over users guess
    if it matches the users guess
    increment the match value by 1
    * */

    public int guessDigit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter your guess: ");
        String userGuess = sc.nextLine();
        String myWord = "12332" + userGuess;

        int i = 0;
        int correctCount = 0;
        for (char user : userGuess.toCharArray()) {
            int y = i++;
            if (user == myWord.charAt(y)) {
                correctCount++;
                //String str = String.format("%d character correct: %d \ncorrectCount: %d", user, correctCount, correctCount);
                //System.out.print(str);
            }else {
                System.out.println("One character wrong");
            }
        }
        return correctCount;
    }
}
