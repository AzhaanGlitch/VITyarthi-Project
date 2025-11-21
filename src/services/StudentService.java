package services;

import models.Student;
import utils.FileHandler;
import java.util.*;

public class StudentService {
    private Map<String, Student> students;
    private FileHandler fileHandler;
    
    public StudentService() {
        this.students = new HashMap<>();
        this.fileHandler = new FileHandler();
    }
    
    public boolean addStudent(String id, String name, String email) {
        if (students.containsKey(id)) {
            return false;
        }
        Student student = new Student(id, name, email);
        students.put(id, student);
        return true;
    }
    
    public Student getStudent(String id) {
        return students.get(id);
    }
    
    public Collection<Student> getAllStudents() {
        return students.values();
    }
    
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
    
    public void loadData() {
        try {
            students = fileHandler.loadStudents();
            System.out.println("Data loaded successfully. Total students: " + students.size());
        } catch (Exception e) {
            System.out.println("No existing data found. Starting fresh.");
        }
    }
    
    public void saveData() {
        try {
            fileHandler.saveStudents(students);
            System.out.println("Data saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}