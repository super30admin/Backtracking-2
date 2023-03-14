class Solution {
    boolean[][] dp;
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) {
            return result;
        }
        int n = s.length();
        dp = new boolean[n][n];
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int start, List<String> curr) {
        if(start >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int end = start; end < s.length(); end++) {
            if(s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end ] = true;
                curr.add(s.substring(start, end + 1));
                helper(s, end + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}