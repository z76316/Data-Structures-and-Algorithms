public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0) return true;
        //state
        int n = s.length();
        boolean[] f = new boolean[n+1];
        
        //initialize
        f[0] = true;
        int max = Integer.MIN_VALUE;
        for (String e: dict) {
            max = Math.max(max, e.length());
        }
        
        //function
        for (int i = 1; i <= n; i++) {
            //where j represent the distance between s[i] and s[i-j]
            for (int j = 1; j <= i && j <= max; j++) {
                if (f[i-j]) {
                    String sub = s.substring(i-j,i);
                    if (dict.contains(sub)) {
                        f[i] = true;
                        break;
                    }
                }
            }
        }
        
        //answer
        return f[n];
    }
}