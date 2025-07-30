package Leetcode;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



/* These are the basic codes for a tree to get familiar with how tree works and recursion in a tree as well
 * Define a TreeNode class first
 * 
 * class TreeNode {
 * 	int val;
 * 	TreeNode left;
 * 	TreeNode right;
 * 
 * 	public TreeNode (int v) {
 * 		val = v;
 * 	}
 * }
 */

public class TreeBasic {

	public static void bfsDisplay(TreeNode root) {

	    Queue<TreeNode> queue = new LinkedList();

	    if(root == null)
	      System.out.println("Empty Tree");

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

	  public static void preorder(TreeNode root) {
	    if(root == null)
	      return;
	    System.out.print(root.data + " ");
	    preorder(root.left);
	    preorder(root.right);
	  }

	  public static void postorder(TreeNode root) {
	    if(root == null)
	      return;
	    postorder(root.left);
	    postorder(root.right);
	    System.out.print(root.data + " ");
	  }

	  public static void inorder(TreeNode root) {
	    if(root == null)
	      return;
	    inorder(root.left);
	    System.out.print(root.data + " ");
	    inorder(root.right);
	  }

	  public static int heightOfTree(TreeNode root) {
	    if(root == null)
	      return 0;
	    return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.left));
	  }

	  public static void spiralOrZigZagOrder(TreeNode root) {
	    if(root == null)
	      System.out.println("Empty Tree");
	    
	    Stack<TreeNode> st1 = new Stack();
	    Stack<TreeNode> st2 = new Stack();

	    st1.push(root);

	    while(!st1.isEmpty()) {
	      TreeNode entry = st1.pop();
	      System.out.print(entry.data + " ");
	      if(entry.left != null)
	        st2.push(entry.left);
	      if(entry.right != null)
	        st2.push(entry.right);
	      
	      while(!st2.isEmpty()) {
	        TreeNode entry2 = st2.pop();
	        System.out.print(entry2.data + " ");
	        if(entry2.right != null)
	          st1.push(entry2.right);
	        if(entry2.left != null)
	          st1.push(entry2.left);
	      }
	    }
	  }
	  
	  public static void main(String[] args) {
		
	    TreeNode root = new TreeNode(1);
			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(4);
			root.left.right = new TreeNode(5);
			root.right.left = new TreeNode(6);
			root.right.right = new TreeNode(7);
			//root.right.right.left = new TreeNode(8);
			//root.left.right.right = new TreeNode(9);
			//root.left.right.left = new TreeNode(10);
			
			System.out.print("Level Order Traversal(BFS): ");
			bfsDisplay(root);
			System.out.print("\nPreOrder Traversal(DFS): ");
			preorder(root);
			System.out.print("\nPostOrder Traversal: ");
			postorder(root);
			System.out.print("\nInOrder Traversal: ");
			inorder(root);
			
			System.out.println("\nHeight of Tree: "+heightOfTree(root));
			
			System.out.print("\nSpiral(Zigzag) Order Traversal: ");
			spiralOrZigZagOrder(root);/**/
	  }

}
