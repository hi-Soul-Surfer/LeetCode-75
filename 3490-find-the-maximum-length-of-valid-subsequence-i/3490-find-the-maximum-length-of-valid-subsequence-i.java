class Solution {
    public int maximumLength(int[] nums) {
        int k = 2;
        int[][] dp = new int[k][k];
        int ans = 0;

        for (int x : nums) {
            x %= k;
            for (int j = 0; j < k; ++j) {
                int y = (j - x + k) % k;
                dp[x][y] = dp[y][x] + 1;
                ans = Math.max(ans, dp[x][y]);
            }
        }

        return ans;
    }
}
