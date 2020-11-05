package Walmart;

import java.util.Arrays;

public class smallestDivisorThreshold_leetcode1283 {
	
	public static int division(int[] nums, int divisor) {
        int sum = 0;
        
        for(int i : nums) {
            sum += (i % divisor == 0) ? (i / divisor) : (i / divisor) + 1; 
        }
        
        return sum;
    }
    
    /*
    Time Complexity: O(NlogN + NlogNmax). because if array not sorted, sort the array in nlogn time. 
                     Otherwise if the array is sorted, O(NlogNmax). This is because we are using 
                     binary search to find smallest divisor with N making the highest element in the 
                     array.
    Space Complexity: O(1). No additional space
    */
    public int smallestDivisor(int[] nums, int threshold) {
        
        if(nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        
        //int smallestDivisor = Integer.MAX_VALUE;
        
        int right = nums[nums.length - 1];
        int left = 1;
        
        /*
        Binary search to find out the smallest divisor 
        */
        while(left <= right) {
            int mid = left + (right-left) / 2;
            
            int currsum = division(nums, mid);
            
            if(currsum <= threshold)
                right = mid-1;
            else
                left = mid+1;  
        }
        
        return left;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
