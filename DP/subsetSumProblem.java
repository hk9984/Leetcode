package DP;

public class subsetSumProblem {

    static int[][] memo;

    public static boolean subsetSumRecursive(int[] arr, int n, int sum) {
        // TODO Auto-generated method stub


        //base cond: if arr is empty 
        if(sum == 0)
            return true;

        if(n == 0)
            return false;

        if(arr[n-1] > sum)
            return subsetSumRecursive(arr, n-1, sum);

        else {
            return subsetSumRecursive(arr, n-1, sum-arr[n-1]) || subsetSumRecursive(arr, n-1, sum);
        }

    }

    public static boolean subsetSumMemoize(int[] arr, int n, int sum) {

        if(sum == 0)
            return true;

        if(n == 0)
            return false;

        if(memo[n][sum] != -1)
            return (memo[n][sum] == 1);

        if(arr[n-1] > sum)
            memo[n][sum] = subsetSumMemoize(arr, n-1, sum) ? 1 : 0;
        else
            memo[n][sum] = (subsetSumMemoize(arr, n-1, sum-arr[n-1]) || subsetSumMemoize(arr, n-1, sum)) ? 1 : 0;

        return memo[n][sum] == 1;
    }

    public static boolean subsetSumTabulation(int[] arr, int n, int sum) {

        Boolean[][] dp = new Boolean[n+1][sum+1];

        for(int j=0; j<sum+1; j++)
            dp[0][j] = false;
        for(int i=0; i<n+1; i++)
            dp[i][0] = true;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];
    }


    public static void main(String[] args) {

        int[] arr = new int[]{2,3,7,8,10};

        int n = arr.length;

        int sum = 11;

        memo = new int[n+1][sum+1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<sum+1; j++) {
                memo[i][j] = -1;
            }
        }



        if(subsetSumRecursive(arr, n, sum))
            System.out.println("Present");
        else
            System.out.println("Not present");
    }
        
            
    
}
