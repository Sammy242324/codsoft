import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        int startRange = 1;
        int endRange = 100;
        int maxAttempts = 5;
        int score = 0;

        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            int randomNumber = generateRandomNumber(startRange, endRange);
            int attempts = 0;
            int userGuess;

            System.out.println("Guess a number between " + startRange + " and " + endRange + ".");
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess > randomNumber) {
                    System.out.println("Too high! Attempts left: " + (maxAttempts - attempts));
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Oops! You ran out of attempts. The number was " + randomNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
            System.out.println();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Game over. Your score: " + score);

        scanner.close();
    }

    public static int generateRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }
}
