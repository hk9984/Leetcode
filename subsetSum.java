package DynamicProgramming;

public class subsetSum {
	
	static int[][] memo;
	
	public static boolean subsetSumRecursive(int[] arr, int sum, int n) {
		
		/*
		 * Base condition
		 * */
		if(sum == 0)
			return true;
		
		if(n == 0)
			return false;
		
		/*
		 * Choice diagram, choosing the element or not
		 * */
		
		if(arr[n-1] <= sum) {
			return subsetSumRecursive(arr, sum-arr[n-1], n-1) || subsetSumRecursive(arr, sum, n-1);
		}
		
		else
			return subsetSumRecursive(arr, sum, n-1);
		
		
	}
	
	public static boolean subsetSumMemoize(int[] arr, int sum, int n) {
		
		if(sum == 0)
			return true;
		
		if(n == 0)
			return false;
		
		if(memo[n][sum] != -1) {
			return (memo[n][sum] == 1);
		}
		
		if(arr[n-1] <= sum) {
			memo[n][sum] = (subsetSumMemoize(arr, sum-arr[n-1], n-1) || subsetSumMemoize(arr, sum, n-1)) ? 1 : 0;
		}
		
		else
			memo[n][sum] = subsetSumMemoize(arr, sum, n-1) ? 1 : 0;
		
		return memo[n][sum] == 1;
		
	}
	
	public static boolean subsetSumTabulation(int[] arr, int sum, int n) {
		
		boolean[][] dp = new boolean[n+1][sum+1];
		
		/*
		 * for(int j = 0; j<sum+1; j++) dp[0][j] = false; for(int i=0; i<n+1; i++)
		 * dp[i][0] = true;
		 */
		
		for(int i=0 ; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i==0)
					dp[i][j] = false;
				if(j == 0)
					dp[i][j] = true;
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(arr[i-1] <= j) {
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][sum];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,3,8,7,10};
		int sum = 11;
		
		int n = arr.length;
		
		memo = new int[n+1][sum+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=sum; j++) {
				memo[i][j] = -1;
			}
		}
		
		System.out.println(subsetSumRecursive(arr, sum, n));
		System.out.println(subsetSumMemoize(arr, sum, n));
		System.out.println(subsetSumTabulation(arr, sum, n));

	}

}
