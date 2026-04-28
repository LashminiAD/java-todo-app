import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n==== TO-DO LIST ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice;

            // ✅ Safe input for menu
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Please enter a number!");
                sc.next(); // clear invalid input
                continue;
            }

            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    tasks.add(task);
                    System.out.println("Task added!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to delete: ");

                    // ✅ Safe input for delete
                    if (sc.hasNextInt()) {
                        int index = sc.nextInt();

                        if (index > 0 && index <= tasks.size()) {
                            tasks.remove(index - 1);
                            System.out.println("Task deleted!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("Please enter a valid number!");
                        sc.next(); // clear invalid input
                    }

                    sc.nextLine(); // clear buffer
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
