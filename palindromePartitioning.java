// Time Complexity :exponential
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int index, List<String> path) {
        // edge
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (isPalindrome(sub)) {
                path.add(sub);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }

        }

    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char schar = s.charAt(start);
            char endchar = s.charAt(end);
            if (schar != endchar)
                return false;
            start++;
            end--;
        }
        return true;
    }
}