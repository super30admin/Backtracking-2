// Time Complexity : O(n^4 + 2^n) n is length of string
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach : 2d dp to contain scanned elements so far

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        // this keeps track of all the scanned strings so far
        boolean[][] dp = new boolean[s.length()][s.length()];

        // get every possible partitioning for a string then scaning all the
        // partitioning
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                // check if palindrome
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {

        // base case
        if (pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                // action
                path.add(s.substring(pos, i + 1));
                // recursion
                helper(res, path, dp, s, i + 1);
                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }
}