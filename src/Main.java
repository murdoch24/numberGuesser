import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        guessNumberGame();

        while (true) {

            System.out.println("Do you want to play again? Y or N: ");
            Scanner scan = new Scanner(System.in);
            String userAnswer = scan.nextLine();

            if (userAnswer.equals("N") || userAnswer.equals("n")) {
                break;
            } else if (userAnswer.equals("Y") || userAnswer.equals("y")) {
                guessNumberGame();


            } else {
                System.out.println("Error: Type Y or N");
            }

        }


    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void guessNumberGame() {
        int ranInt = getRandomNumber(1, 101);
        int lives = 10;
        int guesses = 0;
        boolean isGameOn = true;


        System.out.println("I'm thinking of a number between 1 and 100 ");
        System.out.print("You have ");
        System.out.print(lives);
        System.out.print(" lives! Can you read my mind? ");


        while (isGameOn) {
            System.out.println("Enter guess: ");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            if (userInput == ranInt) {
                System.out.print("Congratulations you guessed the correct number: ");
                System.out.print(ranInt);
                System.out.println(" You're a mind reader");
                isGameOn = false;


            }

            if (userInput > ranInt) {
                System.out.println("Too high - guess again.");
                guesses += 1;
                System.out.print("Lives left: ");
                System.out.println(lives - guesses);
            }

            if (userInput < ranInt) {
                System.out.println("Too low - guess again.");
                guesses += 1;
                System.out.print("Lives left: ");
                System.out.println(lives - guesses);

            }

            if (guesses >= lives) {
                isGameOn = false;
                System.out.println("You ran out of lives! Game Over!");
                System.out.print("The number was ");
                System.out.println(ranInt);
            }


        }

    }
}
