public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0) return -1;
        if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) return -1;
        
        //state
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        
        //initialization
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                f[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                f[0][i] = 1;
            } else {
                break;
            }
        }
        
        //function
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        
        //answer
        return f[m-1][n-1];
    }
}