import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        boolean isPrime = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to check: ");
        int inputNum = scanner.nextInt();

        if (inputNum == 1) {
            isPrime = false;
        } else if (inputNum == 2) {
            isPrime = true;
        } else if (inputNum % 2 == 0) {
            isPrime = false;
        } else if (inputNum < 1) {
            System.out.println("Please enter a positive integer value.");
        } else {
            for (int i = 3; i <= Math.pow(inputNum, 0.5); i += 2) {
                if (inputNum % i == 0) {
                    isPrime = false;
                }
            }
        }

        if (isPrime == true) {
            System.out.println(inputNum + " is prime!");
        } else {
            System.out.println(inputNum + " is not prime!");
        }
    }
}
