// backtracking based for loop approach,

// Time Complexity : O(2^n),length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Using the backtracking based for loop approach, MOve from pivot to the end of
 * the string.
 * Create substring and check if palindrome, if so then we add it to the path and run the recursive call
 */
class Solution {
    List<List<String>> result;

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
                // action
                path.add(subStr);
                // recurse
                helper(s, i + 1, path);
                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}