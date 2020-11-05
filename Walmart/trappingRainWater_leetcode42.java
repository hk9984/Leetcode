package Walmart;

public class trappingRainWater_leetcode42 {
	
	 /*
    Time Complexity: O(n). Iterating linearly through the array while calculating
                     left and right maximas, and also while calculating trapAmount 
                     for each iteration.
                     
    Space Complexity: O(n). to save the left and right maximas
    
    */
    
    public int trap(int[] height) {
        
        if(height.length < 3)
            return 0;
        
        int heightLen = height.length;
        int[] leftMaximas = new int[heightLen];
        int[] rightMaximas = new int[heightLen];
        
        leftMaximas[0] = height[0];
        
        for(int i=1; i<heightLen; i++) {
            leftMaximas[i] = Math.max(leftMaximas[i-1], height[i]);
        }
        
        rightMaximas[heightLen-1] = height[heightLen-1];
        
        for(int i = heightLen-2; i>=0; i--) {
            rightMaximas[i] = Math.max(rightMaximas[i+1], height[i]);
        }
        
        int trapAmount = 0;
        
        for(int i=1; i<heightLen-1; i++) {
            trapAmount += Math.min(leftMaximas[i], rightMaximas[i]) - height[i];
        }
        
        return trapAmount;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
