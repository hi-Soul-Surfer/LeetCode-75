import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        HashSet<Character> window = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!window.contains(c)) {
                window.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                window.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}
