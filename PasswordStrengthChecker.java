import java.util.Scanner;

public class PasswordStrengthChecker {

    static boolean isRunning = true;

    static int numNums = 0;
    static int numUppercases = 0;
    static int numLowercases = 0;
    static int numSymbols = 0;

    static void runAgain() {
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {

            System.out.print("Enter your updated password: ");
            String userPassword = scanner.next();
            char[] characters = userPassword.toCharArray();

            for (Object object : characters) {
                if (object instanceof Character) {
                    char c = (Character) object;
                    if (Character.isDigit(c)) {
                        numNums++;
                    } else if (Character.isUpperCase(c)) {
                        numUppercases++;
                    } else if (Character.isLowerCase(c)) {
                        numLowercases++;
                    } else if (!Character.isLetterOrDigit(c)) {
                        numSymbols++;
                    }
                }
            }

            if (numNums < 2) {
                System.out.println("Your password needs at least 2 numbers to be strong.");
            } else if (numUppercases < 1) {
                System.out.println("Your password needs at least 1 uppercase letter to be strong.");
            } else if (numLowercases < 3) {
                System.out.println("Your password needs at least 3 lowercase letters to be strong.");
            } else if (numSymbols < 2) {
                System.out.println("Your password needs at least 2 symbols to be strong.");
            } else {
                System.out.println("Your password is very strong!");
                isRunning = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String userPassword = scanner.next();
        char[] characters = userPassword.toCharArray();

        for (Object object : characters) {
            if (object instanceof Character) {
                char c = (Character) object;
                if (Character.isDigit(c)) {
                    numNums++;
                } else if (Character.isUpperCase(c)) {
                    numUppercases++;
                } else if (Character.isLowerCase(c)) {
                    numLowercases++;
                } else if (!Character.isLetterOrDigit(c)) {
                    numSymbols++;
                }
            }
        }

        if (numNums < 2) {
            System.out.println("Your password needs at least 2 numbers to be strong.");
            runAgain();
        } else if (numUppercases < 1) {
            System.out.println("Your password needs at least 1 uppercase letter to be strong.");
            runAgain();
        } else if (numLowercases < 3) {
            System.out.println("Your password needs at least 3 lowercase letters to be strong.");
            runAgain();
        } else if (numSymbols < 2) {
            System.out.println("Your password needs at least 2 symbols to be strong.");
            runAgain();
        } else {
            System.out.println("Your password is very strong!");
        }
    }
}
