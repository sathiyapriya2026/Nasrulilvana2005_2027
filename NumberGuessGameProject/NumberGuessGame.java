import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes")) {

            int maxNumber = 100;

            System.out.println("Select Difficulty Level:");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-500)");

            int choice = scanner.nextInt();

            if (choice == 1) {
                maxNumber = 50;
            } 
            else if (choice == 2) {
                maxNumber = 100;
            } 
            else if (choice == 3) {
                maxNumber = 500;
            }

            int number = random.nextInt(maxNumber) + 1;
            int guess = 0;
            int attempts = 0;

            System.out.println("Guess a number between 1 and " + maxNumber);

            while (guess != number) {

                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low!");
                }
                else if (guess > number) {
                    System.out.println("Too high!");
                }
                else {
                    System.out.println("Correct! You win!");
                    System.out.println("Attempts used: " + attempts);
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.next();
        }

        System.out.println("Thanks for playing!");
    }
}