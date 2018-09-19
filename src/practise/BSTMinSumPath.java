package practise;

public class BSTMinSumPath {
	
	static class Node{
		int val;
		Node left;
		Node right;
		
		Node(int val){
			this.val = val;
		}
	}
	
	public static int minPathSum(Node root) {
		int sum = 0;
		if(root == null) return 0;
		if(root.left == null && root.right == null) return root.val;
		sum += root.val;
		if(root.left == null) {
			sum += minPathSum(root.right);
		}else if(root.right == null) {
			sum += minPathSum(root.left);
		}else {
			sum += Math.min(minPathSum(root.left), minPathSum(root.right));
		}
		return sum;
	}
	
	public static void main(String []args) {
		Node bst = new Node(10);
		Node node = bst;
		node.left = new Node(7);
		node.right = new Node(11);
		node.right.right = new Node(12);
		node = node.left;
		node.left = new Node(6);
		node.right = new Node(9);
		node = node.left;
		node.left = new Node(5);
		int result = minPathSum(bst);
		System.out.println(result);
	}
}
