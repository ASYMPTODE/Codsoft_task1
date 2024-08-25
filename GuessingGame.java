import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minNum = 1;
        int maxNum = 100;
        int maxAttempts = 10;
        int score = 0;
        int roundsPlayed = 0;

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(maxNum - minNum + 1) + minNum;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + minNum + " and " + maxNum + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts + 1); // More points for fewer attempts
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            roundsPlayed++;
            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println(
                "Thanks for playing! You played " + roundsPlayed + " rounds with a total score of " + score + ".");
        scanner.close();
    }
}
