/*
Course : CPCS 204
Name : YAZEED HASSAN TAIFI
University ID : 2536850
Section : CS1
Name of lab instructor : JAWAD AL-KHEMI
Problem number : 4
Assignment number : #1
*/

/*

Given a singly linked list of integers, return a complete copy of it. The solution should return a new linked list which is identical to the given list in terms of its structure and contents, and it should not use any nodes of the list.

Input : 1 —> 2 —> 3 —> 4 —> 5 —> null
Output: 1 —> 2 —> 3 —> 4 —> 5 —> null

*/

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
class Node
{
	int data;		// data field
	Node next;		// pointer to the next node

	Node() {}
	Node(int data) { this.data = data; }
	Node(int data, Node next) { this.data = data; this.next = next; }
}

class Solution
{
	public static Node clone(Node head)
	{
		// an empty list has no nodes to copy
		if (head == null)
		{
			return null;
		}

		// the first node of the copy is new, and holds the first value
		Node newHead = new Node(head.data);
		Node newHelpPtr = newHead;

		// walk the rest of the original, making one new node per value
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

class Problem_4
{
	static Node buildList(int... values)
	{
		Node head = null;
		Node tail = null;

		for (int value : values)
		{
			Node fresh = new Node(value);

			if (head == null)
			{
				head = fresh;
				tail = fresh;
			}
			else
			{
				tail.next = fresh;
				tail = fresh;
			}
		}

		return head;
	}

	// prints at most `limit` nodes, so a copy that loops back on itself shows
	// up as "(does not end)" instead of hanging the program
	static void printList(Node head, int limit)
	{
		Node current = head;

		for (int i = 0; i < limit && current != null; i++)
		{
			System.out.print(current.data + " -> ");
			current = current.next;
		}

		System.out.println(current == null ? "null" : "... (list does not end)");
	}

	static int length(Node head)
	{
		int size = 0;

		for (Node current = head; current != null; current = current.next)
		{
			size++;
		}

		return size;
	}

	// true if `target` is one of the nodes of the list that starts at `head`
	static boolean isNodeOf(Node head, Node target)
	{
		for (Node current = head; current != null; current = current.next)
		{
			if (current == target)
			{
				return true;
			}
		}

		return false;
	}

	/*
		returns "" when the copy is right, or a short reason when it is not.
		The copy has to satisfy:
			- same number of nodes as the original (structure)
			- same values, in the same order (contents)
			- NONE of the original's nodes, every node of the copy is new
			- the original list must still be intact afterwards
	*/
	static String checkClone(Node original, Node copy)
	{
		int size = length(original);

		if (size == 0)
		{
			return (copy == null) ? "" : "expected null for an empty list";
		}

		if (copy == null)
		{
			return "got null, expected a copy of " + size + " node(s)";
		}

		Node a = original;
		Node b = copy;

		for (int i = 0; i < size; i++)
		{
			if (b == null)
			{
				return "copy is shorter than the original (ended after " + i + " node(s))";
			}

			if (isNodeOf(original, b))
			{
				return "copy reuses a node of the original list at position " + i;
			}

			if (a.data != b.data)
			{
				return "value mismatch at position " + i + ": " + a.data + " vs " + b.data;
			}

			a = a.next;
			b = b.next;
		}

		if (b != null)
		{
			return "copy is longer than the original";
		}

		if (a != null)
		{
			return "the original list was damaged: it is now shorter";
		}

		return "";
	}

	static void runTest(int... values)
	{
		Node original = buildList(values);

		System.out.print("Input:  ");
		printList(original, values.length);

		Node copy = Solution.clone(original);

		System.out.print("Output: ");
		printList(copy, values.length + 5);

		String reason = checkClone(original, copy);

		System.out.println(reason.isEmpty() ? "PASS" : "FAIL - " + reason);

		System.out.print("Original after the call: ");
		printList(original, values.length);
		System.out.println();
	}

	public static void main(String[] args)
	{
		// the sample case
		runTest(1, 2, 3, 4, 5);

		// edge cases
		runTest();						// empty list
		runTest(42);					// single node
		runTest(5, 5, 5);				// duplicate values
		runTest(-1, 0, 7);				// negative numbers
		runTest(1, 2, 3, 4, 5, 6, 7, 8);	// longer list
	}
}
