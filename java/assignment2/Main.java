import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] OPTIONS = {"Feed", "Command", "Play", "Hit", "Quit"};

    public static void main(String[] args) {

        // define 3 parrot objects
        Parrot parrot1 = new Parrot("Julius", false, 2.1, 3, true, true);
        Parrot parrot2 = new Parrot("Nancy", true, 0.6, 3, true, true);
        Parrot parrot3 = new Parrot("Johnette", false, 0.3, 0, false, false);
        Parrot[] parrots = {parrot1, parrot2, parrot3};

        // different ways user can play
        System.out.println("\nRULES:\n" +
                "1.  On Hit Selected Parrot HEALTH will decrease and parrot will be UNTAMED.\n" +
                "2.  TamedPercentage greater than 70 will make the parrot tamed.\n" +
                "3.  Staying will make the parrot TAMED.\n" +
                "4.  When fed COOKIE, the Parrot will DIE.\n" +
                "5.  PLAYING will make both the parrots UNTAMED.\n" +
                "6.  You can not feed DEAD parrot.\n");

        // Continue to run until user chooses 5 to quit
        while(true) {

            // Prompt this message on every iteration
            for (int i = 0; i < parrots.length; i++) {
                System.out.println(MessageFormat.format("{0}.   {1}   Parrot {2}: {3}g seeds,  {4} hearts,  {5},  {6}",
                        i, parrots[i].isTamed() ? "TAMED  " : "UNTAMED",
                        parrots[i].getName(), parrots[i].getSeedAmount(), parrots[i].getHealth(),
                        parrots[i].isFlying() ? "FLYING" : "STAYING",
                        parrots[i].isAlive() ? "ALIVE" : "DEAD"));
            }

            // Print options
            System.out.println("\nCHOICES: 1. Feed 2. Command 3. Play 4. Hit 5. Quit\n");

            int choice;

            // only integer types are accepted
            try {
                // Ask the user to choose from above option
                System.out.print("Choice: ");
                choice = SCANNER.nextInt();

                // verify that choices are not out of range
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid input. Please provide values between 1 to 5. Provided: " + choice);
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter values between 1 to 5. ErrorCode: " + e + "\n");
                return;
            }

            // validate the choice is not out of range value
            if (choice > OPTIONS.length) {
                System.out.println("Invalid input. Please enter values between less than 5 but greater than 1." + "\n");
                continue;
            } else if (choice == OPTIONS.length) {
                return;
            }

            int parrotChoice;
            try {
                // Ask for parrot Choice
                System.out.print("Which parrot: ");
                parrotChoice = SCANNER.nextInt();

                // verify that parrot choices are not out of range
                if (parrotChoice < 0 || parrotChoice > 2) {
                    System.out.println("Invalid input. Please provide values between 0 to 2. Provided: " + parrotChoice);
                    continue;
                }
                // check if the parrot is already dead
                if (parrotChoice == 2) {
                    System.out.println("The parrot is already dead.");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please provide values between 0 to 2. Error: " + e);
                return;
            }

            // If the user choose option 1
            switch (choice) {
                case 1 -> {

                    String food;
                    try {

                        // dead parrot can not be fed
                        if(parrots[parrotChoice].isAlive()) {

                            // ask for seed or cookie
                            System.out.print("Seed or Cookie: ");
                            food = SCANNER.next();

                            // check if the values are not seed or cookie
                            if (!food.equals("seed") && !food.equals("cookie")) {
                                System.out.println("Invalid input. Please enter either 'seed' or 'cookie'. Provide: " + food);
                                continue;
                            }
                        } else {
                            System.out.println("Dead parrot can not be fed");
                            continue;
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter either 'seed' or 'cookie'. ErrorCode: " + e + "\n");
                        return;
                    }

                    double amount;
                    try {

                        // ask for how much seed or cookie you want to feed
                        System.out.print("How much (0.1 to 5.0 grams): ");
                        amount = SCANNER.nextDouble();

                        // verify that seedAmount is not out of range
                        if (amount > 5.0 || amount < 0.1) {
                            System.out.println("Invalid input. Please enter values between 0.1 to 5.0.\n");
                            return;
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter values between 0.1 to 5.0. ErrorCode: " + e + "\n");
                        return;
                    }

                    // feed the parrot
                    System.out.println(parrots[parrotChoice].feed(food, amount));

                    // if the percentage is greater than 70.0 you have tamed the parrot
                    if (20 * amount > 70.0) {
                        System.out.println("You have tamed " + parrots[parrotChoice].getName() + "\n");
                        parrots[parrotChoice].setTamed(true);
                    }

                    // print how much the parrot is tamed
                    System.out.println("TamedPercentage: " + parrots[parrotChoice].getTamedPercentage());
                }
                case 2 -> {

                    String command;
                    try {
                        // ask if stay or fly
                        System.out.print("fly or stay: ");
                        command = SCANNER.next();
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid inputs. Only 'fly' or 'stay' is allowed. Error: " + e);
                        return;
                    }

                    // make parrot fly or stay
                    System.out.println(parrots[parrotChoice].getCommand(command) +
                            "\nTamedPercentage: " + parrots[parrotChoice].getTamedPercentage());
                }
                case 3 -> {

                    // Ask for another parrot choice to play with parrot choice one
                    int parrotChoice2;

                    // verify that integer values is provided
                    try {
                        System.out.print("Which parrot2: ");
                        parrotChoice2 = SCANNER.nextInt();
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter valid input. ErrorCode: " + e + "\n");
                        return;
                    }

                    // verify that second parrot choice is not out of bound
                    if (parrotChoice2 > OPTIONS.length) {
                        System.out.println("Invalid input. Please enter value between 1 to 3\n");
                        return;
                    }

                    // check if parrot choices are not the same
                    if (parrotChoice != parrotChoice2) {
                        System.out.println("You have untamed the parrots: " +
                                parrots[parrotChoice].getName() + ", " +
                                parrots[parrotChoice2].getName());
                        parrots[parrotChoice].setTamed(false);
                        parrots[parrotChoice2].setTamed(false);
                    } else {
                        System.out.println("Please provide two different parrots.");
                    }
                }
                case 4 -> {

                    // decrease the health everytime user hits parrot
                    System.out.println(parrots[parrotChoice].hit());
                }
            }
        }
    }
}