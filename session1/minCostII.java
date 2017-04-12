public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // Write your code here
        int n = costs.length;
        int k = costs[0].length;
        int[] cache = costs[0].clone();
        for (int i = 1; i < n; i++) {
            int[] tCache = new int[k];
            for (int j = 0; j < k; j++) {
                tCache[j] = Integer.MAX_VALUE;
                for (int p = 0; p < k; p++) {
                    if (p == j) {
                        continue;
                    }
                    tCache[j] = Math.min(tCache[j], cache[p] + costs[i][j]);
                }
            }
            cache = tCache;
        }
        int min = Integer.MAX_VALUE;
        for (int n : cache) {
            min = Math.min(min, n);
        }
        return min;
    }
}
