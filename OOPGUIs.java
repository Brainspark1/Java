import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;
import javax.swing.*;

public class OOPGUIs {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Object-Oriented Programming GUIs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);

        frame.setLayout(new FlowLayout());

        JButton button1 = new JButton("Press Me");
        button1.setSize(200, 75);
        frame.getContentPane().add(button1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(new JLabel("Clicked!"));
                frame.repaint();
                frame.revalidate();
            }
        });

        JTextField inputField = new JTextField();
        inputField.setSize(200, 100);
        frame.getContentPane().add(inputField);

        frame.setVisible(true);
    }
}
