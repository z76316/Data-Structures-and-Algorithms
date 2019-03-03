public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if (nums1 == null || nums2 == null) return null;
        
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] temp = new int[Math.max(len1, len2)];
        int tempPos = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                if (tempPos == 0 || temp[tempPos - 1] != nums1[i]) {
                    temp[tempPos++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[tempPos];
        for (int k = 0; k < tempPos; k++) {
            result[k] = temp[k];
        }
        return result;
    }
};