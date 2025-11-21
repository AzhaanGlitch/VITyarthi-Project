package utils;

public class Validator {
    
    public static boolean isValidId(String id) {
        return id != null && !id.trim().isEmpty() && id.length() <= 20;
    }
    
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 2;
    }
    
    public static boolean isValidGrade(double grade) {
        return grade >= 0 && grade <= 100;
    }
    
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
}