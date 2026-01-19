/**
 * HcfLcmFinder.java
 * This program calculates the Highest Common Factor (HCF) and 
 * the Least Common Multiple (LCM) of two hardcoded numbers 
 * using the most basic, direct methods.
 */
public class HcfLcmFinder {

    /**
     * Finds the Greatest Common Divisor (GCD) or Highest Common Factor (HCF) 
     * by checking all numbers from 1 up to the smaller of the two inputs (Brute-Force Method).
     * @param a The first number.
     * @param b The second number.
     * @return The GCD of a and b.
     */
    public static int findGCD(int a, int b) {
        int hcf = 1; // HCF is at least 1
        
        // Find the smaller number to set the limit for the loop
        int limit = (a < b) ? a : b;
        
        // Loop from 1 up to the smaller number
        for (int i = 1; i <= limit; i++) {
            // If 'i' divides both 'a' and 'b' exactly, it is a common factor.
            // Since we are looping upwards, the last common factor found is the greatest one.
            if (a % i == 0 && b % i == 0) {
                hcf = i;
            }
        }
        return hcf;
    }

    /**
     * Finds the Least Common Multiple (LCM) using the simple formula:
     * LCM(a, b) = (|a * b|) / HCF(a, b).
     * @param a The first number.
     * @param b The second number.
     * @param hcf The pre-calculated HCF of a and b.
     * @return The LCM of a and b as a long value.
     */
    public static long findLCM(int a, int b, int hcf) {
        // LCM = (a * b) / HCF. Using long to prevent overflow during multiplication.
        // Math.abs ensures the result is positive.
        return Math.abs((long) a * b) / hcf;
    }

    public static void main(String[] args) {
        // Define the two numbers directly
        int number1 = 48; 
        int number2 = 18; 
        
        System.out.println("Finding HCF and LCM for: " + number1 + " and " + number2);
        
        // 1. Calculate HCF
        int hcf = findGCD(number1, number2);
        
        // 2. Calculate LCM using the HCF result
        long lcm = findLCM(number1, number2, hcf);

        System.out.println("\n------------------------------------");
        System.out.println("Highest Common Factor (HCF/GCD): " + hcf);
        System.out.println("Least Common Multiple (LCM): " + lcm);
        System.out.println("------------------------------------");
    }
}
