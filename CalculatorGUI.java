import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel content = new JPanel(new GridLayout(1, 2));
        JTextField input1 = new JTextField("Number 1");
        JTextField input2 = new JTextField("Number 2");

        content.add(input1);
        content.add(input2);

        JPanel buttons = new JPanel(new GridLayout(1, 4));
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton multButton = new JButton("x");
        JButton divButton = new JButton("/");

        buttons.add(addButton);
        buttons.add(subButton);
        buttons.add(multButton);
        buttons.add(divButton);

        content.add(buttons);

        JLabel result = new JLabel("Result: ");
        result.setBorder(BorderFactory.createEmptyBorder(0, 7, 5, 0));

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stringNum1 = input1.getText().trim();
                double num1 = Double.parseDouble(stringNum1);
                String stringNum2 = input2.getText().trim();
                double num2 = Double.parseDouble(stringNum2);
                
                double calcResult = num1 + num2;
                String stringCalcResult = String.valueOf(calcResult);
                result.setText(stringCalcResult);
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stringNum1 = input1.getText().trim();
                double num1 = Double.parseDouble(stringNum1);
                String stringNum2 = input2.getText().trim();
                double num2 = Double.parseDouble(stringNum2);
                
                double calcResult = num1 - num2;
                String stringCalcResult = String.valueOf(calcResult);
                result.setText(stringCalcResult);
            }
        });

        multButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stringNum1 = input1.getText().trim();
                double num1 = Double.parseDouble(stringNum1);
                String stringNum2 = input2.getText().trim();
                double num2 = Double.parseDouble(stringNum2);
                
                double calcResult = num1 * num2;
                String stringCalcResult = String.valueOf(calcResult);
                result.setText(stringCalcResult);
            }
        });

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String stringNum1 = input1.getText().trim();
                double num1 = Double.parseDouble(stringNum1);
                String stringNum2 = input2.getText().trim();
                double num2 = Double.parseDouble(stringNum2);
                
                double calcResult = num1 / num2;
                String stringCalcResult = String.format("%.2f", calcResult);
                result.setText(stringCalcResult);
            }
        });
        
        frame.add(content, BorderLayout.CENTER);
        frame.add(result, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
