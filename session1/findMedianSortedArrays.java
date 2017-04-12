class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (find(A, 0, A.length - 1, B, 0, B.length - 1, len / 2) + find(A, 0, A.length - 1, B, 0, B.length - 1, len / 2 + 1)) / 2.0;
        } else {
            return find(A, 0, A.length - 1, B, 0, B.length - 1, len / 2 + 1);
        }
    }
    private int find(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        if (s1 >= e1) {
            return nums2[s2 + k - 1];
        } else {
            return nums1[s1 + k - 1];
        }
        int mid = k / 2 - 1;
        int key1 = s1 + mid > e1 ? Integer.MAX_VALUE : nums1[s1 + mid];
        int key2 = s2 + mid > e2 ? Integer.MAX_VALUE : nums2[s2 + mid];
        if (key1 < key2) {
            return find(nums1, s1 + mid + 1, e1, nums2, s2, e2, k - mid - 1);
        } else {
            return find(nums1, s1, e1, nums2, s2 + mid + 1, e2, k - mid - 1);
        }
    }
}
