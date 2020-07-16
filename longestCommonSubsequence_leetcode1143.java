package Coupang;

public class longestCommonSubsequence_leetcode1143 {
	
	public static Integer[][] memo;
	
	public static int lcsRecursive(String text1, String text2) {
		
		if(text1 == "" || text2 == "")
			return 0;
		
		if(text1.equals(text2))
			return text1.length();
		
		return lcsRecursiveHelper(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
	}
	
	public static int lcsRecursiveHelper(char[] text1, char[] text2, int len1, int len2) {
		
		if(len1 == 0 || len2 == 0)
			return 0;
		
		else if(text1[len1-1] == text2[len2-1])
			return 1 + lcsRecursiveHelper(text1, text2, len1-1, len2-1);
		
		else {
			return Math.max(lcsRecursiveHelper(text1, text2, len1-1, len2), lcsRecursiveHelper(text1, text2, len1, len2-1));
		}
		
	}
	
	public static int lcsMemoization(String text1, String text2) {
		
		/*-> Time Complexity: O(M.N). Solving each subproblem has a cost of O(1). 
		 * 					  The input parameters to the recursive function are a pair of integers; 
		 * 					  representing a position in each string. There are M possible positions for the 
		 * 					  first string, and N for the second string. Therefore, this gives us (M.N) 
		 * 					  possible pairs of integers, and is the number of subproblems to be solved.
		 * 					  As there are M.N subproblems, and so we get a total time complexity of O(M.N) 
		 * 
		 *-> Space Complexity: O(M.N), storing answers for each of the M.N subproblems. Each subproblem takes O(1)
		 *                     O(1) space to store. Hence, a total of O(M.N)
		 * 
		 * */
		
		if(text1 == "" || text2 == "")
			return 0;
		
		if(text1.equals(text2))
			return text1.length();
		
		memo = new Integer[text1.length()+1][text2.length()+1];
		
		return lcsMemoizationHelper(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
		
	}
	
	public static int lcsMemoizationHelper(char[] text1, char[] text2, int len1, int len2) {
		
		if(memo[len1][len2] != null)
			return memo[len1][len2];
		
		if(len1 == 0 || len2 == 0)
			memo[len1][len2] = 0;
		
		else if(text1[len1-1] == text2[len2-1])
			memo[len1][len2] = 1 + lcsMemoizationHelper(text1, text2, len1-1, len2-1);
		
		else
			memo[len1][len2] = Math.max(lcsMemoizationHelper(text1, text2, len1-1, len2), lcsMemoizationHelper(text1, text2, len1, len2-1));
		
		return memo[len1][len2];
			
	}
	
	public static int lcsTabulation_DP(String text1, String text2) {
		
		/*-> Time Complexity: O(M.N). Solving each subproblem has a cost of O(1). 
		 * 					  The input parameters to the recursive function are a pair of integers; 
		 * 					  representing a position in each string. There are M possible positions for the 
		 * 					  first string, and N for the second string. Therefore, this gives us (M.N) 
		 * 					  possible pairs of integers, and is the number of subproblems to be solved.
		 * 					  As there are M.N subproblems, and so we get a total time complexity of O(M.N) 
		 *-> Space Complexity: Storing a 2D size array of dimensions (M+1 X N+1). Hence, (M.N) 
		 * */
		if(text1 == "" || text2 == "")
			return 0;
		
		if(text1.equals(text2))
			return text1.length();
		
		int[][] dp = new int[text1.length()+1][text2.length()+1];
		
		char[] t1 = text1.toCharArray();
		char[] t2 = text2.toCharArray();
		
		for(int i=1; i<t1.length+1; i++) {
			for(int j=1; j<t2.length+1; j++) {
				if(t1[i-1] == t2[j-1])
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[t1.length][t2.length];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "abcde";
		String s2 = "ace";
		
		System.out.println(lcsRecursive(s1, s2));
		System.out.println(lcsMemoization(s1, s2));
		System.out.println(lcsTabulation_DP(s1, s2));
		
		
	}

}
