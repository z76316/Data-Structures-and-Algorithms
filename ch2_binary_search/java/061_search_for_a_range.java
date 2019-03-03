public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] oops = {-1, -1};
        if (A == null || A.length == 0) {
            return oops;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int r1, r2;
        if (A[start] == target) {
            r1 = start;
        } else if (A[end] == target) {
            r1 = end;
        } else {
            return oops;
        }
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[end] == target) {
            r2 = end;
        } else if (A[start] == target) {
            r2 = start;
        } else {
            return oops;
        }
        int[] result = {r1, r2};
        return result;
    }
}