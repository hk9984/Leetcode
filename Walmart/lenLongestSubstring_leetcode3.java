package Walmart;

import java.util.HashMap;
import java.util.Map;

public class lenLongestSubstring_leetcode3 {
	
	public static int lengthOfLongestSubstring(String s) {
		
		/*
		 * Time Complexity: O(n). Iterating through each element once; index j iterates n times
		 * Space Complexity: O(min(m,n)). where n is size of string, and m is size of charset
		 * */
		
		int sLen = s.length();
		
		if(sLen < 2)
			return sLen;
		
		
		// Hashmap which stores the characters and their indices
		Map<Character, Integer> charMap = new HashMap();
		
		char[] sArr = s.toCharArray();
		String lsubstring = "";
		
		int maxLen = 0;
		for(int i=0, j=0; j < sLen; j++) {
			
			//if found in hashmap that value,then update i i.e maximum of (current i and pointer to the right of the same character last found)
			if(charMap.containsKey(sArr[j])) {
				//take the example of "wpxpwew" to understand why i is taken as max of those 2 values and not just +1 to the character found
				//i.e. in case of 2 characters found, and you have already jumped to the front of the character found right now, then i just stick to wherever it is, and
				// does not go backwards.
				
				i = Math.max(i, charMap.get(sArr[j]) + 1);
				
			}
			
			
			charMap.put(sArr[j], j);
			if((j-i+1) > maxLen) {
				maxLen = j-i+1;
				lsubstring = s.substring(i,j+1);
			}
		}
		
		System.out.println("Longest substring w/o repeating characters: " + lsubstring);
		return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(lengthOfLongestSubstring("ababacxc"));

	}

}
