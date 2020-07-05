package Coupang;

import java.util.ArrayList;
import java.util.List;

/*
 *  These comments taken from Leetcode 257. Binary Tree Paths Solution
 *  Given a binary tree, return all root-to-leaf paths.
 * 
 *  Time complexity : we visit each node exactly once, thus the time complexity O(N), where N is the number of nodes.
 *  Space complexity : O(N). Here we use the space for a stack call and for a paths list to store the answer. 
 *  paths contains as many elements as leafs in the tree and hence couldn't be larger than logN for the 
 *  trees containing more than one element. Hence the space complexity is determined by a stack call. 
 *  In the worst case, when the tree is completely unbalanced, e.g. each node has only one child node, 
 *  the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack 
 *  would be O(N). But in the best case (the tree is balanced), the height of the tree would be log(N). 
 *  Therefore, the space complexity in this case would be O(log(N)).
 * 
 * 
 * */

public class binaryTreePaths {
	
	public static List<String> binaryTreePaths(TreeNode root) {
		
		List<String> paths = new ArrayList();
		
		if(root == null)
			return paths;
		
		helperDFS(root, "", paths);
		
		return paths;
		
	}
	
	public static void helperDFS(TreeNode root, String currPath, List<String> paths) {
		
		currPath += root.data;
		
		if(root.left == null && root.right == null) {
			paths.add(currPath);
			return;
		}
		
		if(root.left != null) {
			helperDFS(root.left, currPath + "->", paths);
		}
		
		if(root.right != null) {
			helperDFS(root.right, currPath + "->", paths);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(6);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);
		root.left.right.right = new TreeNode(9);
		root.left.left.right.left = new TreeNode(10);
		root.left.right.right.left = new TreeNode(11);
		root.left.right.right.right = new TreeNode(12);
		root.left.left.right.left.left = new TreeNode(13);
		root.left.left.right.left.right = new TreeNode(14);
		root.left.right.right.right.right = new TreeNode(15);
		
		List<String> finalPaths = binaryTreePaths(root);
		
		System.out.println("Printing all the root to leaf paths");
		for(String path : finalPaths) {
			System.out.println(path);
		}

	}

}
