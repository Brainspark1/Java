import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

public class FlashcardApp extends JFrame {
    static class Flashcard {
        private final String outText;
        private final String hiddenText;
    
        Flashcard(String outText, String hiddenText) {
            this.outText = outText;
            this.hiddenText = hiddenText;
        }
    }

    static boolean isReviewMode = false;
    static int lastReviewCorrectCount = 0;
    static List<Flashcard> flashcards = new ArrayList<>();
    static List<Flashcard> knownFlashcards = new ArrayList<>();
    static List<Flashcard> wrongFlashcards = new ArrayList<>();
    static List<Flashcard> tempWrongFlashcards = new ArrayList<>();
    static JPanel flashcardText = new JPanel(new GridLayout(3,5));
    static JLabel outTextLabel = new JLabel("");
    static JLabel hiddenTextLabel = new JLabel("");
    static JPanel bottomTextPanel = new JPanel(new GridLayout(1, 3));
    static JButton revealHiddenTextButton = new JButton("Reveal Answer");
    static int currentCardIndex = 0;
    static JButton rightButton = new JButton("Know this!");
    static JButton wrongButton = new JButton("Need to review");
    static JPanel restartPanel = new JPanel(new GridLayout(1, 2));
    static JButton restartAllButton = new JButton("Restart Deck");
    static JButton restartWrongButton = new JButton("Review Unknown");

    public static void main(String[] args) {
        FlashcardApp app = new FlashcardApp();
        app.setTitle("Flaschard App");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(600, 400);
        app.setResizable(false);
        app.setLayout(new BorderLayout());

        JPanel addingInfo = new JPanel(new GridLayout(2, 4));
        JTextField outTextField = new JTextField("Enter the hint");
        JTextField hiddenTextField = new JTextField("Enter the answer");
        JButton addFlashcardButton = new JButton("Add Flashcard");
        JButton startQuizzingButton = new JButton("Start Deck");
        JButton clearAllFlashcards = new JButton("Clear Deck");

        addFlashcardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gottenOut = outTextField.getText();
                String gottenHidden = hiddenTextField.getText();
                app.flashcards.add(new Flashcard(gottenOut, gottenHidden));
            }
        });

        startQuizzingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!flashcards.isEmpty()) {
                    app.startNewQuiz();
                } else {
                    outTextLabel.setText("You currently have no cards in your deck.");
                }
            }
        });

        clearAllFlashcards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flashcards.clear();
            }
        });

        revealHiddenTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hiddenTextLabel.setForeground(new Color(0, 0, 0));
                hiddenTextLabel.setOpaque(true);

                rightButton.setForeground(new Color(0, 0, 0));
                rightButton.setOpaque(true);
                wrongButton.setForeground(new Color(0, 0, 0));
                wrongButton.setOpaque(true);
                revealHiddenTextButton.setForeground(new Color(0, 0, 0, 0));
                revealHiddenTextButton.setOpaque(false);
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isReviewMode) {
                    Flashcard current = wrongFlashcards.get(currentCardIndex);
                    knownFlashcards.add(current);
                    lastReviewCorrectCount++;
                } else {
                    Flashcard current = flashcards.get(currentCardIndex);
                    knownFlashcards.add(current);
                }

                currentCardIndex++;
                revealHiddenTextButton.setOpaque(true);

                if (isReviewMode) {
                    showWrongFlashcard();
                } else {
                    showFlashcard();
                }
            }
        });

        wrongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isReviewMode) {
                    Flashcard flashcard = wrongFlashcards.get(currentCardIndex);
                    tempWrongFlashcards.add(flashcard);
                } else {
                    Flashcard flashcard = flashcards.get(currentCardIndex);
                    wrongFlashcards.add(flashcard);
                }
                currentCardIndex++;
                revealHiddenTextButton.setOpaque(true);
                if (isReviewMode) {
                    app.showWrongFlashcard();
                } else {
                    app.showFlashcard();
                }
            }
        });

        restartWrongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.startNewWrongQuiz();
            }
        });

        restartAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                knownFlashcards.clear();
                wrongFlashcards.clear();
                lastReviewCorrectCount = 0;
                currentCardIndex = 0;
                startNewQuiz();
            }
        });

        addingInfo.add(outTextField);
        addingInfo.add(hiddenTextField);
        addingInfo.add(new JLabel(""));
        addingInfo.add(addFlashcardButton);
        addingInfo.add(startQuizzingButton);
        addingInfo.add(clearAllFlashcards);

        outTextLabel.setBorder(BorderFactory.createEmptyBorder(0, 9, 0, 0));
        hiddenTextLabel.setBorder(BorderFactory.createEmptyBorder(0, 9, 0, 0));
        hiddenTextLabel.setForeground(new Color(0, 0, 0, 0));
        revealHiddenTextButton.setForeground(new Color(0, 0, 0, 0));
        revealHiddenTextButton.setOpaque(false);
        rightButton.setForeground(new Color(0, 0, 0, 0));
        rightButton.setOpaque(false);
        wrongButton.setForeground(new Color(0, 0, 0, 0));
        wrongButton.setOpaque(false);

        flashcardText.add(outTextLabel);
        flashcardText.add(hiddenTextLabel);

        bottomTextPanel.add(revealHiddenTextButton);
        bottomTextPanel.add(rightButton);
        bottomTextPanel.add(wrongButton);

        restartPanel.add(restartWrongButton);
        restartPanel.add(restartAllButton);
        restartPanel.setVisible(false);

        flashcardText.add(restartPanel);

        app.add(addingInfo, BorderLayout.NORTH);
        app.add(flashcardText, BorderLayout.CENTER);
        app.add(bottomTextPanel, BorderLayout.SOUTH);
        app.setVisible(true);
    }

    private static void startNewQuiz() {
        Collections.shuffle(flashcards);
        revealHiddenTextButton.setForeground(new Color(0, 0, 0));
        restartPanel.setVisible(false);
        currentCardIndex = 0;
        knownFlashcards.clear();
        showFlashcard();
    }

    private void startNewWrongQuiz() {
        isReviewMode = true;
        currentCardIndex = 0;
        lastReviewCorrectCount = 0;
        Collections.shuffle(wrongFlashcards);
        restartPanel.setVisible(false);
        revealHiddenTextButton.setForeground(new Color(0, 0, 0));
        showWrongFlashcard();
    }

    private static void showFlashcard() {
        if (currentCardIndex >= flashcards.size()) {
            endFlashcards();
            return;
        }

        Flashcard flashcard = flashcards.get(currentCardIndex);
        outTextLabel.setText(flashcard.outText);
        hiddenTextLabel.setText(flashcard.hiddenText);

        hiddenTextLabel.setForeground(new Color(0, 0, 0, 0));
        rightButton.setForeground(new Color(0, 0, 0, 0));
        rightButton.setOpaque(false);
        wrongButton.setForeground(new Color(0, 0, 0, 0));
        wrongButton.setOpaque(false);

        revealHiddenTextButton.setForeground(new Color(0, 0, 0));
        revealHiddenTextButton.setOpaque(true);
    }

    private static void showWrongFlashcard() {
        if (currentCardIndex >= wrongFlashcards.size()) {
            wrongEndFlashcards();
            return;
        }

        Flashcard flashcard = wrongFlashcards.get(currentCardIndex);
        outTextLabel.setText(flashcard.outText);
        hiddenTextLabel.setText(flashcard.hiddenText);

        hiddenTextLabel.setForeground(new Color(0, 0, 0, 0));
        rightButton.setForeground(new Color(0, 0, 0, 0));
        rightButton.setOpaque(false);
        wrongButton.setForeground(new Color(0, 0, 0, 0));
        wrongButton.setOpaque(false);

        revealHiddenTextButton.setForeground(new Color(0, 0, 0));
        revealHiddenTextButton.setOpaque(true);
    }

    private static void endFlashcards() {
        int rightAnswers = knownFlashcards.size();
        int totalFlashcards = flashcards.size();

        outTextLabel.setText("Good job, you finished the deck, getting " + rightAnswers + " out of " + totalFlashcards + " correct!");
        restartPanel.setVisible(true);
        hiddenTextLabel.setText("");
        revealHiddenTextButton.setForeground(new Color(0, 0, 0, 0));
        rightButton.setForeground(new Color(0, 0, 0, 0));
        rightButton.setOpaque(false);
        wrongButton.setForeground(new Color(0, 0, 0, 0));
        wrongButton.setOpaque(false);
        isReviewMode = false;
    }

    private static void wrongEndFlashcards() {
        wrongFlashcards.removeAll(knownFlashcards);

        if (wrongFlashcards.isEmpty()) {
            outTextLabel.setText("🎉 You've mastered all the flashcards!");
        } else {
            int totalReviewed = lastReviewCorrectCount + wrongFlashcards.size();
            outTextLabel.setText("Great job, you got " + lastReviewCorrectCount + " out of " + totalReviewed + " correct!");
        }

        restartPanel.setVisible(true);
        hiddenTextLabel.setText("");

        revealHiddenTextButton.setForeground(new Color(0, 0, 0, 0));
        rightButton.setForeground(new Color(0, 0, 0, 0));
        rightButton.setOpaque(false);
        wrongButton.setForeground(new Color(0, 0, 0, 0));
        wrongButton.setOpaque(false);

        isReviewMode = false;
    }
}
