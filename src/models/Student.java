package models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private String email;
    private List<Grade> grades;
    
    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.grades = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Grade> getGrades() {
        return grades;
    }
    
    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }
    
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Grade grade : grades) {
            sum += grade.getScore();
        }
        return sum / grades.size();
    }
    
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Email: %s | Grades: %d", 
            studentId, name, email, grades.size());
    }
}