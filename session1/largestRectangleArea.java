public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        Stack<Integer> stack = new Stack();
        int res = 0;
        for (int i = 0; i <= height.length; i++) {
            int h = i == height.length ? 0 : height[i];
            while (!stack.isEmpty() && h <= height[stack.peek()]) {
                int val = height[stack.pop()];
                int j = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, (i - j - 1) * val);
            }

            stack.push(i);
        }
        return res;
    }
}
