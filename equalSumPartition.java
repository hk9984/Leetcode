package DynamicProgramming;

public class equalSumPartition {
	
	static int[][] memo;
	
	
	public static boolean equalSPMain(int[] arr, int n) {
		
		
		if(n == 0)
			return true;
		
		if(n == 1)
			return false;
		
		int sum = 0;
		
		for(int i : arr)
			sum += i;
		
		if(sum % 2 != 0)
			return false;
		
		memo = new int[n+1][(sum/2)+1];
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<(sum/2)+1; j++)
				memo[i][j] = -1;
		}
		
		//return equalSPRecursiveHelper(arr, sum/2, n);
		return equalSPMemoize(arr, sum/2, n);
	}

	public static boolean equalSPRecursiveHelper(int[] arr, int sum, int n) {
		// TODO Auto-generated method stub
		
		if(sum == 0)
			return true;
		
		if(n == 0)
			return false;
		
		if(arr[n-1] <= sum)
			return equalSPRecursiveHelper(arr, sum-arr[n-1], n-1) || equalSPRecursiveHelper(arr, sum, n-1);
		else
			return equalSPRecursiveHelper(arr, sum, n-1);
		
	}
	
	public static boolean equalSPMemoize(int[] arr, int sum, int n) {
		
		if(sum == 0)
			return true;
		
		if(n == 0)
			return false;
		
		if(memo[n][sum] != -1)
			return memo[n][sum] == 1;
		
		if(arr[n-1] <= sum)
			memo[n][sum] = (equalSPMemoize(arr, sum-arr[n-1], n-1) || equalSPMemoize(arr, sum, n-1)) ? 1 : 0;
		else
			memo[n][sum] = equalSPMemoize(arr, sum, n-1) ? 1 : 0;
		
		return memo[n][sum] == 1;
	}
	
	public static boolean equalSPTabulation(int[] arr) {
		
		int sum = 0;
		
		for(int i : arr)
			sum += i;
		
		if(sum % 2 != 0)
			return false;
		
		else
			return subsetSum(arr, sum/2, arr.length);
		
		
	}
	
	public static boolean subsetSum(int[] arr, int subsetSum, int n) {
		
		
		boolean[][] dp = new boolean[n+1][subsetSum+1];
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<subsetSum+1; j++) {
				if(i == 0)
					dp[i][j] = false;
				if(j == 0)
					dp[i][j] = true;
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<subsetSum+1; j++) {
				if(arr[i-1] <= j)
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
				
			}
		}
		
		return dp[n][subsetSum];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,5,12,5};
		int n = arr.length;
		
		
		System.out.println(equalSPTabulation(arr));

	}

}
