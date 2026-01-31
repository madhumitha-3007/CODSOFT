import java.util.Scanner;

public class GradeCalculator {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int totalMarks = calculateTotal(subjects);
        double average = (double) totalMarks / subjects;
        char grade = calculateGrade(average);

        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }

    static int calculateTotal(int subjects) {

        int total = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();
            total += marks;
        }

        return total;
    }

    static char calculateGrade(double average) {

        if (average >= 90) {
            return 'A';
        } 
        else if (average >= 75) {
            return 'B';
        } 
        else if (average >= 60) {
            return 'C';
        } 
        else if (average >= 50) {
            return 'D';
        } 
        else {
            return 'F';
        }
    }
}
