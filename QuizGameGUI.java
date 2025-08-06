import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;

public class QuizGameGUI extends JFrame {
    static class Question {
        String text;
        char answer;

        Question(String text, char answer) {
            this.text = text;
            this.answer = answer;
        }
    }

    private List<Question> allQuestions;
    private List<Question> quizQuestions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    static JLabel questionLabel;
    static JButton[] optionButtons = new JButton[4];
    static JLabel scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);

    public static void main(String[] args) {
        QuizGameGUI quiz = new QuizGameGUI();
        quiz.setTitle("Quiz Game");
        quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quiz.setSize(600, 300);
        quiz.setLocationRelativeTo(null);
        quiz.setLayout(new BorderLayout());

        questionLabel = new JLabel("Question goes here", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        questionLabel.setVerticalAlignment(SwingConstants.TOP);
        questionLabel.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));
        quiz.add(questionLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        String[] labels = {"A", "B", "C", "D"};
        for (int i = 0; i < 4; i++) {
            int index = i;
            quiz.optionButtons[i] = new JButton(labels[i]);
            quiz.optionButtons[i].addActionListener(e -> quiz.handleAnswer(labels[index].charAt(0)));
            buttonPanel.add(quiz.optionButtons[i]);
        }
        quiz.add(buttonPanel, BorderLayout.CENTER);

        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(3, 0, 6, 0));
        quiz.add(scoreLabel, BorderLayout.SOUTH);

        quiz.setupQuestions();
        quiz.startNewQuiz();
        quiz.setVisible(true);
    }

    private void setupQuestions() {
        allQuestions = new ArrayList<>(List.of(
            new Question("What is the capital of France?\nA. Paris\nB. London\nC. Berlin\nD. Madrid", 'A'),
            new Question("How many states are in the US?\nA. 50\nB. 52\nC. 48\nD. 49", 'A'),
            new Question("Red planet?\nA. Earth\nB. Mars\nC. Venus\nD. Jupiter", 'B'),
            new Question("Who wrote Romeo and Juliet?\nA. Dickens\nB. Poe\nC. Shakespeare\nD. Twain", 'C'),
            new Question("Largest mammal?\nA. Elephant\nB. Whale\nC. Giraffe\nD. Hippo", 'B'),
            new Question("Gas plants use?\nA. Oxygen\nB. Carbon Dioxide\nC. Hydrogen\nD. Nitrogen", 'B'),
            new Question("Spider legs?\nA. 6\nB. 8\nC. 10\nD. 12", 'B'),
            new Question("H2O is?\nA. Salt\nB. Oxygen\nC. Water\nD. CO2", 'C'),
            new Question("Language with most speakers?\nA. English\nB. Spanish\nC. Hindi\nD. Mandarin", 'D'),
            new Question("Organ that pumps blood?\nA. Brain\nB. Lung\nC. Heart\nD. Kidney", 'C'),
            new Question("WW2 end year?\nA. 1945\nB. 1944\nC. 1939\nD. 1942", 'A'),
            new Question("Painted Mona Lisa?\nA. Van Gogh\nB. Picasso\nC. Da Vinci\nD. Michelangelo", 'C'),
            new Question("Square root of 49?\nA. 6\nB. 7\nC. 8\nD. 9", 'B'),
            new Question("Longest river?\nA. Nile\nB. Amazon\nC. Yangtze\nD. Mississippi", 'A'),
            new Question("Most populated country?\nA. India\nB. USA\nC. China\nD. Indonesia", 'A'),
            new Question("Continents?\nA. 5\nB. 6\nC. 7\nD. 8", 'C'),
            new Question("Element symbol O?\nA. Oxygen\nB. Gold\nC. Silver\nD. Iron", 'A'),
            new Question("Minutes in an hour?\nA. 30\nB. 45\nC. 60\nD. 90", 'C'),
            new Question("Animal that barks?\nA. Cat\nB. Bird\nC. Dog\nD. Horse", 'C'),
            new Question("9 x 9?\nA. 72\nB. 81\nC. 91\nD. 99", 'B')
        ));
    }

    private void startNewQuiz() {
        Collections.shuffle(allQuestions);
        quizQuestions = allQuestions.subList(0, 5);
        score = 0;
        scoreLabel.setText("Score:" + score);
        currentQuestionIndex = 0;
        showQuestion();
    }

    private void showQuestion() {
        if (currentQuestionIndex >= quizQuestions.size()) {
            showFinalScore();
            return;
        }

        Question q = quizQuestions.get(currentQuestionIndex);
        questionLabel.setText("<html><div style='text-align: center;'>" + q.text.replace("\n", "<br>") + "</div></html>");
    }

    private void handleAnswer(char selected) {
        Question question = quizQuestions.get(currentQuestionIndex);
        if (selected == question.answer) {
            score++;
            scoreLabel.setText("Score: " + score);
        }
        currentQuestionIndex++;
        showQuestion();
    }

    private void showFinalScore() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "You scored " + score + " out of 5!\nDo you want to play again?",
                "Quiz Over",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            startNewQuiz();
        } else {
            System.exit(0);
        }
    }

}