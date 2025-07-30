package Leetcode;

public class depthOfAGivenNode {

    public static int depthOfNode(TreeNode root, int val) {
		if(root == null)
			return -1;

		if(root.data == val)
			return 0;

		int leftDepth = depthOfNode(root.left, val);
		int rightDepth = depthOfNode(root.right, val);

		if(leftDepth != -1)
			return leftDepth + 1;
		if(rightDepth != -1)
			return rightDepth + 1;

		return -1;
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


        System.out.println("Depth of given node 1 : " + depthOfNode(root, 1));
        System.out.println("Depth of given node 2 : " + depthOfNode(root, 2));
        System.out.println("Depth of given node 3 : " + depthOfNode(root, 3));
        System.out.println("Depth of given node 4 : " + depthOfNode(root, 4));
        System.out.println("Depth of given node 5 : " + depthOfNode(root, 5));
        System.out.println("Depth of given node 6 : " + depthOfNode(root, 6));
        System.out.println("Depth of given node 7 : " + depthOfNode(root, 7));
        System.out.println("Depth of given node 8 : " + depthOfNode(root, 8));
        System.out.println("Depth of given node 9 : " + depthOfNode(root, 9));

	}

}
