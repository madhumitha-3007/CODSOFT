import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {

        loadFromFile();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: editStudent(); break;
                case 3: removeStudent(); break;
                case 4: searchStudent(); break;
                case 5: displayStudents(); break;
                case 6: saveToFile(); System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 6);

        sc.close();
    }

    // Add Student
    static void addStudent() {
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        if (name.isEmpty() || grade.isEmpty()) {
            System.out.println("Fields cannot be empty.");
            return;
        }

        students.add(new Student(name, roll, grade));
        System.out.println("Student added successfully.");
    }

    // Edit Student
    static void editStudent() {
        System.out.print("Enter roll number to edit: ");
        int roll = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getRollNo() == roll) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new grade: ");
                s.setGrade(sc.nextLine());
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Remove Student
    static void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int roll = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getRollNo() == roll) {
                it.remove();
                System.out.println("Student removed.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search Student
    static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.getRollNo() == roll) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Display Students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // File Handling
    static void saveToFile() {
        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }

    static void loadFromFile() {
        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {
            students = new ArrayList<>();
        }
    }
}
