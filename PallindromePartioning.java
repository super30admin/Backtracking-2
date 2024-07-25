// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class PallindromePartioning {
    // Using for loop based recursion
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, int pivot, List<String> path, List<List<String>> result) {
        // base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < s.length(); i++) {
            String currentSubStr = s.substring(pivot, i + 1);
            // check for pallindrome
            if (isPallindrome(currentSubStr)) {
                // Action
                path.add(currentSubStr);
                // Recurse
                helper(s, i + 1, path, result);
                // backtrack
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isPallindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

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