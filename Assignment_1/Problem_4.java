/*
Course : CPCS 204
Name : YAZEED HASSAN TAIFI
University ID : 2536850
Section : CS1
Name of lab instructor : JAWAD AL-KHEMI
Problem number : 4
Assignment number : #1
*/

class Solution
{
	/*
		A singly-linked list node is defined as:

		class Node {
			int data;		// data field
			Node next;		// pointer to the next node

			Node() {}
			Node(int data) { this.data = data; }
			Node(int data, Node next) { this.data = data; this.next = next; }
		}
	*/

	public static Node clone(Node head)
	{
		// Write your code here...
		if (head == null)
		{
			return null;
		}

		Node newHead = new Node(head.data);
		Node newHelpPtr = newHead;

		Node helpPtr = head.next;

		while (helpPtr != null)
		{
			newHelpPtr.next = new Node(helpPtr.data);
			newHelpPtr = newHelpPtr.next;
			helpPtr = helpPtr.next;
		}

		return newHead;
	}
}
