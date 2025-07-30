/*
 * 
 * 
 * Valid Palindrome
 * 
 * Given a string s, return true if it is a palindrome, otherwise return false.
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 * 
 * Example1: 
 * 
 * Input: s = "Was it a car or a cat I saw?"
 * Output: true
 * 
 * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
 * 
 * 
 * Example2: 
 * 
 * Input: s = "tab a cat"
 * Output: false
 * 
 * Explanation: "tabacat" is not a palindrome.
 * 
 * Constraints:
 * - 1 <= s.length <= 1000
 * - s is made up of only printable ASCII characters.
 * 
 */




package Leetcode.Neetcode150.TwoPointers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Solution: Two Pointers
 * 
 * Front and back pointer, iterating till front < back and matching character at front and back pointers. Whenever mismatch, return false. Check character at both pointers need to be alphanumeric
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ValidPalindrome {
    
    public boolean isPalindrome(String s) {

        if(s.length() <= 1)
            return true;
    
        s = s.toLowerCase();
        // Map<Character, Character> hmap = new HashMap<Character, Character>();

        int front = 0, back = s.length() - 1;

        while (front < back) {
            if(!Character.isLetterOrDigit(s.charAt(front))) {
                front++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(back))) {
                back--;
                continue;
            }

            if(s.charAt(front) != s.charAt(back))
                return false;
            else {
                front++;
                back--;
            }
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' || 
                c >= 'a' && c <= 'z' || 
                c >= '0' && c <= '9');
    }
}
