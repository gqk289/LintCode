public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k) {
            return 0;
        }
        int[][] dp = new int[k + 1][nums.length + 1];
        for (int i = 1; i <= k; i++) {
            int local = Integer.MIN_VALUE;
            for (int j = i; j <= nums.length; j++) {
                local = Math.max(local, dp[i - 1][j - 1]) + nums[j - 1];
                if (j == i) {
                    dp[i][j] = local;
                } else {
                    dp[i][j] = Math.max(local, dp[i][j - 1]);
                }
            }
        }
        return dp[k][nums.length];
    }
}
