import java.util.Random;
import java.util.Scanner;

// Main class
public class Main {
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.startGame();
    }
}

// NumberGuessingGame class
class NumberGuessingGame {
    public void startGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int attempts = 0;
        int maxAttempts = 5; // Define the maximum number of attempts
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess the number. Good luck!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }

            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
