public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int posA = m - 1;
        int posB = n -1;
        int pointer = m + n - 1;
        
        while (posA >= 0 && posB >= 0) {
            if (A[posA] > B[posB]) {
                A[pointer--] = A[posA--];
            } else {
                A[pointer--] = B[posB--];
            }
        }
        
        while (posB >= 0) {
            A[pointer--] = B[posB--];
        }
    }
}