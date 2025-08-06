import java.util.ArrayList;
import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> vowels = new ArrayList<>();
        long numVowels = 0;

        System.out.println("Enter your word: ");
        String input = scanner.nextLine();

        if (input.contains("a") || input.contains("A")) {
            vowels.add('a');
            numVowels += 1;
        }

        System.out.println(numVowels);
    }
}
