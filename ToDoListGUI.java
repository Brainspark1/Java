import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class ToDoListGUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DefaultListModel<String> taskListModel = new DefaultListModel<>();

        JFrame frame = new JFrame("To-do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JTextField taskField = new JTextField("Add task here");
        JButton addButton = new JButton("Add");
        JButton completeButton = new JButton("Complete/Delete");

        JList<String> taskList = new JList<>(taskListModel);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskField, BorderLayout.CENTER);

        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(completeButton);
        inputPanel.add(buttonPanel, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selected = taskList.getSelectedIndex();
                if (selected != -1) {
                    taskListModel.remove(selected);
                }
            }
        });

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
