package Walmart;

import java.util.Stack;

public class minStack {
	Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    
    /*
     * Time Complexity: O(1) because no where are we iterating through the loop, for min also considering another stack to keep track
     * Space Complexity: O(n) because a new minStack is maintained to handle minimum value
     * */
    
    public minStack() {
        
        stack = new Stack();
        minStack = new Stack();
        
    }
    
    public void push(int x) {
        
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
        
    }
    
    public void pop() {
        
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		minStack minStack = new minStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top();    // return 0
		minStack.getMin(); // return -2

	}

}
