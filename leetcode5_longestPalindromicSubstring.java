package Coupang;

import java.util.Scanner;

public class leetcode5_longestPalindromicSubstring {
	
	public static String longestPalinSubstr(String s) {
		
		if(s.length() < 2)
			return s;
		
		//start and end are boundaries of the LPS
		int start = 0;
		int end = 0;
		
		for(int i=0; i<s.length(); i++) {
			
			//checking for odd length palindromes like racecar
			int oddLength = expandFromMiddle(s, i, i);
			
			//checking for even length palindromes like aabbaa
			int evenLength = expandFromMiddle(s, i, i+1);
			
			int maxLen = Math.max(oddLength, evenLength);
			
			if(maxLen > end - start) {
				start = i - ((maxLen - 1) / 2);
				end = i + (maxLen / 2);
			}
		}
		
		return s.substring(start, end+1);
	}
	
	public static int expandFromMiddle(String s, int left, int right) {
		
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		return right - left - 1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(longestPalinSubstr("racecar"));
		System.out.println(longestPalinSubstr("aabbaa"));
		System.out.println(longestPalinSubstr("babad"));
		System.out.println(longestPalinSubstr("b"));
		System.out.println(longestPalinSubstr("cbbd"));
		Scanner sc = new Scanner(System.in);
		String test = sc.next();
		System.out.println(longestPalinSubstr(test));

	}

}
