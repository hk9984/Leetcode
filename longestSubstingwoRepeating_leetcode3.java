package Coupang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class longestSubstingwoRepeating_leetcode3 {
	
	public static int brutelongestSubstring(String s) {
		
		/*
		 * ->Time Complexity: O(n^3)
		 * 
		 * ->Space Complexity: O(min(m,n)). We need O(k) space for checking a substring has no 
		 * duplicate characters, where k is the size of the Set. The size of the Set is upper bounded by the 
		 * size of the string 'n' and the size of the charset/alphabet 'm'. 
		 * */
		if(s.length() < 2)
			return s.length();
		
		int maxLen = 0;
		String lcs = "";
		
		for(int i=0; i<s.length(); i++) {
			for(int j=i+1; j<=s.length(); j++) {
				if(allUnique(s, i, j))
					//maxLen = Math.max(maxLen, (j-i));
					if(maxLen < j-i) {
						maxLen = j - i;
						lcs = s.substring(i,j);
					
					}
			}
		}
		System.out.print("Longest substring brute force: \"" + lcs + "\" with length: ");
		return maxLen;
		
	}
	
	public static boolean allUnique(String s, int start, int end) {
		char[] sArr = s.toCharArray();
		
		Set<Character> set = new HashSet();
		
		for(int i=start; i<end; i++) {
			if(set.contains(sArr[i]))
				return false;
			set.add(sArr[i]);
		}
		
		return true;
	}
	
	public static int slidingWindowlongestSubstring(String s) {
		
		/*
		 * ->Time Complexity: O(2n) = O(n). Worst case, each character visited twice by i and j
		 * 
		 * ->Space Complexity: O(min(m,n)). We need O(k) space for checking a substring has no 
		 * duplicate characters, where k is the size of the Set. The size of the Set is upper bounded by the 
		 * size of the string 'n' and the size of the charset/alphabet 'm'. 
		 * */
		
		if(s.length() < 2)
			return s.length();
		
		int maxLen = 0;
		Set<Character> set = new HashSet();
		String lcs = "";
		char[] sArr = s.toCharArray();
		
		for(int i=0, j=0; i<sArr.length && j<sArr.length;) {
			if(set.contains(sArr[j])) {
				set.remove(sArr[i]);
				i++;
			}
			else {
				set.add(sArr[j]);
				if((j-i+1) > maxLen) {
					lcs = s.substring(i, j+1);
					maxLen = j-i+1;
				}
				j++;
			}
		}
		System.out.print("\nLongest substring sliding window: \"" + lcs + "\" with length: ");
		return maxLen;
		
	}
	
	public static int optimizedSlidingWindow(String s) {
		
		/*
		 * ->Time Complexity: O(n). directly skip the i to the index next to the repeated character and
		 * updates the old index of repeated character to the index of j
		 * 
		 * ->Space Complexity: O(min(m,n)). We need O(k) space for checking a substring has no 
		 * duplicate characters, where k is the size of the Set. The size of the Set is upper bounded by the 
		 * size of the string 'n' and the size of the charset/alphabet 'm'. 
		 * */
		
		if(s.length() < 2)
			return s.length();
		
		int maxLen = 0;
		String lcs = "";
		HashMap<Character, Integer> charIndexMap = new HashMap();
		char[] sArr = s.toCharArray();
		
		for(int i=0, j=0; i<sArr.length && j<sArr.length; ) {
			if(charIndexMap.containsKey(sArr[j])) {
				i = Math.max(charIndexMap.get(sArr[j]) + 1, i);
			}
			
			charIndexMap.put(sArr[j], j);
			if(j-i+1 > maxLen) {
				maxLen = j-i+1;
				lcs = s.substring(i, j+1);
			}
			j++;
		}
		
		System.out.print("\nLongest substring optimized sliding window: \"" + lcs + "\" with length: ");
		return maxLen;
	}
		
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print(brutelongestSubstring("pwwkew"));
		System.out.print(slidingWindowlongestSubstring("pwwkew"));
		System.out.print(optimizedSlidingWindow("pwwkew"));

	}

}
