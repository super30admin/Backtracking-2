import java.util.*;

public class PalindromePartitioning {
    // TC: O(N * 2 ^ N) where N is length of s
    // SC: O(N) where N is length of s
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(List<List<String>> res, String s, List<String> curr, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                curr.add(sub);
                backtrack(res, s, curr, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
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
