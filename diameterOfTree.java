package Coupang;

public class diameterOfTree {
	
	
	public static int diameter(TreeNode root) {
		
		if(root == null)
			return 0;
		
		int lheight = heightOfTree(root.left);
		int rheight = heightOfTree(root.right);
		
		int ldiam = diameter(root.left);
		int rdiam = diameter(root.right);
		
		return Math.max(lheight+rheight+1, Math.max(ldiam, rdiam));
	}
	
	public static int heightOfTree(TreeNode root) {
		if(root == null)
			return 0;
		
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
		System.out.println("Diameter of tree: " + diameter(root));

	}

}
