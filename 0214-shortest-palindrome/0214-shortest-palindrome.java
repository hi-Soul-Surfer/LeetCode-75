class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] lps = computeLPS(combined);
        int longestPrefix = lps[combined.length() - 1];
        String addOn = rev.substring(0, s.length() - longestPrefix);
        return addOn + s;
    }
    
    private int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        
        for (int i = 1; i < n; ) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
