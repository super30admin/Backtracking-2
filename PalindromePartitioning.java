import java.util.*;

// Backtracking O(n * 2^n) time, O(n) space
class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(0, s, new ArrayList<>());
        return ans;
    }

    private void helper(int idx, String s, List<String> path) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String substring = s.substring(idx, i+1);
            if (isPalindrome(substring)) {
                path.add(substring);
                helper(i+1, s, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}