public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if (nums1 == null || nums2 == null) return null;
        
        HashSet<Integer> hash1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hash1.add(nums1[i]);
        }
        HashSet<Integer> resultHash = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hash1.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
                resultHash.add(nums2[i]);
            }
        }
        
        int[] result = new int[resultHash.size()];
        int i = 0;
        for (int inter: resultHash) {
            result[i++] = inter;
        }
        return result;
    }
};