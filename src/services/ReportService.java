package services;

import models.Student;
import models.Grade;
import java.util.Collection;

public class ReportService {
    
    public void generateStudentReport(StudentService studentService, String studentId) {
        Student student = studentService.getStudent(studentId);
        
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        
        System.out.println("\n========================================");
        System.out.println("Student Report");
        System.out.println("========================================");
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("----------------------------------------");
        
        if (student.getGrades().isEmpty()) {
            System.out.println("No grades recorded.");
        } else {
            System.out.println("Grades:");
            for (Grade grade : student.getGrades()) {
                System.out.println("  " + grade);
            }
            System.out.println("----------------------------------------");
            System.out.printf("Average: %.2f\n", student.calculateAverage());
        }
        System.out.println("========================================\n");
    }
    
    public void generateClassStatistics(StudentService studentService) {
        Collection<Student> allStudents = studentService.getAllStudents();
        
        if (allStudents.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        
        double totalAverage = 0;
        double highestAverage = Double.MIN_VALUE;
        double lowestAverage = Double.MAX_VALUE;
        String topStudent = "";
        int studentsWithGrades = 0;
        
        for (Student student : allStudents) {
            if (!student.getGrades().isEmpty()) {
                double avg = student.calculateAverage();
                totalAverage += avg;
                studentsWithGrades++;
                
                if (avg > highestAverage) {
                    highestAverage = avg;
                    topStudent = student.getName();
                }
                if (avg < lowestAverage) {
                    lowestAverage = avg;
                }
            }
        }
        
        System.out.println("\n========================================");
        System.out.println("Class Statistics");
        System.out.println("========================================");
        System.out.println("Total Students: " + allStudents.size());
        System.out.println("Students with Grades: " + studentsWithGrades);
        
        if (studentsWithGrades > 0) {
            System.out.printf("Class Average: %.2f\n", totalAverage / studentsWithGrades);
            System.out.printf("Highest Average: %.2f (%s)\n", highestAverage, topStudent);
            System.out.printf("Lowest Average: %.2f\n", lowestAverage);
        } else {
            System.out.println("No grades recorded yet.");
        }
        System.out.println("========================================\n");
    }
}