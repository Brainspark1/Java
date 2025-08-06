import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int computer = (int)(Math.random() * 3);
        String computerChoice;

        if (computer == 0) {
            computerChoice = "rock";
        } else if (computer == 1) {
            computerChoice = "paper";
        } else {
            computerChoice = "scissors";
        }

        System.out.println("What do you choose?: ");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("rock")) {
            if (computerChoice == "rock") {
                System.out.println("It's a tie!");
            } else if (computerChoice == "paper") {
                System.out.println("You lose!");
            } else {
                System.out.println("You win!");
            }
        } else if (userInput.equalsIgnoreCase("paper")) {
            if (computerChoice == "rock") {
                System.out.println("You win!");
            } else if (computerChoice == "paper") {
                System.out.println("It's a tie!");
            } else {
                System.out.println("You lose!");
            }
        } else if (userInput.equalsIgnoreCase("scissors")) {
            if (computerChoice == "rock") {
                System.out.println("It's a tie!");
            } else if (computerChoice == "paper") {
                System.out.println("You lose!");
            } else {
                System.out.println("You win!");
            }
        } else {
                System.out.println("PLease enter either 'rock', 'paper', or 'scissors'");
        }
    }
}
