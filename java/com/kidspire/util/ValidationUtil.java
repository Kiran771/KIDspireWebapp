package com.kidspire.util;
import java.util.regex.Pattern;

import java.time.LocalDate;
import java.time.Period;

/**
 * Utility class for validating various input types.
 * Provides methods to validate strings, contact numbers, emails, passwords, dates, and experience values.
 */

public class ValidationUtil {
	
	
	
	/**
     * Checks if a string is null or empty after trimming whitespace
     * 
     * @param value the string to check
     * @return true if the string is null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    
    /**
     * Validates if a string contains only alphabetic characters
     * 
     * @param name the string to validate
     * @return true if the string is non-null and contains only letters, false otherwise
     */
    
    public static boolean isAlphaValue(String name) {
        return name!=null && name.matches("^[a-zA-Z]+$");
    }
    
    
    /**
     * Validates if a string starts with a letter and contains only alphanumeric characters.
     * 
     * @param value the string to validate
     * @return true if the string is non-null, starts with a letter, and contains only letters or digits, false otherwise
     */
    public static boolean isAlphanumericStartWithAlpha(String value) {
        return value != null && value.matches("^[a-zA-Z][a-zA-Z0-9]*$");
    }
    
    /**
     * Validates if a phone number starts with "98" and is exactly 10 digits long.
     * 
     * @param phoneNumber the phone number to validate
     * @return true if the phone number is non-null and matches the pattern, false otherwise
     */
    public static boolean isValidContact(String phoneNumber) {
    	return phoneNumber!=null && phoneNumber.matches("^98\\d{8}$");
    }
    
    /**
     * Validates if an email address follows a standard email format.
     * 
     * @param email the email address to validate
     * @return true if the email is non-null and matches the standard email pattern, false otherwise
     */
    
    public static boolean isVaildEmail(String email) {
        return email!=null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
    
    
    /**
     * Validates if a password meets complexity requirements:
     * At least 8 characters long
     * Contains at least one uppercase letter
     * Contains at least one digit
     * Contains at least one special character
     * 
     * @param password the password to validate
     * @return true if the password is non-null and meets the complexity requirements, false otherwise
     */
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password != null && password.matches(passwordRegex);
    }
    
    /**
     * Checks if a password matches a confirmation password
     * 
     * @param password the original password
     * @param confirmPassword the confirmation password
     * @return true if both passwords are non-null and match, false otherwise
     */
    
    public static boolean isValidConfirmPassword(String password,String confirmPassword) {
    	 return password != null && confirmPassword != null && password.equals(confirmPassword);
    }
    
    /**
     * Checks if a person is at least 18 years old based on their date of birth.
     * 
     * @param dob the date of birth to check
     * @return true if the date is non-null and the person is at least 18 years old, false otherwise
     */
    
    public static boolean isAgeAtLeast18(LocalDate dob) {
        if (dob == null) {
            return false;
        }
        LocalDate today = LocalDate.now();
        return Period.between(dob, today).getYears() >= 18;
    }
    
    /**
     * Validates if an experience value is between 1 and 20 years (inclusive).
     * 
     * @param experience the experience value to validate
     * @return true if the experience is between 1 and 20, false otherwise
     */
    
    public static boolean isValidExperience(int experience) {
        return experience >= 1 && experience <= 20;
    }
    
    
    /**
     * Validates if a string represents a valid experience value.
     * Attempts to parse the string as an integer and checks if it is between 1 and 20.
     * 
     * @param experienceTxt the string representing the experience value
     * @return true if the string is a valid integer and represents a valid experience, false otherwise
     */
    public static boolean validateExperienceInput(String experienceTxt) {
        try {
            int experience = Integer.parseInt(experienceTxt.trim());
            return isValidExperience(experience);

        } catch (NumberFormatException e) {
            return false;
        }
    }
    
     
}
