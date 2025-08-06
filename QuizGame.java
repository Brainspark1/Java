import java.util.*;

public class QuizGame {
    static Scanner scanner = new Scanner(System.in);

    static class Question {
        String text;
        char answer;

        Question(String text, char answer) {
            this.text = text;
            this.answer = answer;
        }
    }

    public static void main(String[] args) {
        List<Question> allQuestions = new ArrayList<>(List.of(
            new Question("What is the capital of France?\nA. Paris\nB. London\nC. Berlin\nD. Madrid", 'A'),
            new Question("How many states are in the US?\nA. 50\nB. 52\nC. 48\nD. 49", 'A'),
            new Question("What planet is known as the Red Planet?\nA. Earth\nB. Mars\nC. Venus\nD. Jupiter", 'B'),
            new Question("Who wrote 'Romeo and Juliet'?\nA. Dickens\nB. Poe\nC. Shakespeare\nD. Twain", 'C'),
            new Question("What is the largest mammal?\nA. Elephant\nB. Whale\nC. Giraffe\nD. Hippo", 'B'),
            new Question("Which gas do plants breathe in?\nA. Oxygen\nB. Carbon Dioxide\nC. Hydrogen\nD. Nitrogen", 'B'),
            new Question("How many legs does a spider have?\nA. 6\nB. 8\nC. 10\nD. 12", 'B'),
            new Question("What is H2O?\nA. Salt\nB. Oxygen\nC. Water\nD. Carbon Dioxide", 'C'),
            new Question("Which language has the most native speakers?\nA. English\nB. Spanish\nC. Hindi\nD. Mandarin", 'D'),
            new Question("Which organ pumps blood?\nA. Brain\nB. Lung\nC. Heart\nD. Kidney", 'C'),
            new Question("In what year did WW2 end?\nA. 1945\nB. 1944\nC. 1939\nD. 1942", 'A'),
            new Question("Who painted the Mona Lisa?\nA. Van Gogh\nB. Picasso\nC. Da Vinci\nD. Michelangelo", 'C'),
            new Question("What’s the square root of 49?\nA. 6\nB. 7\nC. 8\nD. 9", 'B'),
            new Question("Which is the longest river?\nA. Nile\nB. Amazon\nC. Yangtze\nD. Mississippi", 'A'),
            new Question("Which country has the most people?\nA. India\nB. USA\nC. China\nD. Indonesia", 'A'),
            new Question("How many continents are there?\nA. 5\nB. 6\nC. 7\nD. 8", 'C'),
            new Question("Which element has symbol O?\nA. Oxygen\nB. Gold\nC. Silver\nD. Iron", 'A'),
            new Question("How many minutes in an hour?\nA. 30\nB. 45\nC. 60\nD. 90", 'C'),
            new Question("Which animal barks?\nA. Cat\nB. Bird\nC. Dog\nD. Horse", 'C'),
            new Question("What’s 9 x 9?\nA. 72\nB. 81\nC. 91\nD. 99", 'B')
        ));
        boolean playAgain = true;

        System.out.println("\nWelcome to the Quiz Game!");
        System.out.println("You will be asked a series of questions.");
        System.out.println("For each question, you will be given four options.");
        System.out.println("You will need to enter the letter of the option you think is correct.");
        System.out.println("Good luck!");
        System.out.println("\n");

        do {
            Collections.shuffle(allQuestions);

            int score = 0;
            List<Question> selectedQuestions = allQuestions.subList(0, 5);
            for (int i = 0; i < selectedQuestions.size(); i++) {
                if (askQuestion(selectedQuestions.get(i).text, selectedQuestions.get(i).answer)) {
                    score++;
                }
            }

            System.out.println("You got " + score + " out of " + selectedQuestions.size() + " correct!");
            System.out.println("Would you like to play again? (yes/no): ");
            String playAgainString = scanner.nextLine();
            playAgain = playAgainString.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing. Goodbye!");
    }

    public static boolean askQuestion(String question, char correctAnswer) {
        System.out.println(question);
        System.out.print("Your answer (A, B, C or D): ");
        String input = scanner.nextLine().toUpperCase();

        
        if (input.length() >= 2 || "ABCD".indexOf(input.charAt(0)) == -1) {
            System.out.print("Invalid input. Please enter A, B, C, or D: ");
            input = scanner.nextLine().toUpperCase();
        }

        while (input.length() == 0 || "ABCD".indexOf(input.charAt(0)) == -1) {
            System.out.print("Invalid input. Please enter A, B, C, or D: ");
            input = scanner.nextLine().toUpperCase();
        }

        char playerAnswer = input.charAt(0);
        return playerAnswer == correctAnswer;
    }
}