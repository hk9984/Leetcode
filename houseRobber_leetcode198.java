package Coupang;

import java.util.ArrayList;
import java.util.List;

public class houseRobber_leetcode198 {
	
	public static int rob(int[] nums) {
		
		/*
		 * Time Complexity: O(n)
		 * Space Complexity: O(n)
		 * */
        
        if(nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        
        int[] maxProfitDp = new int[nums.length];
        
        boolean[] rob = new boolean[nums.length];
        
        maxProfitDp[0] = nums[0];
        maxProfitDp[1] = Math.max(nums[0], nums[1]);
        
        rob[0] = true;
        rob[1] = (nums[1] > nums[0]) ? true : false;
        
        for(int i=2; i<nums.length; i++) {
            if(nums[i] + maxProfitDp[i-2] > maxProfitDp[i-1]) {
                maxProfitDp[i] = nums[i] + maxProfitDp[i-2];
                rob[i] = true;
            }
            else {
                maxProfitDp[i] = maxProfitDp[i-1];
                rob[i] = false;
            }
        }
        
        List<Integer> housesToRob = new ArrayList();
        
        for(int i=rob.length-1; i>=0; i--) {
            if(i == rob.length-1 && rob[i] ==true)
                housesToRob.add(i);
            
            else {
                if(rob[i] == true) {
                    if(rob[i+1] == false) {
                    
                        housesToRob.add(i);
                    }
                    else {
                        rob[i] = false;
                    }
            }
                
            }
            
            
        }
        
        System.out.print("Houses to rob: ");
        for(int i=housesToRob.size()-1; i>=0; i--) {
        	System.out.print(housesToRob.get(i) + " ");
        }
        
        return maxProfitDp[nums.length-1];
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int maxSum = rob(new int[] {2,7,9,3,1});
		System.out.println("\nMax sum robbed: "+maxSum);

	}

}
