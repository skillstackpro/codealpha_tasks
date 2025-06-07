package StudentGradeTracker;

//package view;

import StudentGradeTracker.Student;
import StudentGradeTracker.GradeService;

import java.util.Scanner;

public class GradeView {
    private final GradeService service = new GradeService();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n📘 Student Grade Tracker");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Show Average Grade");
            System.out.println("4. Show Highest Grade");
            System.out.println("5. Show Lowest Grade");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 : addStudent();
                          break;
                case 2 : viewAllStudents();
                          break;
                case 3 :
                    System.out.println("Average Grade: " + service.calculateAverage());
                          break;
                case 4 : System.out.println("Highest Grade: " + service.getHighestGrade());
                          break;
                case 5 : System.out.println("Lowest Grade: " + service.getLowestGrade());
                          break;
                case 0 : {
                    System.out.println("Exiting...");
                          return;
                }
                default :
                    System.out.println("Invalid choice!");
                          break;
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter grade (0 to 100): ");
        double grade = scanner.nextDouble();

        service.addStudent(name, grade);
        System.out.println("Student added!");
    }

    private void viewAllStudents() {
        System.out.println("\nStudent Grades:");
        for (Student s : service.getAllStudents()) {
            System.out.println(s.getName() + " - " + s.getGrade());
        }
    }
}

