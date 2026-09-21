/*
Course : CPCS 204
Name : YAZEED HASSAN TAIFI
University ID : 2536850
Section : CS1
Name of lab instructor : JAWAD AL-KHEMI
Problem number : 3
Assignment number : #1
*/

/*

Given an unsorted integer array, find a pair with the given sum in it.

• Each input can have multiple solutions. The output should match with either one of them.

Input : nums[] = [8, 7, 2, 5, 3, 1], target = 10
Output: (8, 2) or (7, 3)

• The solution can return pair in any order. If no pair with the given sum exists, the solution should return null.

Input : nums[] = [5, 2, 6, 8, 1, 9], target = 12
Output: null

*/

class Solution {
	/*
	 * The Pair<U, V> class have
	 * 1. Two member variables, first and second.
	 * 2. Factory method `Pair.of(U, V)` for creating its immutable instance.
	 * 3. equals() and hashCode() methods overridden.
	 */

	public static Pair<Integer, Integer> findPair(int[] nums, int target) {
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

		// placeholder so the file compiles; answers "no pair" for everything
		return null;
	}
}

class Problem_3 {
	static String format(Pair<Integer, Integer> pair) {
		return (pair == null) ? "null" : "(" + pair.first + ", " + pair.second + ")";
	}

	/*
	 * The problem allows any of the valid pairs, so we cannot compare against
	 * one fixed answer. Instead we check the answer's properties:
	 * - the two values must add up to target
	 * - both values must come from two DIFFERENT positions in nums
	 * - null is only legal when no pair exists
	 */
	static boolean isValidPair(int[] nums, int target, Pair<Integer, Integer> pair, boolean expectPair) {
		if (pair == null) {
			return !expectPair;
		}

		if (!expectPair) {
			return false;
		}

		int a = pair.first;
		int b = pair.second;

		if (a + b != target) {
			return false;
		}

		// find where the first value sits in nums
		int firstIndex = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == a) {
				firstIndex = i;
				break;
			}
		}

		if (firstIndex == -1) {
			return false;
		}

		// the second value has to sit somewhere else
		for (int i = 0; i < nums.length; i++) {
			if (i != firstIndex && nums[i] == b) {
				return true;
			}
		}

		return false;
	}

	static void runTest(int[] nums, int target, boolean expectPair) {
		System.out.println("Input:  " + java.util.Arrays.toString(nums) + ", target = " + target);

		Pair<Integer, Integer> pair = Solution.findPair(nums, target);

		System.out.println("Output: " + format(pair));
		System.out.println(isValidPair(nums, target, pair, expectPair) ? "PASS" : "FAIL");
		System.out.println();
	}

	public static void main(String[] args) {
		// the two sample cases (the first one may answer (8, 2) or (7, 3))
		runTest(new int[] { 8, 7, 2, 5, 3, 1 }, 10, true);
		runTest(new int[] { 5, 2, 6, 8, 1, 9 }, 12, false);

		// edge cases
		runTest(new int[] {}, 5, false); // empty array
		runTest(new int[] { 5 }, 5, false); // one element cannot make a pair
		runTest(new int[] { 3, 3 }, 6, true); // equal values, two different positions
		runTest(new int[] { 0, 0 }, 0, true); // pair of zeroes
		runTest(new int[] { -7, 1, 5, 2 }, -2, true); // negative numbers
		runTest(new int[] { 1, 2, 3 }, 6, false); // sums exist, none reaches the target
		runTest(new int[] { 4, 4, 4 }, 8, true); // duplicates
		runTest(new int[] { 2, 2, 3, 4, 5 }, 4, true); // pair made of two equal values
	}
}
