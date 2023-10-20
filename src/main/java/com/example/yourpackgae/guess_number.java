import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int secretNumber = random.nextInt(100) + 1; // Загадываем число от 1 до 100
        int attempts = 0;
        
        System.out.println("Guess the number!");
        System.out.println("I thought of a number from 1 to 100. Try to guess it.");
        
        while (true) {
            System.out.print("Enter your guess:");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess == secretNumber) {
                System.out.println("Congratulations, you guessed the number" + secretNumber + " с " + attempts + " attempts!");
                break;
            } else if (guess < secretNumber) {
                System.out.println("The hidden number is greater.");
            } else {
                System.out.println("The hidden number is smaller");
            }
        }
        
        scanner.close();
    }
}