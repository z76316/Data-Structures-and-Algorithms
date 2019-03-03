public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) return -1;
        if (grid[0] == null || grid[0].length == 0) return -1;
        
        //state
        int row = grid.length;
        int col = grid[0].length;
        int[][] f = new int[row][col];
        
        //initialization
        f[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            f[i][0] = f[i-1][0] + grid[i][0];
            for (int j = 1; j < col; j++) {
                f[0][j] = f[0][j-1] + grid[0][j];
            }
        }
        
        //function
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];
            }
        }
        
        //answer
        return f[row-1][col-1];
    }
}