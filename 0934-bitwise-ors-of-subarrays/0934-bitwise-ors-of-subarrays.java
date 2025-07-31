import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);

            for (int p : prev) {
                curr.add(p | num);  // OR with previous results
            }

            prev = curr;  // Update for next iteration
            result.addAll(curr);  // Add current values to result set
        }

        return result.size();
    }
}
