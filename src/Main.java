import services.*;
import utils.*;
import java.util.Scanner;

public class Main {
    private static StudentService studentService = new StudentService();
    private static GradeService gradeService = new GradeService();
    private static ReportService reportService = new ReportService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== Student Grade Management System ===\n");
        
        // Load existing data
        studentService.loadData();
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    addGrade();
                    break;
                case 4:
                    viewStudentReport();
                    break;
                case 5:
                    viewClassStatistics();
                    break;
                case 6:
                    studentService.saveData();
                    System.out.println("Data saved. Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Add Grade for Student");
        System.out.println("4. View Student Report");
        System.out.println("5. View Class Statistics");
        System.out.println("6. Save and Exit");
    }
    
    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        if (!Validator.isValidId(id)) {
            System.out.println("Error: Invalid ID format.");
            return;
        }
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        
        if (!Validator.isValidName(name)) {
            System.out.println("Error: Invalid name.");
            return;
        }
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        if (studentService.addStudent(id, name, email)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Error: Student with this ID already exists.");
        }
    }
    
    private static void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        studentService.displayAllStudents();
    }
    
    private static void addGrade() {
        System.out.println("\n--- Add Grade ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();
        
        double score = getDoubleInput("Enter Score (0-100): ");
        
        if (!Validator.isValidGrade(score)) {
            System.out.println("Error: Grade must be between 0 and 100.");
            return;
        }
        
        if (gradeService.addGrade(studentService, id, subject, score)) {
            System.out.println("Grade added successfully!");
        } else {
            System.out.println("Error: Student not found.");
        }
    }
    
    private static void viewStudentReport() {
        System.out.println("\n--- Student Report ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        reportService.generateStudentReport(studentService, id);
    }
    
    private static void viewClassStatistics() {
        System.out.println("\n--- Class Statistics ---");
        reportService.generateClassStatistics(studentService);
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Invalid input. " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
    
    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("Invalid input. " + prompt);
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return value;
    }
}