import java.util.Scanner;

public class AcademicResultProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        SubjectResultProcessor subjectResultProcessor = new SubjectResultProcessor(numberOfSubjects, scanner);
        int totalMarks = subjectResultProcessor.calculateTotalMarks();

        // Calculate average percentage
        double averagePercentage = subjectResultProcessor.calculateAveragePercentage();

        // Calculating Grade here
        char grade = calculateGrade(averagePercentage);

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

class SubjectResultProcessor {
    private int numberOfSubjects;
    private Scanner scanner;

    public SubjectResultProcessor(int numberOfSubjects, Scanner scanner) {
        this.numberOfSubjects = numberOfSubjects;
        this.scanner = scanner;
    }

    public int calculateTotalMarks() {
        int totalMarks = 0;
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int subjectMarks = scanner.nextInt();

           
            if (subjectMarks < 0 || subjectMarks > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                i--; // Retry for the same subject
                continue;
            }

            totalMarks += subjectMarks;
        }
        return totalMarks;
    }

    public double calculateAveragePercentage() {
        return (double) calculateTotalMarks() / numberOfSubjects;
    }
}
