package DP;

public class equalSumPartition {

    static Boolean[][] memo;
    
    public  static boolean equalSumPartitionMemoize(int[] arr, int n, int sumPartition) {
        
        if(sumPartition == 0)
            return true;

        if(n == 0)
            return false;

        if(memo[n][sumPartition] != null)
            return memo[n][sumPartition];


        if(arr[n-1] > sumPartition)
            memo[n][sumPartition] = equalSumPartitionMemoize(arr, n-1, sumPartition);

        else
            memo[n][sumPartition] = equalSumPartitionMemoize(arr, n-1, sumPartition-arr[n-1]) || equalSumPartitionMemoize(arr, n-1, sumPartition);

        return memo[n][sumPartition];
    }

    public static boolean equalSumPartitionTabulation(int[] arr, int n, int sumPartition) {

        Boolean[][] dp = new Boolean[n+1][sumPartition+1];

        for(int j=0; j<sumPartition+1; j++)
            dp[0][j] = false;

        for(int i=0; i<n+1; i++)
            dp[i][0] = true;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sumPartition+1; j++) {
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sumPartition];
    }


    public static void main(String[] args) {

        int[] arr = new int[]{1,5,11,5};

        int n = arr.length;

        int totalSum = 0;

        for(int num: arr)
            totalSum += num;

        if(totalSum % 2 != 0)
            System.out.println("Not possible");

        int sumPartition = totalSum / 2;
        memo = new Boolean[n+1][sumPartition+1];

        // for(int i=0; i<n+1; i++) {
        //     for(int j=0; j<sum+1; j++) {
        //         memo[i][j] = -1;
        //     }
        // }



        if(equalSumPartitionMemoize(arr, n, sumPartition))
                    System.out.println("Present");
                else
                    System.out.println("Not present");
    }
        
        

    
}
