public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null || S.length() == 0) return 0;
        if (S == T) return 1;
        
        //state
        int n = S.length();
        int m = T.length();
        int[][] f = new int[n+1][m+1];
        
        //initialize
        for (int i = 0; i <= n; i++) {
            f[i][0] = 1;
        }
        
        //function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i-1][j];
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    f[i][j] += f[i-1][j-1];
                }
            }
        }
        
        //answer
        return f[n][m];
    }
};