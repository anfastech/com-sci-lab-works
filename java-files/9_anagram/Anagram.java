
/**
 * -------------------------
 * CLASS DIAGRAM:
 * -------------------------
 * Anagram
 * -------------------------
 * -str1 : String
 * -str2 : String
 * +checkAnagram() : boolean
 * +main(args : String[]) : void
 * -------------------------
 */

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            System.out.println("String, aren't anagrams");
        } else {
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            boolean IsAnagram = true;

            for (int i=0; i<charArray1.length; i++) {
                if (charArray1[i] != charArray2[i]) {
                    IsAnagram = false;
                    break;
                }
            } 

            if (IsAnagram) {
                System.out.println("Strings are anagrams.");
            } else {
                System.out.println("Strings are not anagrams.");
            }
        }

        sc.close();
    }
}
