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
	/*
		Given a sorted list in increasing order and a single node, insert the
		node into its correct sorted position in the list.

		Input: List = 2 -> 4 -> 6 -> 8 -> null, Node = 9
		Output: 2 -> 4 -> 6 -> 8 -> 9 -> null

		Input: List = 2 -> 4 -> 6 -> 8 -> null, Node = 1
		Output: 1 -> 2 -> 4 -> 6 -> 8 -> null

		Input: List = 1 -> 2 -> 4 -> 6 -> 8 -> 9 -> null, Node = 5
		Output: 1 -> 2 -> 4 -> 5 -> 6 -> 8 -> 9 -> null

		Java has no `Node* &head`, so instead of taking the head by reference
		the method RETURNS the (possibly new) head and the caller re-assigns it:
			head = Solution.sortedInsert(head, node);
	*/
	public static Node sortedInsert(Node head, Node node)
	{
		// empty list, or the new node belongs before the current head
		if (head == null || node.data <= head.data)
		{
			node.next = head;
			return node;
		}

		Node helpPtr = head;

		// walk to the last node that belongs before the new node
		while (helpPtr.next != null && helpPtr.next.data < node.data)
		{
			helpPtr = helpPtr.next;
		}

		// splice the new node in after helpPtr
		node.next = helpPtr.next;
		helpPtr.next = node;
		return head;
	}
}

class Problem_1
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

	static void printList(Node head)
	{
		Node current = head;

		while (current != null)
		{
			System.out.print(current.data + " -> ");
			current = current.next;
		}

		System.out.println("null");
	}

	static int[] toArray(Node head)
	{
		int size = 0;

		for (Node current = head; current != null; current = current.next)
		{
			size++;
		}

		int[] values = new int[size];
		int index = 0;

		for (Node current = head; current != null; current = current.next)
		{
			values[index++] = current.data;
		}

		return values;
	}

	static void runTest(int[] listValues, int newValue, int[] expected)
	{
		Node head = buildList(listValues);

		System.out.print("Input:  ");
		printList(head);
		System.out.println("Node = " + newValue);

		head = Solution.sortedInsert(head, new Node(newValue));

		System.out.print("Output: ");
		printList(head);
		System.out.println(java.util.Arrays.equals(toArray(head), expected) ? "PASS" : "FAIL");
		System.out.println();
	}

	public static void main(String[] args)
	{
		// the three sample cases
		runTest(new int[] { 2, 4, 6, 8 }, 9, new int[] { 2, 4, 6, 8, 9 });
		runTest(new int[] { 2, 4, 6, 8 }, 1, new int[] { 1, 2, 4, 6, 8 });
		runTest(new int[] { 1, 2, 4, 6, 8, 9 }, 5, new int[] { 1, 2, 4, 5, 6, 8, 9 });

		// edge cases
		runTest(new int[] { }, 5, new int[] { 5 });								// empty list
		runTest(new int[] { 5 }, 5, new int[] { 5, 5 });						// equal to head
		runTest(new int[] { 5 }, 1, new int[] { 1, 5 });						// before head
		runTest(new int[] { 5 }, 9, new int[] { 5, 9 });						// after tail
		runTest(new int[] { 1, 3, 3, 9 }, 3, new int[] { 1, 3, 3, 3, 9 });		// duplicate in the middle
	}
}
