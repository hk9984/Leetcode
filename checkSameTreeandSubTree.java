package Coupang;

public class checkSameTreeandSubTree {
	
	public static boolean checkSameTree(TreeNode root1, TreeNode root2) {
		
		//if both roots reach end of subtree, then true
		if(root1 == null && root2 == null)
			return true;
		
		//checking if either of the roots is null, then return false
		if((root1 == null && root2 != null) || (root2 == null && root1 != null))
			return false;
		
		//checking if the values of roots are not equal
		if(root1.data != root2.data)
			return false;
		
		return checkSameTree(root1.left, root2.left) && checkSameTree(root1.right, root2.right);
	}
	
	public static boolean isSubTree(TreeNode root1, TreeNode root2) {
		
		if(root1 == null && root2 == null)
			return true;
		
		//checking if either of the roots is null, then return false
		if((root1 == null && root2 != null) || (root2 == null && root1 != null))
			return false;
		
		if(checkSameTree(root1, root2))
			return true;
		
		return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.right.right = new TreeNode(4);
		
		System.out.println(checkSameTree(root1, root2));
		

	}

}
