package Coupang;

public class BSTValidation {
	
	public static boolean isBST = true;
	public static TreeNode prev = null;
	public static boolean validateBST(TreeNode root) {
		if(root == null)
			return true;
		helperDFS(root);
		return isBST;
	}
	
	public static void helperDFS(TreeNode root) {
		if(root == null || !isBST)
			return;
		
		helperDFS(root.left);
		if(prev != null) {
			if(root.data <= prev.data) {
				isBST = false;
				return;
			}
		}
		prev = root;
		helperDFS(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(5);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);
		
		String answer = validateBST(root) == true ? "It is a valid BST" : "Not a valid BST";
		
		System.out.println(answer);
			
		

	}

}
