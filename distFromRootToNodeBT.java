package Coupang;

import java.util.*;

import org.w3c.dom.Node;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int d) {
		data = d;
	}
}

public class distFromRootToNodeBT {
	
	//this is a DFS method
	public static int shortestDistanceToNode(TreeNode root, int searchVal) {
		if(root == null)
			return -1;
		
		int dist = -1;
		
		if(root.data == searchVal || 
			(dist = shortestDistanceToNode(root.left, searchVal)) >= 0 ||
			(dist = shortestDistanceToNode(root.right, searchVal)) >= 0) {
				return dist + 1;
			}
		return dist;
	}
	
	public static void preorder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.data+" ");
		
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void postorder(TreeNode root) {
		if(root == null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static void inorder(TreeNode root) {
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static void levelorder(TreeNode root) {
		if(root == null) {
			System.out.println("Empty tree");
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode entry = queue.poll();
			System.out.print(entry.data + " ");
			if(entry.left != null)
				queue.add(entry.left);
			if(entry.right != null)
				queue.add(entry.right);
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
		
		levelorder(root);
		System.out.println("");
		System.out.println(shortestDistanceToNode(root, 2));
		System.out.println(shortestDistanceToNode(root, 3));
		System.out.println(shortestDistanceToNode(root, 4));
		System.out.println(shortestDistanceToNode(root, 5));
		System.out.println(shortestDistanceToNode(root, 6));
		System.out.println(shortestDistanceToNode(root, 7));
		System.out.println(shortestDistanceToNode(root, 8));
		System.out.println(shortestDistanceToNode(root, 1));
		

	}

}
