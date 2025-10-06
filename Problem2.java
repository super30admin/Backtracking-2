// Time Complexity : O(2^n) *n where n is the size of the input array
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Backtracking approach with for loop to create a substring at each pivot and i combination. Check if the string is palindrom.
 */
class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int pivot, List<String> path, List<List<String>> result) {
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            String curr = s.substring(pivot, i + 1);
            if (isPalindrom(curr)) {
                path.add(curr);
                backtrack(s, i + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrom(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }
}