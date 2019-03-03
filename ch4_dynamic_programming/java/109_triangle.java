public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) return -1;
        if (triangle[0] == null || triangle[0].length == 0) return -1;
        
        //state
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        //initialization
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i-1][0] + triangle[i][0];
            f[i][i] = f[i-1][i-1] + triangle[i][i];
        }
        
        //function
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i-1][j-1], f[i-1][j]) + triangle[i][j];
            }
        }
        
        //answer
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (f[n-1][i] < min) min = f[n-1][i];
        }
        return min;
    }
}