/**
 * VowelRemover.java 
 * This program demonstrates how to remove all vowels (a, e, i, o, u) 
 * from a given string using regular expressions. The input string is 
 * now taken from the command-line arguments.
 */
public class VowelRemover {

    public static void main(String[] args) {
        // --- 1. Check for command-line argument ---
        if (args.length == 0) {
            System.out.println("Error: Please provide a string as a command-line argument.");
            System.out.println("Usage: java VowelRemover \"Your String Here\"");
            return; // Exit the program if no argument is provided
        }

        // 2. Define the input string from the first command-line argument
        String originalString = args[0];
        
        // 3. Define the regular expression for all vowels (case-insensitive)
        // [aeiouAEIOU] matches 'a', 'e', 'i', 'o', 'u' in both lower and upper case.
        String regexVowels = "[aeiouAEIOU]";
        
        // 4. Use replaceAll() to replace all matches with an empty string ("")
        String stringWithoutVowels = originalString.replaceAll(regexVowels, "");
        
        // 5. Print the results
        System.out.println("Original String: " + originalString);
        System.out.println("String without Vowels: " + stringWithoutVowels);
    }
}
