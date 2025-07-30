package Leetcode;

import java.util.Arrays;

public class subsetSumProblem_DP {

    private static boolean isSubSetSumRecursive(int[] arr, int sum, int n) {

        if(sum == 0)
            return true;
        if(n == 0)
            return false;

        if(arr[n-1] > sum)
            return isSubSetSumRecursive(arr, sum, n-1);

        else {
            return isSubSetSumRecursive(arr, sum-arr[n-1], n-1) || isSubSetSumRecursive(arr, sum, n-1);
        }
    }

    private static boolean isSubSetSumMemoize(int[] arr, int sum, int n, int[][] memo) {
        if(sum == 0)
            return true;

        if(n == 0)
            return false;

        if(memo[n][sum] != -1)
            return (memo[n][sum] == 1);

        if(arr[n-1] > sum) {
            memo[n][sum] = (isSubSetSumMemoize(arr, sum, n-1, memo) == true) ? 1 : 0;
            return memo[n][sum] == 1;
            
        }

        else {
            memo[n][sum] = (isSubSetSumMemoize(arr, sum-arr[n-1], n-1, memo) || isSubSetSumMemoize(arr, sum, n-1, memo)) == true ? 1 : 0;
            return memo[n][sum] == 1;
        }
            
    }

    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        int[][] memo = new int[arr.length+1][sum+1];

        for(int i=0; i<memo.length; i++)
            Arrays.fill(memo[i], -1);



        if(isSubSetSumRecursive(arr, sum, arr.length))
            System.out.println("True");
        else
            System.out.println("False");
        

        if(isSubSetSumMemoize(arr, sum, arr.length, memo))
            System.out.println("True");
        else
            System.out.println("False");
        }

        // if(isSubSetSumMemoize(arr, sum, arr.length))
        //             System.out.println("True");
        //         else
        //             System.out.println("False");
        // }

        
        
            
    
}
