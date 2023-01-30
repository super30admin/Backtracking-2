// Time Complexity : O(2^N) Length of the string
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
        }
        // logic
        for (int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot, i + 1);
            if (isPalindrome(subStr)) {
                //Action
                path.add(subStr);
                //Recurse
                helper(s, i + 1, path);
                //Backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}