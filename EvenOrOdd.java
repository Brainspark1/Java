import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("What number would you like to check? (or type 'exit' to escape): ");
            String inputNumberString = scanner.nextLine();
            
            if (inputNumberString.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                try {
                double inputNumber = Double.parseDouble(inputNumberString);
                if (inputNumber % 2 == 0) {
                    System.out.println(inputNumberString + " is even!");
                } else {
                    System.out.println(inputNumberString + " is odd!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer, or type 'exit' to escape.");
            }
            }
        }

        scanner.close();
    }
}
