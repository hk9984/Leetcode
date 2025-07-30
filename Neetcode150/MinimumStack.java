package Leetcode.Neetcode150;

import java.util.Stack;

/*
 * Design a stack class that supports the push, pop, top, and getMin operations.
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * 
 * Each function should run in O(1) time.
 * 
 * Example1: 
 * Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
 * Output: [null,null,null,null,0,null,2,1]
 * Explanation:
 * MinStack minStack = new MinStack();
 * minStack.push(1);
 * minStack.push(2);
 * minStack.push(0);
 * minStack.getMin(); // return 0
 * minStack.pop();
 * minStack.top();    // return 2
 * minStack.getMin(); // return 1
 * 
 * Constraints:
 * -2^31 <= val <= 2^31 - 1.
 * pop, top and getMin will always be called on non-empty stacks.
 * 
 */

public class MinimumStack {

    /*
     * 
     * Using 2 stacks. One normal, one for min values at every time
     * 
     * Time Complexity for every moethod: O(1)
     * Space Complexity: O(n)
     */

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinimumStack(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
        stack.push(val);

    }

    public void pop() {
        if(stack.peek().equals(minStack.peek()))   // .equals() to be used instead of "==" because Integer is a boxed type. "==" would have matched objects, but we need to match values
            minStack.pop();
        stack.pop();
    }

    public int top(){
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
    
}
