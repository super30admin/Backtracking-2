import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N * 2 ^ N)
// Space Complexity : O(N) [Considering callstack space in the recusrsion]

// We perform recursion with backtrack on the path
// in each recursion we check if the next remaining string isPalindrome or not
// if next remaining string is palidronme then we recurse further with backtracking
// on end of remaining string we add path to our result

class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;

        helper(s, new ArrayList<>());

        return result;
    }

    private void helper(String remStr, List<String> path) {
        // base
        if (remStr.length() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for (int i = 0; i < remStr.length(); i++) {
            if (isPalindrome(remStr, 0, i)) {
                // action
                path.add(remStr.substring(0, i + 1));
                // recurse
                helper(remStr.substring(i + 1), path);
                // backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}