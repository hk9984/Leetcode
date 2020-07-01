package Coupang;

public class distBwTwoNodes {
	
	public static int distanceBetweenNodes(TreeNode root, int value1, int value2) {
		TreeNode lca = LCA(root, value1, value2);
		
		int distbwnodes = -1;
		
		if(lca == null)
			return -1;
		
		int dist_lca_node1 = distanceFromRoot(lca, value1);
		int dist_lca_node2 = distanceFromRoot(lca, value2);
		
		return dist_lca_node1 + dist_lca_node2;
	}
	
	public static int distanceFromRoot(TreeNode root, int searchVal) {
		
		int dist = -1;
		if(root == null)
			return dist;
		
		if((root.data == searchVal) ||
			(dist = distanceFromRoot(root.left, searchVal)) >= 0 ||
			(dist = distanceFromRoot(root.right, searchVal)) >= 0) {
			return dist + 1;
		}
		
		return dist;
	}
	
	public static TreeNode LCA(TreeNode root, int val1, int val2) {
		
		if(root == null)
			return null;
		
		if(root.data == val1 || root.data == val2)
			return root;
		
		TreeNode left_lca = LCA(root.left, val1, val2);
		TreeNode right_lca = LCA(root.right, val1, val2);
		
		if(left_lca != null && right_lca != null)
			return root;
		
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
		
		
		System.out.println("Dist. between (1,2): " + distanceBetweenNodes(root,1,2));
		System.out.println("Dist. between (1,3): " + distanceBetweenNodes(root,1,3));
		System.out.println("Dist. between (1,5): " + distanceBetweenNodes(root,1,5));
		System.out.println("Dist. between (1,8): " + distanceBetweenNodes(root,1,8));
		System.out.println("Dist. between (2,7): " + distanceBetweenNodes(root,2,7));
		System.out.println("Dist. between (5,6): " + distanceBetweenNodes(root,5,6));
		System.out.println("Dist. between (4,3): " + distanceBetweenNodes(root,4,3));
		System.out.println("Dist. between (8,5): " + distanceBetweenNodes(root,8,5));
		System.out.println("Dist. between (7,8): " + distanceBetweenNodes(root,7,8));
		System.out.println("Dist. between (2,2): " + distanceBetweenNodes(root,2,2));
		System.out.println("Dist. between (3,8): " + distanceBetweenNodes(root,3,8));

	}

}
