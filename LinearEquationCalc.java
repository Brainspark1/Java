import java.util.Scanner;

public class LinearEquationCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double yValue;
        double xValue;

        System.out.println("Enter the slope of the line: ");
        double slope = scanner.nextDouble();
        System.out.println("Enter the y-intercept of the function: ");
        double intercept = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter the information you know (either x or y, no spaces): ");
        String xOrY = scanner.nextLine();

        if (!xOrY.contains("=") || xOrY.length() < 3) {
            System.out.println("Invalid input format. Please use x=number or y=number.");
            return;
        }

        char first = xOrY.charAt(0);
        String valueStr = xOrY.substring(2);
        double value;
        try {
            value = Double.parseDouble(valueStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
            return;
        }

        switch (first) {
            case 'x':
                yValue = (slope * value) + intercept;
                System.out.println("If x = " + value + ", then y = " + yValue);
                break;
            case 'y':
                xValue = (value - intercept) / slope;
                System.out.println("If y = " + value + ", then x = " + xValue);
                break;
            default:
                throw new AssertionError();
        }
    }
}
