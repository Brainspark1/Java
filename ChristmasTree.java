import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for your Christmas tree: ");
        int rows = scanner.nextInt();

        int width = 2 * rows - 1;

        for (int i = 1; i <= rows; i++) {
            int numStars = 2 * i - 1;
            int numSpaces = (width - numStars) / 2;

            for (int j = 0; j < numSpaces; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < numStars; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < numSpaces; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }

        int trunkSpaces = (width - 1) / 2;
        for (int i = 0; i < trunkSpaces; i++) {
            System.out.print(" ");
        }
        System.out.println("*");

        scanner.close();
    }
}