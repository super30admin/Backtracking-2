// Time Complexity : O(n * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class PalindromePartitioning {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int index, List<String> list) {
        //  base
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        //  logic
        for (int i = index; i < s.length(); ++i) {
            String subString = s.substring(index, i + 1);
            if (isPalindrome(subString)) {
                list.add(subString);
                helper(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length() - 1;

        while (l <= h) {
            if (s.charAt(l) != s.charAt(h))
                return false;

            l++;
            h--;
        }

        return true;
    }
}
