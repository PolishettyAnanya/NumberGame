import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 15;
        int totalRounds = 4;
        int totalScore = 0;

        for (int round = 1; round <= totalRounds; round++) {
            int targetNumber = generateRandomNumber(lowerBound, upperBound);
            System.out.println("Round " + round + " - Guess the Number Game");

            int attempts = 0;
            while (attempts < maxAttempts) {
                int guessedNumber = getUserGuess(lowerBound, upperBound);
                attempts++;

                if (guessedNumber == targetNumber) {
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (guessedNumber < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Round " + round + " - Sorry, you've used all your attempts. The number was: " + targetNumber);
            }

            System.out.println("Total Score: " + totalScore);
            System.out.println();
        }

        System.out.println("Game Over! Your final score is: " + totalScore);
    }

    public static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public static int getUserGuess(int lowerBound, int upperBound) {
        String input = JOptionPane.showInputDialog("Guess the number between " + lowerBound + " and " + upperBound + ":");
        return Integer.parseInt(input);
    }
}

