public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if (nums1 == null || nums2 == null) return null;
        
        Arrays.sort(nums1);
        HashSet<Integer> resultHash = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!resultHash.contains(nums2[i]) && binarySearch(nums1, nums2[i])) {
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
    
    private boolean binarySearch (int[] array, int target) {
        if (array == null || array.length == 0) return false;
        int start = 0;
        int end = array.length-1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (array[start] == target) return true;
        if (array[end] == target) return true;
        return false;
    }
};