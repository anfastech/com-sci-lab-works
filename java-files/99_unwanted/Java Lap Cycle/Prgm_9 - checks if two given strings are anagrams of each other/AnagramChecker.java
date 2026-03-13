/**
 * AnagramChecker.java
 * This program checks if two given strings are anagrams of each other.
 * Anagrams are strings that contain the same characters with the same frequency.
 * The program uses the sorting method for checking, which is highly reliable.
 */
import java.util.Arrays;

public class AnagramChecker {

    /**
     * Checks if two strings are anagrams.
     * @param str1 The first string.
     * @param str2 The second string.
     * @return true if the strings are anagrams, false otherwise.
     */
    public static boolean isAnagram(String str1, String str2) {
        // Step 1: Handle null checks and remove spaces/convert to lowercase 
        // for a more robust check (e.g., "Clint Eastwood" vs "Old West Action").
        // For a basic check, we'll skip this, but it's good practice.
        String s1 = str1.replaceAll("\\s", "").toLowerCase();
        String s2 = str2.replaceAll("\\s", "").toLowerCase();

        // Step 2: Check length equality. If lengths differ, they cannot be anagrams.
        if (s1.length() != s2.length()) {
            return false;
        }

        // Step 3: Convert strings to character arrays
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        // Step 4: Sort the character arrays
        Arrays.sort(array1);
        Arrays.sort(array2);

        // Step 5: Compare the sorted arrays. If they are equal, the strings are anagrams.
        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {
        // We will test with hardcoded examples for simplicity.
        String word1 = "listen";
        String word2 = "silent";
        String word3 = "hello";
        String word4 = "world";

        // Test Case 1: True Anagrams
        System.out.println("Checking '" + word1 + "' and '" + word2 + "'...");
        if (isAnagram(word1, word2)) {
            System.out.println("Result: They ARE anagrams.");
        } else {
            System.out.println("Result: They are NOT anagrams.");
        }
        
        System.out.println("---------------------------");

        // Test Case 2: Not Anagrams
        System.out.println("Checking '" + word3 + "' and '" + word4 + "'...");
        if (isAnagram(word3, word4)) {
            System.out.println("Result: They ARE anagrams.");
        } else {
            System.out.println("Result: They are NOT anagrams.");
        }
    }
}
