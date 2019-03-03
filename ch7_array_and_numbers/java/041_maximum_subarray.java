public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        
        int maxSum = Integer.MIN_VALUE;
        int minPrefixSum = 0;
        int len = nums.length;
        int currSum = 0;
        for (int i = 0; i < len; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, currSum);
        }
        return maxSum;
    }
}