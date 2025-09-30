/**
 * Antics provides methods for analyzing and manipulating strings.
 * <p>
 * It includes the following methods:
 * <ul>
 *   <li><b>isPalindrome</b>: Checks if a string is a palindrome (ignores case).</li>
 *   <li><b>isAbecedarian</b>: Checks if a string’s characters are in alphabetical order (ignores case).</li>
 *   <li><b>isPangram</b>: Checks if a string contains every letter of the alphabet (ignores case).</li>
 *   <li><b>capitalizeFirstLetter</b>: Capitalizes the first letter of a string.</li>
 * </ul>
 * <p>
 * Example usage:
 * <pre>
 *     StringUtils.isPalindrome("Racecar");         // true
 *     StringUtils.isAbecedarian("almost");         // true
 *     StringUtils.isPangram("The quick brown fox jumps over the lazy dog"); // true
 *     StringUtils.capitalizeFirstLetter("java");   // "Java"
 * </pre>
 * 
 * @author Huilin Reid
 * @author Thayssa De Moura
 * @since 09-26-2025
 */
//test

import java.util.HashSet;
import java.util.Set;

public class Antics {
    /**
     * This method checks if the given string is a palindrome.
     * A palindrom word reads the same forwards and backwards (ignoring case).
     * Examples: Abba, Anna, civic, kayak, level, noon, racecar, radar, refer, rotator.
     * 
     * @param str the input string to be checked
     * @return true if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase(); // ignore case
        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * This method checks if the given string is abecedarian.
     * Basically, it checks if the characters in the given string are in alphabetical order.
     * This method ignores case.
     * A word is abecedarian if its letters are arranged in alphabetically.
     * Examples: accent, access, almost, below, biopsy.
     * 
     * @param str the input string to be checked
     * @return true if the string is abecedarian (alphabetically ordered), false otherwise.
     */
    public static boolean isAbecedarian(String str) {
        str = str.toLowerCase(); // ignore case
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) > str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This mathod checks if the given string is a pangram.
     * A pangram is a sentence that contains all 26 letters of the alphabet.
     * That is contains every letter of the alphabet at least once.
     * This method ignores case and non-letter characters.
     * Example: The quick brown fox jumps over the lazy dog. 
     * 
     * @param str the input string to be checked
     * @return true if the string is a pangram, false otherwise.
    */
    public static boolean isPangram(String str) {
        str = str.toLowerCase(); // ignore case
        Set<Character> letters = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                letters.add(ch);
            }
        }   
        return letters.size() == 26;
    }

    /**
     * This method capitalizes the first letter of the input string.
     * If the string is empty or null, it returns the original string.
     * Example: california -> California
     * 
     * @param str the input string (its first letter to be capitalized).
     * @return the same string with its first letter (only) capitalized
     */
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str; // handle empty or null input
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("RaceCar")); // true
        System.out.println(isAbecedarian("almost")); // true
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(capitalizeFirstLetter("california")); // California
    }
}
