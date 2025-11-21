package utils;

import models.Student;
import models.Grade;
import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String DATA_FILE = "data/students.txt";
    
    public void saveStudents(Map<String, Student> students) throws IOException {
        // Create data directory if it doesn't exist
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Student student : students.values()) {
                // Write student info
                writer.println("STUDENT:" + student.getStudentId() + "," + 
                             student.getName() + "," + student.getEmail());
                
                // Write grades
                for (Grade grade : student.getGrades()) {
                    writer.println("GRADE:" + grade.getSubject() + "," + grade.getScore());
                }
                writer.println("END");
            }
        }
    }
    
    public Map<String, Student> loadStudents() throws IOException {
        Map<String, Student> students = new HashMap<>();
        File file = new File(DATA_FILE);
        
        if (!file.exists()) {
            return students;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            Student currentStudent = null;
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("STUDENT:")) {
                    String[] parts = line.substring(8).split(",");
                    if (parts.length >= 3) {
                        currentStudent = new Student(parts[0], parts[1], parts[2]);
                        students.put(parts[0], currentStudent);
                    }
                } else if (line.startsWith("GRADE:") && currentStudent != null) {
                    String[] parts = line.substring(6).split(",");
                    if (parts.length >= 2) {
                        Grade grade = new Grade(currentStudent.getStudentId(), 
                                              parts[0], Double.parseDouble(parts[1]));
                        currentStudent.addGrade(grade);
                    }
                } else if (line.equals("END")) {
                    currentStudent = null;
                }
            }
        }
        
        return students;
    }
}