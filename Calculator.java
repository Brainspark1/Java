import java.util.Scanner;

class Operations {
    static void add(int a, int b) {
        System.out.println(a + b);
    }

    static void subtract(int a, int b) {
        System.out.println(a - b);
    }

    static void multiply(int a, int b) {
        System.out.println(a * b);
    }

    static void divide(int a, int b) {
        System.out.println(a / b);
    }
}

public class Calculator {
    public static void main(String[] args) {
        Operations operations = new Operations();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Number 1: ");
        int number = scanner.nextInt();
        System.out.println("Number 2: ");
        int number2 = scanner.nextInt();
        System.out.println("Operation: ");
        String symbol = scanner.next();
        
        if (symbol.equals("+")) {
            operations.add(number, number2);
        } else if (symbol.equals("-")) {
            operations.subtract(number, number2);
        } else if (symbol.equals("*")) {
            operations.multiply(number, number2);
        } else if (symbol.equals("/")) {
            operations.divide(number, number2);
        } else {
            System.out.println("Invalid arithemtic symbol, please try again.");
        }
    }
}
