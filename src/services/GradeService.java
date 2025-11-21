package services;

import models.Grade;
import models.Student;

public class GradeService {
    
    public boolean addGrade(StudentService studentService, String studentId, 
                           String subject, double score) {
        Student student = studentService.getStudent(studentId);
        if (student == null) {
            return false;
        }
        
        Grade grade = new Grade(studentId, subject, score);
        student.addGrade(grade);
        return true;
    }
    
    public double calculateAverage(Student student) {
        return student.calculateAverage();
    }
}