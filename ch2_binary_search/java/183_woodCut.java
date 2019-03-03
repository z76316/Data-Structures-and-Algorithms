public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) return 0;
        int start = 1;
        int end = 0;
        //int i = 1;
        //while (count(L, i) >= k) {
        //    i *= 2;
        //}
        for (int i : L) {
            end = Math.max(end, i);
        }
        //int start = i / 2;
        //int end = i;
        int mid, t;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            t = count(L, mid);
            if (t >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (count(L, end) >= k) return end;
        if (count(L, start) >= k) return start;
        return 0;
    }
    
    private int count (int[] L, int a){
        int t = 0;
        for (int e : L) {
            t += (e / a);
        }
        return t;
    }
}