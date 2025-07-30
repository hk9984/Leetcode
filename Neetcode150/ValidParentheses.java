package Leetcode.Neetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* Valid Parentheses

 * You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
 * 
 * The input string s is valid if and only if:
 * 1. Every open bracket is closed by the same type of close bracket.
 * 2. Open brackets are closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 */


public class ValidParentheses {

    /*
     * Solution: Using stack to pop whenever closing bracket found. In the end, the stack should be empty
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) stack size depending on input
     */

    public boolean isValid(String s) {

        if(s.length() <= 1)
                return false;

        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> charMap = new HashMap<Character, Character>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');
        List<Integer> minstack = new ArrayList<>();

        
        
        
        

        

        if(!charMap.containsKey(s.charAt(0)))
            return false;

        for(char letter: s.toCharArray()) {
            if(charMap.containsKey(letter)) {
                stack.push(letter);
            }
            else {
                if(!stack.isEmpty() && letter == charMap.get(stack.peek()))
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    
}
