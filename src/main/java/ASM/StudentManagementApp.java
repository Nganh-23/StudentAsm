package ASM;
import java.util.Scanner;
import java.util.Collections;


// Main program
// Chương trình chính
public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Student Management Program:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search for Student by ID");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit Program");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Skip the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = scanner.nextDouble();
                    manager.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    System.out.print("Enter Student ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    manager.editStudent(editId, newName, newMarks);
                    break;

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteStudent(deleteId);
                    break;

                case 4:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = manager.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student Information: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    manager.sortStudentsByMarks();
                    System.out.println("Students have been sorted by marks.");
                    break;

                case 6:
                    manager.displayAllStudents();
                    break;

                case 7:
                    isRunning = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}

