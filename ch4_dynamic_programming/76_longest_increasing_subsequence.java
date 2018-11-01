public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        
        //state
        int n = nums.length;
        int[] f = new int[n];
        
        //initialization
        for (int i = 0; i < n; i++) {
            f[i] = 1;
        }
        
        //function
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
        }
        
        //answer
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (f[i] > max) max = f[i];
        }
        return max;
    }
}