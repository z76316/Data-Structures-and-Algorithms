public class Solution {
	/**
	* @param nums: An interger array sorted in ascending order
	* @param target: An interger
	* @return an interger
	*/
	public int findPosition(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;

		// A: start < end
		// B: start <= end
		// C: start + 1 < end 
		// start + 1 < end 相鄰就要退出循環, start = 1, end = 2
		while (start + 1 < end) {
			// start = 2^31 - 1, end = 2^31 -2
			// int's range: [-2^31, 2^31 -1]
			//int mid = (start + end) / 2;
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}

		}

		if (nums[start] == target) {
			return start;
		}
		if (nums[end] == target) {
			return end;
		}
		return -1
	}
}