public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == word2) return 0;
        
        //state
        int n = word1.length();
        int m = word2.length();
        int[][] f = new int[n+1][m+1];
        
        //initialize
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            f[0][i] = i;
        }
        
        //function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.min(f[i-1][j] + 1, f[i][j-1] + 1);
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }
        
        //answer
        return f[n][m];
    }
}