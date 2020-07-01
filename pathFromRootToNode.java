package Coupang;

public class pathFromRootToNode {
	
	public static String pathFromRoot(TreeNode root, int searchVal) {
		
		if(root == null)
			return "Empty Tree / No path";
		
		String path = dfsPath(root, searchVal);
		
		return (path.length() == 0) ? "Node not found" : path.substring(1);
		
	}
	
	public static String dfsPath(TreeNode root, int val) {
		if(root == null)
			return "";
		
		if(root.data == val)
			return " " + root.data;
		
		String leftStr = dfsPath(root.left, val);
		String rightStr = dfsPath(root.right, val);
		
		if(leftStr.length() != 0 || rightStr.length() != 0)
			return " " + root.data + leftStr + rightStr;
		
		return leftStr + rightStr;
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
		
		System.out.println("Path from Root to Node 2: " + pathFromRoot(root, 9));

	}

}
