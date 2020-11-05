package Walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phonenumberCombinations_leetcode17 {
	
	
	static Map<Character, String> numMap;
    
    public static List<String> letterCombinations(String digits) {
        
    	
    	/*
    	 * Time complexity: O(3^N * 4^M). where N is numbers in input with 3 letter mappings (e.g. 2, 3, 4 etc.) 
    	 *                  and M is numbers with 4 letter mappings (e.g. 7, 9 )
    	 * 
    	 * eg: 23
    	 * 
    	 * N = 2 (2 and 3 both have 3 letter mapping)
    	 * M = 0 (no 4 letter mapping)
    	 * 
    	 * Hence, time complexity : 3^2 * 4^0 = 9. 9 is the total number of combinations executed and stored.
    	 * 
    	 * Space complexity: O(3^N * 4^M). To store 3^N * 4^M combinations/solutions.
    	 * 
    	 * */
        List<String> combinations = new ArrayList();
        
        if(digits.length() == 0)
            return combinations;
        
        numMap = new HashMap();
        
        numMap.put('2', "abc");
        numMap.put('3', "def");
        numMap.put('4', "ghi");
        numMap.put('5', "jkl");
        numMap.put('6', "mno");
        numMap.put('7', "pqrs");
        numMap.put('8', "tuv");
        numMap.put('9', "wxyz");
        
        
        backtrackCombinations(combinations, digits, "", 0, digits.length());
        
        return combinations;
        
        
    }
    
    public static void backtrackCombinations(List<String> combinations, String digits, String currString, int traversedIndex, int maxLen) {
        
        if(traversedIndex == maxLen) {
            combinations.add(currString);
            return;
        }
        
        String indexMapping = numMap.get(digits.charAt(traversedIndex));
        
        for(int i=0; i<indexMapping.length(); i++) {
            backtrackCombinations(combinations, digits, currString + indexMapping.charAt(i), traversedIndex+1, maxLen);
        }
        
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> combinations = letterCombinations("23");
		
		System.out.println(combinations);
		
	}

}
