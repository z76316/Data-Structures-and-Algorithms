public class Solution {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null || s3 == null) return false;
        
        //state
        int n = s1.length();
        int m = s2.length();
        int p = s3.length();
        
        if (n + m != p) return false;
        
        boolean[][] f = new boolean[n+1][m+1];
        
        //initialize
        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            f[i][0] = (s1.charAt(i-1) == s3.charAt(i-1) && f[i-1][0]);
        }
        for (int i = 1; i <= m; i++) {
            f[0][i] = (s2.charAt(i-1) == s3.charAt(i-1) && f[0][i-1]);
        }
        
        //function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                    f[i][j] = (
                                (f[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1))) ||
                                (f[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1)))
                            );
            }
        }
        
        //answer
        return f[n][m];
    }
}