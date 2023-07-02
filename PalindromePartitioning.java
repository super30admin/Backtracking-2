// Time Complexity : O(2^n) Actual: O(n*2^n) [O(n) for checking if it is a palindrome]
// Space Complexity : O(n) n is the height of the tree
import java.util.ArrayList;
import java.util.List;

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
            return;
        }
        for (int i = pivot; i < s.length(); i++) {
            String sub = s.substring(pivot, i + 1);
            if (isPalindrome(sub)) {
                path.add(sub);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}