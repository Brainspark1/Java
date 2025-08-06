import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RockPaperScissorsGUI {
    static boolean playerHasPlayed = false;
    static String playerChoice;

    static void afterPlayerChose(JLabel youPlayed, JLabel computerPlayed, JLabel result, String playerChoice) {
        String computerChoice = getRandomComputerChoice();
        String capitalizedChoice = computerChoice.substring(0, 1).toUpperCase() + computerChoice.substring(1);
        computerPlayed.setText("Computer played: " + capitalizedChoice);
        
        if (playerChoice.equalsIgnoreCase("rock")) {
            if (computerChoice.equals("rock")) {
                result.setText("It's a tie!");
            } else if (computerChoice.equals("paper")) {
                result.setText("You lose!");
            } else {
                result.setText("You win!");
            }
        } else if (playerChoice.equalsIgnoreCase("paper")) {
            if (computerChoice.equals("rock")) {
                result.setText("You win!");
            } else if (computerChoice.equals("paper")) {
                result.setText("It's a tie!");
            } else {
                result.setText("You lose!");
            }
        } else if (playerChoice.equalsIgnoreCase("scissors")) {
            if (computerChoice.equals("rock")) {
                result.setText("You lose!");
            } else if (computerChoice.equals("paper")) {
                result.setText("You win!");
            } else {
                result.setText("It's a tie!");
            }
        }
    }

    static String getRandomComputerChoice() {
        int rand = (int) (Math.random() * 3);
        if (rand == 0) return "rock";
        else if (rand == 1) return "paper";
        else return "scissors";
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rock Paper Scissors");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel choices = new JPanel(new GridLayout(1, 3));
        JButton rock = new JButton("Rock");
        JButton paper = new JButton("Paper");
        JButton scissors = new JButton("Scissors");
        JPanel texts = new JPanel(new GridLayout(3, 1));
        JLabel youPlayed = new JLabel();
        JLabel computerPlayed = new JLabel();
        JLabel result = new JLabel();

        choices.add(rock);
        choices.add(paper);
        choices.add(scissors);

        frame.add(choices, BorderLayout.NORTH);

        youPlayed.setBorder(BorderFactory.createEmptyBorder(0, 13, 0, 0));
        computerPlayed.setBorder(BorderFactory.createEmptyBorder(0, 13, 0, 0));
        result.setBorder(BorderFactory.createEmptyBorder(0, 13, 0, 0));

        rock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerChoice = "rock";
                playerHasPlayed = true;
                youPlayed.setText("You played: Rock");
                afterPlayerChose(youPlayed, computerPlayed, result, playerChoice);
            }
        });

        paper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerChoice = "paper";
                playerHasPlayed = true;
                youPlayed.setText("You played: Paper");
                afterPlayerChose(youPlayed, computerPlayed, result, playerChoice);
            }
        });

        scissors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerChoice = "scissors";
                playerHasPlayed = true;
                youPlayed.setText("You played: Scissors");
                afterPlayerChose(youPlayed, computerPlayed, result, playerChoice);
            }
        });

        texts.add(youPlayed);
        texts.add(computerPlayed);
        texts.add(result);
        frame.add(texts, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}