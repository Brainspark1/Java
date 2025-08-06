import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int randomInt = (int)(Math.random() * 11);
        String randomIntString = String.valueOf(randomInt);

        System.out.println("Choose a number between 0 and 10");
        String userChoice = scanner.nextLine();
        if (userChoice.equals(randomIntString)) {
            System.out.println("You got it right!");
        } else {
            System.out.println("Incorrect! It was " + randomIntString + ".");
        }

        scanner.close();
    }
}
