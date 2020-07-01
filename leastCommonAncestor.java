package Coupang;

public class leastCommonAncestor {
	
	public static TreeNode findLCA(TreeNode root, int key1, int key2) {
		
		//base case
		if(root == null)
			return null;
		
		/* If either key1 or key2 matches with root's value, report 
         the presence by returning root (Note that if a key is 
         ancestor of other, then the ancestor key becomes LCA */ 
		if(root.data == key1 || root.data == key2)
			return root;
		/* left_lca checks in the left subtree for the key1 or the key2 nodes
		 * right_rca checks in the right subtree for the key1 or the key2 nodes
		 */
		TreeNode left_lca = findLCA(root.left, key1, key2);
		TreeNode right_lca = findLCA(root.right, key1, key2);
		
		/*
		 * if both the subtrees return not null values, it means both the nodes have been found
		 * so return the root of those subtrees as it is the LCA
		 */
		if(left_lca != null && right_lca != null)
			return root;
		
		/*
		 * Condition:
		 * 1.) If a subtree returns the desired node value, and the other subtree returns null, then return the desired node
		 * 2.) If both subtrees return null, then return null
		 */
		return (left_lca != null) ? left_lca : right_lca;
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
		root.right.right.left = new TreeNode(8);
		
		System.out.println("LCA of (4,5): " + findLCA(root, 4, 5).data);
		System.out.println("LCA of (1,6): " + findLCA(root, 1, 6).data);
		System.out.println("LCA of (1,7): " + findLCA(root, 1, 7).data);
		System.out.println("LCA of (2,7): " + findLCA(root, 2, 7).data);
		System.out.println("LCA of (3,5): " + findLCA(root, 3, 5).data);
		System.out.println("LCA of (5,7): " + findLCA(root, 5, 7).data);
		System.out.println("LCA of (6,8): " + findLCA(root, 6, 8).data);

	}

}
