package Coupang;

import java.util.Stack;

public class iterativeTreeTraversals {
	
	public static void inorderIterative(TreeNode root) {
		
		System.out.println("Inorder Iterative: ");
		if(root == null)
			System.out.println("Empty Tree / Null root");
		
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack();
		
		while(curr != null || !stack.isEmpty()) {
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
		
	}
	
	public static void preorderIterative(TreeNode root) {
		
		System.out.println("Preorder Iterative: ");
		if(root == null)
			System.out.println("Empty Tree / Null root");
		
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack();
		
		while(curr != null || !stack.isEmpty()) {
			while(curr != null) {
				System.out.print(curr.data + " ");
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.pop().right;
		}
	}
	
	public static void postorderIterative(TreeNode root) {
		
		System.out.println("Postorder Iterative: ");
		
		if(root == null)
			System.out.println("Empty Tree / Null root");
		
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack();
		
		while(curr != null || !stack.isEmpty()) {
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			TreeNode peeked = stack.peek();
			if(peeked.right != null) {
				curr = peeked.right;
				continue;
			}
			
			curr = stack.pop();
			System.out.print(curr.data + " ");
			if(stack.isEmpty()) {
				break;
			}
			if(curr == stack.peek().left)
				stack.peek().left = null;
			else
				stack.peek().right = null;
			
			curr = stack.pop();
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		
		inorderIterative(root);
		System.out.println("\n");
		preorderIterative(root);
		System.out.println("\n");
		postorderIterative(root);

	}

}
