package Coupang;

import java.util.ArrayList;

public class fibonacciAllMethods {
	
	public static ArrayList<Integer> topDownCache = new ArrayList();
	
	public static int fibonacciRecursive(int n) {
		
		/*
		 * -> Time complexity: O(2^n). This is because recursion tree grows exponentially as the depth approaches N
		 * 
		 * -> Space complexity: O(n). We need space proportionate to N to account for the max size of the stack, 
		 * 					   in memory. This stack keeps track of the function calls to fib(N). 
		 * 					   This has the potential to be bad in cases that there isn't enough physical memory 
		 * 					   to handle the increasingly growing stack, leading to a StackOverflowError
		 * */
		if (n<=1)
			return n;
		
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
	}
	
	public static int bottomUpFibonacci(int n) {
		
		/*
		 * -> Time complexity : O(N). Each number, starting at 2 up to and including N, is visited, 
		 *                      computed and then stored for O(1) access later on.
		 * 
		 * -> Space complexity : O(N). The size of the data structure is proportionate to N.
		 * 
		 * */
		if (n<=1)
			return n;
		
		int []fib = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i=2; i<(n+1); i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib[n];
	}
	
	public static int topDownFibonacci(int n) {
		
		/*
		 * -> Time complexity : O(N). Each number, starting at 2 up to and including N, is visited, 
		 *                      computed and then stored for O(1) access later on.
		 * 
		 * -> Space complexity : O(N). The size of the stack in memory is proportionate to N.
		 * 
		 * */
		if(n <= 1)
			return n;
		
		topDownCache.add(0, 0);
		topDownCache.add(1, 1);
		
		return topDownMemoize(n);
	}
	
	public static int topDownMemoize(int n) {
		if (topDownCache.size() > n)
			return topDownCache.get(n);
		
		topDownCache.add(n, topDownMemoize(n-1) + topDownMemoize(n-2)); 
		return topDownCache.get(n);
	}
	
	public static int iterativeBottomUpFibonacci(int n) {
		/*
		 * -> Time complexity : O(N). Each value from 2 to N will be visited at least once. 
		 * 						The time it takes to do this is directly proportionate to N where N 
		 * 						is the Fibonacci Number we are looking to compute
		 * 
		 * -> Space complexity : O(1)
		 * 
		 * */
		
		if(n <= 1)
			return n;
		
		
		int last = 1;
		int second_last = 0;
		
		int curr = 1;
		
		for(int i=2; i<=n; i++) {
			curr = last + second_last;
			second_last = last;
			last = curr;
		}
		
		return curr;
	}
	
	
	public int fibonacciFormula(int n) {
		
		/*
		 * Time Complexity: O(1)
		 * Space Complexity: O(1)
		 * */
		double goldenRatio = (1 + Math.sqrt(5)) / 2;
		return (int)Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Test the methods with any values
		// for the top down 
		
		

	}

}
