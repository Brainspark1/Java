import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        String input = scanner.nextLine();
        long inputNumber = Long.parseLong(input);
        long factorial = 1;

        for (int i = 1; i <= inputNumber; i++) {
            factorial *= i;
        }

        System.out.println(input + "! = " + factorial);

        scanner.close();
    }
}
