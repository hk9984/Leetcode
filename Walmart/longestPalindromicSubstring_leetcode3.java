package Walmart;

public class longestPalindromicSubstring_leetcode3 {
	
	/*
    Time Complexity: O(N^2), where N is length of string. Each expansion from centre might do O(N) work
    Process: centres of palindrome in a string are 2N-1, where string length is N.
    Because center either at the letter or between two letters
    
    Example:
    center : 0 1 2 3 4 5 6
    String : a   b   b   a
    Index  : 0   1   2   3
    
    
    Space Complexity: O(1)
    
    */
    public String longestPalindrome(String s) {
        
        int sLen = s.length();
        
        if(sLen < 2) {
            return (sLen == 1) ? ""+s.charAt(0) : "";
        }
        
        int centers = 2 * sLen - 1;
        
        int maxLength = Integer.MIN_VALUE;
        String longestPalindrome = "";
        
        char[] sArr = s.toCharArray();
        
        for(int i=0; i<centers; i++) {
            
            int left = i / 2;
            int right = left + (i%2);
            
            int length = 0;
            
            while(left >= 0 && right < sLen && sArr[left] == sArr[right]) {
                length+=2;
                left--;
                right++;
            }
            
            //if we need to take substring, left needs to be incremented as it would
            // have been decremented before inside the loop
            left++;
            
            //also, in case of an even center, the center would be at the letter.
            // Hence, at the first palindrome check, the length of palindrome would only
            // increase by 1
            if(i%2 == 0)
                length--;
            
            if(length > maxLength) {
                maxLength = length;
                longestPalindrome = s.substring(left, right);
            }
        }
        
        return longestPalindrome;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
