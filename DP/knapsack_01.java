package DP;

public class knapsack_01 {
	
	static int[][] memo;
	
	
	public static int knapsackRecursive(int[] wt, int[] val, int W, int n) {
		
		/*first writing the base condition
		 * For base condition, always think of the smallest valid input
		 * Hence, if W == 0 or n == 0 can be the smallest valid input
		 * W == 0 -> the knapsack has now 0 capacity
		 * n == 0 -> no items left to put in the bag
		 */
		
		if(n == 0 || W == 0)
			return 0;
		
		/* Now coding out the choice diagram
		 * 
		 * -> if item has weight > W, then only choice is to not put the item in the knapsack
		 * -> if item has weight <= W, then there is choice to put the item or not to put
		 * 
		 * */
		
		if(wt[n-1] > W) {
			return knapsackRecursive(wt, val, W, n-1);
		}
		
		else {
			return Math.max(val[n-1] + knapsackRecursive(wt, val, W-wt[n-1], n-1), 
					knapsackRecursive(wt, val, W, n-1));
		}
		
	}
	
	public static int knapsackMemoized(int[] wt, int[] val, int W, int n) {
		
		if(n == 0 || W == 0)
			return 0;
		
		if(memo[n][W] != -1)
			return memo[n][W];   //Value of overlapping subproblem already computed before so return itk
		
		if(wt[n-1] > W) {
			memo[n][W] = knapsackMemoized(wt, val, W, n-1);
			return memo[n][W];
		}
			
		else {
			memo[n][W] = Math.max(val[n-1] + knapsackMemoized(wt, val, W-wt[n-1], n-1), knapsackMemoized(wt, val, W, n-1));
			return memo[n][W];
		}
	}
	
	
	public static int knapsackTabulation(int[] wt, int[] val, int W, int n) {
		
		int[][] dp = new int[n+1][W+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<W+1; j++) {
				if(wt[i-1] <= j) {
					dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
				}
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][W];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] wt = {1, 3, 4, 5};
		int[] val = {1, 4, 5, 7};
		
		int W = 7;
		int n = wt.length;
		
		memo = new int[n+1][W+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=W; j++) {
				memo[i][j] = -1;
			}
		}
		
		System.out.println("Result knapsackRecursive: " + knapsackRecursive(wt, val, W, n));
		
		System.out.println("Result knapsack Memoized: " + knapsackMemoized(wt, val, W, n));
		
		System.out.println("Result knapsack Tabulation: " + knapsackTabulation(wt, val, W, n));
		

	}

}
