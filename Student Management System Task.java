import java.util.ArrayList;
import java.util.Scanner;

public class SchoolManagementApp {

    public static void main(String[] args) {
        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem();
        schoolManagementSystem.run();
    }
}

class SchoolManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    public SchoolManagementSystem() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            displayMenu();
            int option = getOptionFromUser();

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting School Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nSchool Management System Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
    }

    private int getOptionFromUser() {
        System.out.print("Choose an option (1-5): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid option.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter student roll number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll number must be an integer.");
            System.out.print("Enter student roll number: ");
            scanner.next(); // Consume invalid input
        }
        int rollNumber = scanner.nextInt();

        System.out.print("Enter student grade: ");
        String grade = scanner.next();

        Student newStudent = new Student(name, rollNumber, grade);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    private void removeStudent() {
        System.out.print("Enter roll number of the student to remove: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll number must be an integer.");
            System.out.print("Enter roll number of the student to remove: ");
            scanner.next(); // Consume invalid input
        }
        int rollNumber = scanner.nextInt();

        students.removeIf(student -> student.getRollNumber() == rollNumber);
        System.out.println("Student removed successfully.");
    }

    private void searchStudent() {
        System.out.print("Enter roll number of the student to search: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Roll number must be an integer.");
            System.out.print("Enter roll number of the student to search: ");
            scanner.next(); // Consume invalid input
        }
        int rollNumber = scanner.nextInt();

        Student foundStudent = students.stream()
                .filter(student -> student.getRollNumber() == rollNumber)
                .findFirst()
                .orElse(null);

        if (foundStudent != null) {
            System.out.println("Student found:\n" + foundStudent);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displayAllStudents() {
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}
