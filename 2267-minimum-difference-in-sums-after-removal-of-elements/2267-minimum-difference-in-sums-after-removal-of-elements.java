import java.util.*;

public class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] left = new long[len];
        long[] right = new long[len];

        // Max heap for smallest n sum from left
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sumLeft = 0;

        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            sumLeft += nums[i];

            if (maxHeap.size() > n) {
                sumLeft -= maxHeap.poll();
            }

            if (maxHeap.size() == n) {
                left[i] = sumLeft;
            }
        }

        // Min heap for largest n sum from right
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sumRight = 0;

        for (int i = len - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            sumRight += nums[i];

            if (minHeap.size() > n) {
                sumRight -= minHeap.poll();
            }

            if (minHeap.size() == n) {
                right[i] = sumRight;
            }
        }

        long minDiff = Long.MAX_VALUE;

        for (int i = n - 1; i < 2 * n; i++) {
            long diff = left[i] - right[i + 1];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
