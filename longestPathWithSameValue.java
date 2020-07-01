package Coupang;

public class longestPathWithSameValue {
	
	public static int ansLength;
	
	public static int lengthCalc(TreeNode root) {
		if(root == null)
			return 0;
		
		// Recursive calls to check for subtrees 
		int left = lengthCalc(root.left);
		int right = lengthCalc(root.right);
		
		// Variables to store maximum lengths 
	    // in two directions
		int leftMax = 0;
		int rightMax = 0;
		
		// If curr node and it's left child 
	    // has same value 
		if(root.left != null && root.left.data == root.data)
			leftMax += left+1;
		
		// If curr node and it's right child 
	    // has same value 
		if(root.right != null && root.right.data == root.data)
			rightMax += right+1;
		
		ansLength = Math.max(ansLength, leftMax + rightMax);
		return Math.max(leftMax, rightMax);
		
	}
	public static int lengthLongestPath(TreeNode root) {
		ansLength=0;
		lengthCalc(root);
		return ansLength;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		root.right = new TreeNode(8);
		root.right.right = new TreeNode(8);
		root.right.right.right = new TreeNode(8);
		root.right.right.right.right = new TreeNode(10);
		root.right.right.right.left = new TreeNode(8);
		root.right.right.right.left.left = new TreeNode(8);
		root.right.right.right.left.right = new TreeNode(13);
		
		System.out.println("Longest Path with same value: " + lengthLongestPath(root));
		//HashSet<Integer>hs = new HashSet<Integer>();
		

	}

}
