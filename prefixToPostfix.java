package Coupang;

import java.util.Stack;

public class prefixToPostfix {
	
	public static String toPostfix(String prefixString) {
		
		String postfixString = "";
		
		char[] chararr = prefixString.toCharArray();
		Stack<String> stack = new Stack();
		
		for(int i=chararr.length-1; i>=0; i--) {
			if(chararr[i] == '+' || chararr[i] == '-' || chararr[i] == '*' || chararr[i] == '/') {
				String opnd1 = stack.pop();
				String opnd2 = stack.pop();
				postfixString = opnd1 + opnd2 + chararr[i];
				stack.push(postfixString);
			}
			else
				stack.push(""+chararr[i]);
		}
		
		return postfixString;
	}
	
	public static String toInfix(String prefixString) {
		String infixString = "";
		
		char[] chararr = prefixString.toCharArray();
		Stack<String> stack = new Stack();
		
		for(int i=chararr.length-1; i>=0; i--) {
			if(chararr[i] == '+' || chararr[i] == '-' || chararr[i] == '*' || chararr[i] == '/') {
				String opnd1 = stack.pop();
				String opnd2 = stack.pop();
				infixString = opnd1 + chararr[i] + opnd2;
				stack.push(infixString);
			}
			else
				stack.push(""+chararr[i]);
		}
		
		return infixString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Postfix String: " + toPostfix("*+AB-CD"));
		System.out.println("Infix String: " + toInfix("*+AB-CD"));

	}

}
