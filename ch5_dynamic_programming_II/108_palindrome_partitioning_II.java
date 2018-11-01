public class Solution {
    /**
     * @param s: A string
     * @return: An integer
     */
    private boolean[][] getIsPalindrome (String s) {
        //initialize
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            }
        }
        
        //function
        for (int length = 2; length < n; length++) {
            for (int start = 0; start + length < n; start++) {
                isPalindrome[start][start+length] = isPalindrome[start+1][start+length-1] && s.charAt(start) == s.charAt(start+length);
            }
        }
        return isPalindrome;
    }
     
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) return 0;
        
        //state
        int n = s.length();
        int[] f = new int[n+1];
        
        //initialize
        boolean[][] isPalindrome = getIsPalindrome(s);
        f[0] = 0;
        
        //function
        for (int i = 1; i <= n; i++) {
            f[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i-1]) {
                    f[i] = Math.min(f[i], f[j]+1);
                }
            }
        }
        
        //answer
        return f[n] - 1;
    }
}