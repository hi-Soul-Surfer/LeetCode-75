class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int[] maxLeft = new int[n + 1], maxRight = new int[n + 1];
        maxLeft[0] = gaps[0];
        for (int i = 1; i <= n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], gaps[i]);
        }
        maxRight[n] = gaps[n];
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int currDur = endTime[i] - startTime[i];
            int adjacentGaps = gaps[i] + gaps[i + 1];
     
            int avail = Math.max(
                i > 0 ? maxLeft[i - 1] : 0,
                i + 2 <= n ? maxRight[i + 2] : 0
            );
            if (currDur <= avail) {
                ans = Math.max(ans, adjacentGaps + currDur);
            } else {
                ans = Math.max(ans, adjacentGaps);
            }
        }
        return ans;
    }
}
