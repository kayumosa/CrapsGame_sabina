import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("Rolling the dice...");
            System.out.println("Die 1: " + die1 + " Die 2: " + die2 + " Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.println("Point is set to: " + point);
                boolean rolling = true;
                while (rolling) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Rolling again...");
                    System.out.println("Die 1: " + die1 + " Die 2: " + die2 + " Sum: " + sum);

                    if (sum == 7) {
                        System.out.println("You rolled a 7. You lose!");
                        rolling = false;
                    } else if (sum == point) {
                        System.out.println("You made your point! You win!");
                        rolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

