/*
Course : CPCS 204
Name : YAZEED HASSAN TAIFI
University ID : 2536850
Section : CS1
Name of lab instructor : JAWAD AL-KHEMI
Problem number : 3
Assignment number : #1
*/

class Solution
{
	/* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

	public static Pair<Integer, Integer> findPair(int[] nums, int target)
	{
		// Write your code here...
		for (int i = 0; i < nums.length; i++) {
			int tempSum = 0;
			for (int j = 1; j < nums.length; j++) {
				tempSum = nums[i] + nums[j];
				if (i != j && tempSum == target) {
					return Pair.of(nums[i], nums[j]);
				}
			}
		}
		return null;
	}
}
