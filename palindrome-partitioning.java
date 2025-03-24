// Time Complexity : O(N * 2 ^ N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    // TC = O(N * 2 ^ N), N for checking the palindromability of s at each level, 2 ^ N for each level, we are making choice, choose a or choose aa, or choose aab.. aaba
    // SC = O(H)
    // for loop based recursion
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int index, List<String> path) {
        // base
        if(index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for(int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if(isPalindrome(sub)) {
                path.add(sub); // action
                helper(s, i + 1, path); // recurse
                path.remove(path.size() - 1); // backtrack
            }
        }
    }
    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}