import java.util.*;
// Time Complexity : O(2^n) where n is the length string.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
public class PalindromePartitioning {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList();
        // null check
        if (s.length() == 0 || s == null)
            return result;
        helper(s, 0, new ArrayList());
        return result;
    }

    private void helper(String s, int index, List<String> path) {
        // base
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for (int i = 0; i < s.length(); i++) {
            // first part of subString
            String sub = s.substring(index, i + 1);
            // check if it is a palindrome
            if (isPalindrome(sub)) {
                // if yes, add to path and continue iteration on the next half
                // action
                path.add(sub);
                // recurse
                helper(s.substring(i + 1), 0, path);
                // backtrack
                path.remove(path.size() - 1);
            }
            // else, go to next substring...i.e, continue loop
        }
    }

    // to check if palindrome
    private boolean isPalindrome(String s) {
        // null check
        if (s == null || s.length() == 0)
            return false;
        if (s.length() == 1)
            return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
