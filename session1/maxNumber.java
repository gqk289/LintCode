public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length + nums2.length < k) {
            return new int[0];
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= m && i <= k; i++) {
            int[] candidate = merge(maxArr(nums1, i), maxArr(nums2, k - i));
            if (greater(candidate, 0, res, 0)) {
                res = candidate;
            }
        }
        return res;
    }
    private boolean greater(int[] nums1, int idx1, int[] nums2, int idx2) {
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] != nums2[idx2]) {
                return nums1[idx1] > nums2[idx2];
            }
            idx1++;
            idx2++;
        }
        return idx1 == nums1.length ? false : true;
    }
    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < res.length) {
            int v1 = i == nums1.length ? Integer.MIN_VALUE : nums1[i++];
            int v2 = j == nums2.length ? Integer.MIN_VALUE : nums2[j++];
            res[k++] = Math.max(v1, v2);
        }
        return res;
    }
    private int[] maxArr(int[] nums, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (j > 0 && nums.length - i + j > k && nums[i] > res[j - 1]) {
                j--;
            }
            res[j++] = nums[i];
        }
        return res;
    }
}
