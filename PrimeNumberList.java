import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumberList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> primeNums = new ArrayList<>();

        System.out.println("First number of range: ");
        long firstNum = scanner.nextLong();
        System.out.println("Second number of range: ");
        long secondNum = scanner.nextLong();

        while (firstNum <= secondNum) {
            boolean isPrime = true;
            if (firstNum == 1) {
                isPrime = false;
            } else if (firstNum == 2) {
                isPrime = true;
            } else if (firstNum % 2 == 0) {
                isPrime = false;
            } else if (firstNum < 1) {
                System.out.println("Please enter a positive integer value.");
            } else {
                for (int i = 3; i <= Math.pow(firstNum, 0.5); i += 2) {
                    if (firstNum % i == 0) {
                       isPrime = false;
                    }
                }
            }

            if (isPrime == true) {
                primeNums.add(firstNum);
                firstNum += 1;
            } else {
                firstNum += 1;
            }
        }

        System.out.println(primeNums);

        scanner.close();
    }
}
