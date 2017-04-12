class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        int n = nums.length;
        int bucket = (max - min) / (n - 1);
        int[] maxArr = new int[n - 1];
        int[] minArr = new int[n - 1];
        Arrays.fiil(maxArr, Integer.MIN_VALUE);
        Arrays.fill(minArr, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (nums[i] == min || nums[i] == max) {
                continue;
            }
            int index = (nums[i] - min) / bucket;
            maxArr[index] = Math.max(maxArr[index], nums[i]);
            minArr[index] = Math.min(minArr[index], nums[i]);
        }
        int pre = min;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (minArr[i] == Integer.MAX_VALUE || maxArr[i] == Integer.MIN_VALUE) {
                continue;
            }
            res = Math.max(res, minArr[i] - pre);
            pre = maxArr[i];
        }
        return Math.max(res, max - pre);
    }
}
