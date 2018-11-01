public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int k = (A.length + B.length);
        if (k % 2 == 0) {
            return (findKth(A,0,B,0,k/2) + findKth(A,0,B,0,k/2 + 1)) / 2.0;
        } else {
            return findKth(A,0,B,0,k/2 + 1);
        }
    }
    private int findKth(int[] A, int indexA, int[] B, int indexB, int k) {
        if (indexA >= A.length) {
            return B[indexB + k - 1];
        }
        if (indexB >= B.length) {
            return A[indexA + k -1];
        }
        if (k == 1) {
            return Math.min(A[indexA], B[indexB]);
        }
        
        int valueA = Integer.MAX_VALUE;
        int valueB = Integer.MAX_VALUE;
        
        if (indexA + k / 2 - 1 < A.length) {
            valueA = A[indexA + k / 2 - 1];
        }
        if (indexB + k / 2 - 1 < B.length) {
            valueB = B[indexB + k / 2 - 1];
        }
        
        if (valueA < valueB) {
            return findKth(A, indexA + k / 2, B, indexB, k - k / 2);
            /*
            in order to remove the part before A[indexA + k / 2], the second input
            doesn't need to subtract 1.
            */
        } else {
            return findKth(A, indexA, B, indexB + k / 2, k - k / 2);
        }
    }
}