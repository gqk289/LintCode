public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] nums = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    nums[j]++;
                } else {
                    nums[j] = 0;
                }
            }
            res = Math.max(res, maxHis(nums));
        }
        return res;
    }
    private int maxHis(int[] nums) {
        Stack<Integer> stack = new Stack();
        int res = 0;
        for (int i = 0; i <= nums.length; i++) {
            int temp = i == nums.length ? -1 : nums[i];
            while (!stack.isEmpty() && temp <= nums[stack.peek()]) {
                int h = nums[stack.pop()];
                int j = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, (i - j - 1) * h);
            }
            stack.push(i);
        }
        return res;
    }
}
