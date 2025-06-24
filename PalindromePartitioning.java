
import java.util.*;

// Time Complexity : O(2^n * n) where n is the length of the input string
// Space Complexity : O(n) for the recursion stack and the result list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// For loop based recursion
public class PalindromePartitioning {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, new ArrayList<>(), 0);
        return result;
    }

    private void helper(String s, List<String> path, int pivot) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for (int i = pivot; i < s.length(); i++) {
            String curr = s.substring(pivot, i + 1);

            if (isPalindrome(curr)) {
                path.add(curr);
                helper(s, path, i + 1);
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s) {
        if (s.isEmpty())
            return false;
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}

// For loop based recursion with backtracking
// Time Complexity : O(2^n * n) where n is the length of the input string
// Space Complexity : O(n) for the recursion stack and the result list
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, new ArrayList<>(), 0);
        return result;
    }

    private void helper(String s, List<String> path, int pivot) {
        // base
        if (pivot == s.length()) {
            result.add(path);
            return;
        }

        // logic
        for (int i = pivot; i < s.length(); i++) {
            String curr = s.substring(pivot, i + 1);

            if (isPalindrome(curr)) {
                List<String> li = new ArrayList<>(path);
                li.add(curr);
                helper(s, li, i + 1);
                // li.remove(li.size()-1); we already have the filter condition
            }
        }

    }

    private boolean isPalindrome(String s) {
        if (s.isEmpty())
            return false;
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}
