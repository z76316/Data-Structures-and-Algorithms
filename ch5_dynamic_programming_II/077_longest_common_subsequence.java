public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
        
        //state
        int n = A.length();
        int m = B.length();
        int[][] f = new int[n+1][m+1];
        
        //initialize
        for (int i = 0; i < n; i++) {
            f[i][0] = 0;
        }

        for (int i = 0; i < m; i++) {
            f[0][i] = 0;
        }
        
        //function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[j][i] = Math.max(f[j-1][i], f[j][i-1]);
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    f[j][i] = Math.max(f[j][i], f[j-1][i-1] + 1);
                }
            }
        }
        
        //answer
        return f[n][m];
    }
}