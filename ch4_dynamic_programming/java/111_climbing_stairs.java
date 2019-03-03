public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n < 2) return n;
        int result = 0;
        int last = 1;
        int lastlast = 1;
        for (int i = 2; i <= n; i++) {
            result = last + lastlast;
            lastlast = last;
            last = result;
        }
        return result;
    }
}