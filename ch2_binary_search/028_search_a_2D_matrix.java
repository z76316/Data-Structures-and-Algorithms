public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] M, int target) {
        // write your code here
        if (M == null || M.length == 0) {
            return false;
        }
        int start = 0;
        int m = M[0].length;
        int end = m * M.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (M[mid/m][mid%m] == target) {
                return true;
            } else if (M[mid/m][mid%m] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (M[start/m][start%m] == target || M[end/m][end%m] == target) {
            return true;
        } else {
            return false;
        }
    }
}