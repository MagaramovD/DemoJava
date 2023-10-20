import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

public class GuessNumberClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        String apiUrl = "http://localhost:8080/api/guess-number/guess"; 

        System.out.println("Welcome to Guess the Number Game!");

        while (true) {
            System.out.print("Enter your guess (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int guess = Integer.parseInt(input);
                ResponseEntity<String> response = restTemplate.getForEntity(apiUrl + "?number=" + guess, String.class);
                String result = response.getBody();
                System.out.println(result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
