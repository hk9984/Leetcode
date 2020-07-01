package Coupang;

import java.util.LinkedList;
import java.util.Queue;

// Trying with iterative method, doesn't work for paths which start from left subtree and continue in
// right subtree or vice-versa

class TrNode {
	int data;
	TrNode left;
	TrNode right;
	TrNode prev;
	int chainLength;
	
	TrNode(int d) {
		data = d;
		chainLength = 0;
	}
}
public class longestPathWithSameValueIterative {
	
	public static int lengthLongest(TrNode root) {
		
		int length = 0;
		
		Queue<TrNode> queue = new LinkedList();
		root.prev = null;
		queue.add(root);
		root.chainLength = 0;
		
		while(!queue.isEmpty()) {
			TrNode entry = queue.poll();
			if(entry == null)
				continue;
			
			if(entry.prev != null && entry.data == entry.prev.data) {
				entry.chainLength = entry.prev.chainLength + 1;
				length = Math.max(length, entry.chainLength);
			}
			
			if(entry.left != null) {
				entry.left.prev = entry;
				queue.add(entry.left);
			}
			
			if(entry.right != null) {
				entry.right.prev = entry;
				queue.add(entry.right);
			}
		}
		
		return length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrNode root = new TrNode(1);
		root.left = new TrNode(2);
		root.left.left = new TrNode(3);
		root.left.right = new TrNode(4);
		root.left.right.left = new TrNode(5);
		root.left.right.right = new TrNode(6);
		root.right = new TrNode(7);
		root.right.right = new TrNode(8);
		root.right.right.right = new TrNode(8);
		root.right.right.right.right = new TrNode(10);
		root.right.right.right.left = new TrNode(8);
		root.right.right.right.left.left = new TrNode(8);
		root.right.right.right.left.right = new TrNode(13);
		
		System.out.println("Longest path with same value length: " + lengthLongest(root));

	}

}
