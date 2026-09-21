/*
Course : CPCS 204
Name : YAZEED HASSAN TAIFI
University ID : 2536850
Section : CS1
Name of lab instructor : JAWAD AL-KHEMI
Problem number : 2
Assignment number : #1
*/

class Solution
{
	public static void sortArray(int[] nums)
	{
		// Write your code here...
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
