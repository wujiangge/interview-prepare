package practise;

public class InsertIntoCircleLinkedList {
	static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
		}
	}
	
	// may have duplicated values
	// list is sorted
	// node passed may not be head
	// case: node is null
	// case: val is min or max
	static public Node insert(Node node, int val) {
		// list is empty
		if(node == null) return new Node(val);
		// list only has one node
		if(node == node.next){
			node.next = new Node(val);
			node.next.next = node;
			return node.val <= node.next.val ? node : node.next;
		}
		Node start = node;
		do{
			// val is min or max
			if(node.next.val < node.val && (val > node.val || val < node.next.val)) {
				Node tmp = new Node(val);
				tmp.next = node.next;
				node.next = tmp;
				return val > node.val ? tmp.next : tmp;
			}
			// normal case
			if(val > node.val && val < node.next.val) {
				Node tmp = new Node(val);
				tmp.next = node.next;
				node.next = tmp;
			}
			if(node.next.val < node.val) {
				return node.next;
			}
			node = node.next;
		}while(node != start);
		//if all item has same val
		Node tmp = new Node(val);
		tmp.next = node.next;
		node.next = tmp;
		return val > node.val ? tmp.next : tmp;
	}
}
