import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>(); 
        boolean running = true;

        System.out.println("Welcome to the to-do list!");

        while (running) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a task");
            System.out.println("2. View all tasks");
            System.out.println("3. Delete a task");
            System.out.println("4. Exit");

            System.out.println("Enter your choice (1-4): ");
            String number = scanner.nextLine();

            if (number.equals("1")) {
                System.out.println("Enter the task you would like to add: ");
                String task = scanner.nextLine();
                tasks.add(task);
                System.out.println("Task added!");
            } else if (number.equals("2")) {
                if (tasks.isEmpty()) {
                    System.out.println("There are no tasks in your todo list.");
                } else {
                    System.out.println(tasks);
                }
            } else if (number.equals("3")) {
                System.out.println(tasks);
                System.out.println("Which of the above tasks in your todo list would you like to delete?");
                try {
                    int taskNumber = Integer.parseInt(scanner.nextLine());
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        String removed = tasks.remove(taskNumber - 1);
                        System.out.println("Deleted: " + removed);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, please enter a correct number");
                }
            } else if (number.equals("4")) {
                System.out.println("Goodbye, and thanks for using the todo list!");
                running = false;
            } else {
                System.out.println("Invalid input, please enter a number from 1-4 to select your chocie.");
            }
        }

        scanner.close();
    }

}
