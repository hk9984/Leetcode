package Coupang;

/*
Diameter of Binary Tree is actually the number of edges in the longest path of a binary tree.
It happens with two cases:

* Case I: When the root node is in the path of the diameter. In this case, 
	 Diameter = Height of left subtree + Height of right subtree + 2 (2 is for the two edges from the root node to the left and right subtree)
	 
* Case II: When the root node is not in the path of the diameter. It means that the diameter(or the longest path) is in either left or right subtree. In this case, 
	 Diameter = Maximum of (Left subtree diameter) and (Right subtree diameter)
	 
	
* Hence, Diameter of a tree is given by: 

	Maximum of ((Height of left subtree + Height of right subtree + 2) and (Maximum of (Left subtree diameter) and (Right subtree diameter)))

*/

public class diameterOfTree {
	
	
	public static int diameter(TreeNode root) {
		
		if(root == null)
			return -1;
		
		int lheight = heightOfTree(root.left);
		int rheight = heightOfTree(root.right);
		
		int ldiam = diameter(root.left);
		int rdiam = diameter(root.right);
		
		return Math.max(lheight+rheight+1, Math.max(ldiam, rdiam));
	}
	
	public static int heightOfTree(TreeNode root) {
		if(root == null)
			return -1;
		
		else
			return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		root.right.right.right.right = new TreeNode(10);
		root.right.right.right.left = new TreeNode(11);
		root.right.right.right.left.left = new TreeNode(12);
		root.right.right.right.left.right = new TreeNode(13);
		*/
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);
		
		System.out.println("Diameter of Tree having Case I: " + diameter(root));
		
		TreeNode root2 = new TreeNode(1);
		root2.right = new TreeNode(2);
		root2.right.right = new TreeNode(3);
		root2.left = new TreeNode(4);
		root2.left.left = new TreeNode(5);
		root2.left.right = new TreeNode(6);
		root2.left.left.left = new TreeNode(7);
		root2.left.left.right = new TreeNode(8);
		root2.left.right.right = new TreeNode(9);
		root2.left.left.right.left = new TreeNode(10);
		root2.left.right.right.left = new TreeNode(11);
		root2.left.right.right.right = new TreeNode(12);
		root2.left.left.right.left.left = new TreeNode(13);
		root2.left.left.right.left.right = new TreeNode(14);
		root2.left.right.right.right.right = new TreeNode(15);
		
		System.out.println("Diameter of Tree having Case II: " + diameter(root2));
		

	}

}
