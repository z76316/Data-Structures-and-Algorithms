public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return 0;
    
        int max = 1;
        
        //from left to right
        int length = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i-1] < A[i]) {
                length++;
            } else {
                length = 1;
            }
            max = Math.max(max, length);
        }
        
        //from right to left
        length = 1;
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i-1] > A[i]) {
                length++;
            } else {
                length = 1;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}