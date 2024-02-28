// Time complexity: O(2 ^ n)
// Space complexity: O(n) Recursive stack

// Approach: Using pivot from 0 to length - 1;
// Index from pivot to length - 1; Checking if substring
// from pivot to index is valid; if it is; move pivot to the index
// after the valid substring.

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        this.res = new ArrayList();
        dfs(0, s, new ArrayList());
        return res;
    }

    private void dfs(int pivot, String s, List<String> path) {
        if (pivot == s.length()) {
            res.add(new ArrayList(path));
            return;
        }

        // out of bounds should be handled
        for (int i = pivot; i < s.length(); i++) {
            String sub = s.substring(pivot, i + 1);
            if (!isPalindrome(sub)) {
                continue;
            }
            path.add(sub);
            dfs(i + 1, s, path);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}