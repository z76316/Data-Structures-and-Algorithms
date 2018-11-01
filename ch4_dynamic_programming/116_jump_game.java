public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return false;
        
        //state
        int n = A.length;
        boolean[] f = new boolean[n];
        
        //initialization
        f[0] = true;
        
        //function
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && j + A[j] >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        //answer
        return f[n-1];
        
    }
}