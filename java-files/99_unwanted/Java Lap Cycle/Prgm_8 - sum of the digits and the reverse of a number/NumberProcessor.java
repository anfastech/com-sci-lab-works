/**
 * NumberProcessor.java
 * This program finds the sum of the digits and the reverse of a number 
 * using a single, simple main method (procedural approach).
 */
public class NumberProcessor {

    public static void main(String[] args) {
        // The number we want to process
        int originalNumber = 98765;
        
        // Variables for calculation
        int tempNumber = originalNumber; // Use a temporary variable for manipulation
        int sumOfDigits = 0;
        int reversedNumber = 0;
        
        System.out.println("Processing Number: " + originalNumber);
        System.out.println("================================");

        // Loop continues until the number is reduced to 0
        while (tempNumber > 0) {
            // 1. Find the last digit
            int digit = tempNumber % 10; 
            
            // 2. Calculate the Sum
            sumOfDigits += digit;
            
            // 3. Calculate the Reverse
            // Shift existing reversed digits one place left (x10) and add the new digit
            reversedNumber = reversedNumber * 10 + digit;
            
            // 4. Remove the last digit
            tempNumber /= 10; 
        }

        System.out.println("Sum of Digits: " + sumOfDigits); 
        System.out.println("Reverse of Number: " + reversedNumber); 
    }
}
