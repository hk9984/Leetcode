package Walmart;

public class palindromicSubstring_leetcode647 {
	
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
public static int countSubstrings(String S) {
    int N = S.length(), ans = 0;
    for (int center = 0; center <= 2*N-1; ++center) {
        int left = center / 2;
        int right = left + center % 2;
        while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
            ans++;
            left--;
            right++;
        }
    }
    return ans;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countSubstrings("aabbaa"));
		
		

	}

}
