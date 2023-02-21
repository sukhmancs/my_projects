import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is a class to check the divisibility of the number and to return the numbers that makes it divisible
 *
 * @author Sukhmanjeet Singh
 * */
public class DivisiblityCheck {
    /**
     * Divisibility rules:
     *
     * Divisibility rule for 2:
     * All even numbers are divisible by 2 (the number n finishes at 0, 2, 4, ,6 8);
     * Divisibility rule for 3:
     * A number, n, is divisible by 3 if and only if the sum of its digits is divisible by 3;
     * Divisibility rule for 4:
     * A number, n, is divisible by 4 if and only if the last two digits form a number divisible by 4;
     * Divisibility rule for 5:
     * A number, n, is divisible by 5 if and only if the number finishes at 0 or 5;
     * Divisibility rule for 6:
     * If a number, n, is divisible by 2 and 3 at the same time, it is divisible by 6;
     */

    /**
     * checks if the number is divisible the another number
     *
     * @param divident String the number to check for the divisibily rules
     * @param divisor int the number to divide the divident with
     * @return boolean true if the divident is divisible by the divisor or vice-versa
     * */
    public boolean isDivisible(String divident, int divisor) {
        boolean divisibility = true;
        int dividentLastDigit = Integer.parseInt(divident.substring(divident.length() - 1));

        switch (divisor) {
            case 2, 3, 6, 9:
                if (divisor == 2 || divisor == 6) {

                    // check if the last digit of divident is divisibly by 2
                    if (dividentLastDigit % 2 == 0) {
                        System.out.println(divident + " number is divisible by " + divisor);
                        divisibility = true;
                    } else {
                        System.out.println(divident + " number is not divisible by " + divisor);
                        divisibility = false;
                    }
                }

                if (divisor == 6 || divisor == 3 || divisor == 9) {
                    int digitPrevious = 0;
                    int digitInt = 0;

                    //Calculate the sum of digits in divident for it to be divisibly by 3
                    for (char digit : divident.toCharArray()) {
                        digitInt = Integer.parseInt(digit + "");
                        digitInt = digitInt + digitPrevious;
                        digitPrevious = digitInt;
                    }
                    if (digitInt % 3 == 0) {
                        System.out.println(divident + " number is divisible by " + divisor + " because the sum "
                                + digitInt + " is not divisible by " + divisor);
                        divisibility = true;
                    }else {
                        System.out.println(divident + " number is not divisible by " + divisor);
                        divisibility = false;
                    }
                }
                break;
            case 4:

                //Check if the last two digits form a number divisibly by 4
                if (Integer.parseInt(divident.substring(divident.length() - 2)) % 4 == 0) {
                    System.out.println(divident + " number is divisible by 4");
                    divisibility = true;
                }else {
                    System.out.println(divident + " number is not divisible by 4");
                    divisibility = false;
                }
                break;
            case 5, 10:

                // check if the last digit of divident is 0 or 5 for it to be divisibly by 5 or 10
                if (dividentLastDigit == 0) {
                    System.out.println(divident + " number is divisible by " + divisor);
                    divisibility = true;
                }else if (dividentLastDigit == 5 && divisor == 5){
                    System.out.println(divident + " number is divisible by " + divisor);
                    divisibility = true;
                }else {
                    System.out.println(divident + " number is not divisible by " + divisor);
                    divisibility = false;
                }
                break;
            case 8:

                // check if last three digits in divident form a number divisible by 4
                if (Integer.parseInt(divident.substring(divident.length() - 3)) % 4 == 0) {
                    System.out.println(divident + " number is divisible by 8");
                    divisibility = true;
                }else {
                    System.out.println(divident + " number is not divisible by 8");
                    divisibility = false;
                }
                break;
        }
        return divisibility;
    }

    /**
     * Check if the number is an integer
     *
     * @param number char number to check for
     * @return boolean true if the number is integer or vice-versa
     * */
    public boolean isInt(char number) {
        try {
            @SuppressWarnings("unused")
            int x = Integer.parseInt(number + "");
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Calculate and display the Missing Numbers for it to be divisible by the divisor
     *
     * @param divident String the number to find the missing digits for
     * @param divisor int check if the divident is divisible by the divisor
     */
    public void missingNumberGenerator(String divident, int divisor) {
        String number = divident;
        int missingDigits = 0;

        // convert any random value other than x or t to x and t
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (Character.isLetter(ch) & missingDigits == 0) {
                number = number.replace(ch, 'x');
                missingDigits++;
            } else if (Character.isLetter(ch) && missingDigits > 0) {
                number = number.replace(ch, 't');
                missingDigits++;
            }
        }

        if (missingDigits > 2) {
            System.out.println(MessageFormat.format("WARNING: 2 missing digits expected {0} provided. " +
                                                   "The number of possible outcomes could be lesser than expected\n", missingDigits));
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String guess1 = number.replace('x', (char)(i + '0'));
                int num = Integer.parseInt(guess1.replace('t', (char)(j + '0')));
                if (num % divisor == 0) {
                    System.out.println("The missing digit is " + i + ","+ j + " and the number is " + num);
                }
            }
        }
        System.out.println(MessageFormat.format("No other missing digit was found that makes {0} divisible by {1}", divident, divisor));
    }
}
