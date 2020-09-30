package DynamicProgramming;

public class minSubsetSumDiff {
	
	static int[][] memo;
	
	public static int minSSDRecursive(int[] arr) {
		
		int n = arr.length;
		int sum = 0;
		
		for (int i : arr)
			sum += i;
		
		if(sum == 0)
			return 0;
		
		int maxSubsetSum = sum / 2;
		
		int validsum = minSSDRecursiveHelper(arr, maxSubsetSum, n);
		System.out.println("Valid sum: " + validsum);
		
		return sum - (2 * validsum);
	}
	
	

	public static int minSSDRecursiveHelper(int[] arr, int maxSubsetSum, int n) {
		// TODO Auto-generated method stub
		if(n == 0 || maxSubsetSum == 0)
			return 0;
		
		if(arr[n-1] <= maxSubsetSum) {
			return Math.max(arr[n-1] + minSSDRecursiveHelper(arr, maxSubsetSum-arr[n-1], n-1), minSSDRecursiveHelper(arr, maxSubsetSum, n-1));
		}
		else
			return minSSDRecursiveHelper(arr, maxSubsetSum, n-1);
	}
	
	public static int minSSDMemoization(int[] arr, int n) {
		
		
		int sum = 0;
		
		for (int i : arr)
			sum += i;
		
		if(sum == 0)
			return 0;
		
		int maxSubsetSum = sum / 2;
		
		memo = new int[n+1][maxSubsetSum+1];
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<maxSubsetSum+1; j++) {
				memo[i][j] = -1;
			}
		}
		
		int validsum = minSSDMemoHelper(arr, maxSubsetSum, n);
		System.out.println("Valid sum: " + validsum);
		
		return sum - (2 * validsum);
		
	}



	public static int minSSDMemoHelper(int[] arr, int sum, int n) {
		// TODO Auto-generated method stub
		
		if(n == 0 || sum == 0)
			return 0;
		
		if(memo[n][sum] != -1)
			return memo[n][sum];
		
		if(arr[n-1] <= sum)
			memo[n][sum] = Math.max(arr[n-1] + minSSDMemoHelper(arr, sum-arr[n-1], n-1), minSSDMemoHelper(arr, sum, n-1));
		else
			memo[n][sum] = minSSDMemoHelper(arr, sum, n-1);
		
		return memo[n][sum];
		
	}
	
	public static int minSSDTabulation(int[] arr) {
		
		int n = arr.length;
		int sum = 0;
		
		for (int i : arr)
			sum += i;
		
		if(sum == 0)
			return 0;
		
		int maxSubsetSum = sum / 2;
		
		int[][] dp = new int[n+1][maxSubsetSum+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<maxSubsetSum+1; j++) {
				if(arr[i-1] <= j)
					dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return sum - 2*dp[n][maxSubsetSum];
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,6,5,11};
		int n = arr.length;
		
		
		System.out.println(minSSDRecursive(arr));
		System.out.println(minSSDMemoization(arr, n));
		System.out.println(minSSDTabulation(arr));
		
		

	}

}
