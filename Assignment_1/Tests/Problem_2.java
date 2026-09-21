/*
Course : CPCS 204
Name : YAZEED HASSAN TAIFI
University ID : 2536850
Section : CS1
Name of lab instructor : JAWAD AL-KHEMI
Problem number : 2
Assignment number : #1
*/

/*
	Given a binary array, in-place sort it in linear time and constant
	space. The output should contain all zeroes, followed by all ones.

	Input : [1, 0, 1, 0, 1, 0, 0, 1]
	Output: [0, 0, 0, 0, 1, 1, 1, 1]

	Input : [1, 1]
	Output: [1, 1]

	`vector<int> &nums` becomes `int[] nums` in Java: an array is already a
	reference, so changes made inside the method are visible to the caller.
	That is also the "in-place" requirement: mutate nums, do not return a
	new array.
*/
class Solution
{
	public static void sortArray(int[] nums)
	{
		// pass 1: count how many zeroes the array holds
		int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] <= nums[i]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                }
            }
        }
	}
}

class Problem_2
{
	static void runTest(int[] input, int[] expected)
	{
		int[] nums = input.clone();

		System.out.println("Input:  " + java.util.Arrays.toString(nums));

		Solution.sortArray(nums);

		System.out.println("Output: " + java.util.Arrays.toString(nums));
		System.out.println(java.util.Arrays.equals(nums, expected) ? "PASS" : "FAIL");
		System.out.println();
	}

	public static void main(String[] args)
	{
		// the two sample cases
		runTest(new int[] { 1, 0, 1, 0, 1, 0, 0, 1 }, new int[] { 0, 0, 0, 0, 1, 1, 1, 1 });
		runTest(new int[] { 1, 1 }, new int[] { 1, 1 });

		// edge cases
		runTest(new int[] { }, new int[] { });					// empty array
		runTest(new int[] { 0 }, new int[] { 0 });				// single zero
		runTest(new int[] { 1 }, new int[] { 1 });				// single one
		runTest(new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 });	// all zeroes
		runTest(new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 });	// all ones
		runTest(new int[] { 1, 0 }, new int[] { 0, 1 });		// swapped pair
		runTest(new int[] { 0, 1 }, new int[] { 0, 1 });		// already sorted
		runTest(new int[] { 0, 1, 1, 0, 0, 1, 1, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 });	// longer, uneven counts (6 zeroes, 4 ones)
	}
}
