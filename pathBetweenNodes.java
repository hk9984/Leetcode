package Coupang;

import java.util.LinkedList;
import java.util.Queue;


public class pathBetweenNodes {
	
	public static int nodeFoundCountLCA = 2;
	
	public static String pathbwnodes(TreeNode root, int node1, int node2) {
		
		if(root == null)
			return "Empty tree / No path";
		
		TreeNode lca = findingLCA(root, node1, node2);
		if(nodeFoundCountLCA != 0 && lca != root)
			return "Node not found";
		
		String lca_node1 = pathDFS(lca, node1);
		String lca_node2 = pathDFS(lca, node2);
		
		StringBuilder sb = new StringBuilder(lca_node1);
		lca_node1 = sb.reverse().toString();
		String finalPath = lca_node1.substring(0,lca_node1.length()-1) + lca_node2.substring(2);
		
		return finalPath;
	}
	
	public static String pathDFS(TreeNode root, int searchVal) {
		if(root == null)
			return "";
		
		if(root.data == searchVal)
			return " "+root.data;
		
		String lsubtree_path = pathDFS(root.left, searchVal);
		String rsubtree_path = pathDFS(root.right, searchVal);
		
		if(lsubtree_path.length() != 0 || rsubtree_path.length() != 0)
			return " " + root.data + lsubtree_path + rsubtree_path;
		
		return lsubtree_path + rsubtree_path;
	}
	
	public static TreeNode findingLCA(TreeNode root, int val1, int val2) {
		
		if(root == null)
			return null;
		
		if(root.data == val1 || root.data == val2) {
			nodeFoundCountLCA--;
			return root;
		}
			
		
		TreeNode left_lca = findingLCA(root.left, val1, val2);
		TreeNode right_lca = findingLCA(root.right, val1, val2);
		
		if(left_lca != null && right_lca != null)
			return root;
		
		return (left_lca != null) ? left_lca : right_lca;
		
	}
	
	public static void levelOrder(TreeNode root) {
		
		if(root == null)
			System.out.println("Empty tree");
		
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode entry = queue.poll();
			
			if(entry == null)
				continue;
			
			System.out.print(entry.data + " ");
			queue.add(entry.left);
			queue.add(entry.right);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
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
		
		//levelOrder(root);
		
		System.out.println("Path between nodes(6,13) :" + pathbwnodes(root, 6, 13));

	}

}
