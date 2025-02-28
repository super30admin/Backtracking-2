// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for (int i = pivot; i < s.length(); i++) {
            String curr = s.substring(pivot, i+1);
            if (isPalindrome(curr)) {
                path.add(curr);
                helper(s, i+1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
