public class Solution {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return 0;
        
        //state
        int n = A.length;
        int[] f = new int[n];
        
        //initialization
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        
        //function
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    f[i] = Math.min(f[i], f[j]+1);
                }
            }
        }
        
        //answer
        return f[n-1];
    }
}