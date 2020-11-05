package Walmart;

import java.util.ArrayList;
import java.util.List;

public class generateParentheses {
	
	public static List<String> generateParentheses(int n) {
        
        List<String> parentheses = new ArrayList();
        if(n == 0)
            return parentheses;
        
        
        backtrackParentheses(parentheses, "", 0, 0, n);
        
        return parentheses;
        
        
    }
    
    public static void backtrackParentheses(List<String> parentheses, String curr, int open, int close, int max) {
        
        if(curr.length() == max * 2) {
            parentheses.add(curr);
            return;
        }
        
        if(open < max)
            backtrackParentheses(parentheses, curr + "(", open+1, close, max);
        
        if(close < open)
            backtrackParentheses(parentheses, curr + ")", open, close+1, max);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> allCombinations = generateParentheses(3);
		
		for(String s : allCombinations)
			System.out.println(s);

	}

}
