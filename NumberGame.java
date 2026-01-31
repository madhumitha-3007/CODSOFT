45import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        int score = 0;
        char play;

        do {
            boolean won = playGame();

            if (won) {
                score++;
            }

            System.out.print("Do you want to play again (y/n): ");
            play = sc.next().charAt(0);

        } while (play == 'y' || play == 'Y');

        System.out.println("Game finished");
        System.out.println("Total score: " + score);

        sc.close();
    }

    static boolean playGame() {

        int number = random.nextInt(100) + 1;
        int maxAttempts = 5;

        System.out.println("\nGuess a number between 1 and 100");
        System.out.println("Maximum attempts: " + maxAttempts);

        for (int i = 1; i <= maxAttempts; i++) {

            System.out.print("Attempt " + i + " - Enter guess: ");
            int guess = sc.nextInt();

            if (guess == number) {
                System.out.println("Correct! You guessed it.");
                return true;
            } 
            else if (guess > number) {
                System.out.println("Guess is too high");
            } 
            else {
                System.out.println("Guess is too low");
            }
        }

        System.out.println("No attempts left");
        System.out.println("Correct number was: " + number);
        return false;
    }
}
