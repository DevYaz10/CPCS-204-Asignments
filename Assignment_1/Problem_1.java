/*
Course : CPCS 204
Name : YAZEED HASSAN TAIFI
University ID : 2536850
Section : CS1
Name of lab instructor : JAWAD AL-KHEMI
Problem number : 1
Assignment number : #1
*/

class Solution {
	/*
	 * A singly-linked list node is defined as:
	 * 
	 * class Node {
	 * int data; // data field
	 * Node next; // pointer to the next node
	 * 
	 * Node() {}
	 * Node(int data) { this.data = data; }
	 * Node(int data, Node next) { this.data = data; this.next = next; }
	 * }
	 */

	public static Node sortedInsert(Node head, Node node) {
		if (head == null || node.data <= head.data) {
			node.next = head;
			return node;
		}

		Node helpPtr = head;

		while (helpPtr.next != null && helpPtr.next.data < node.data) {
			helpPtr = helpPtr.next;
		}

		node.next = helpPtr.next;
		helpPtr.next = node;
		return head;

	}
}
