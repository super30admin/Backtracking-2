
// Palindrome Partitioning (https://leetcode.com/problems/palindrome-partitioning/)

// Time Complexity: O(n * 2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: yes, took ref from lecture

import java.util.ArrayList;
import java.util.List;

public class palindromeForLoopRec {
    static List<List<String>> res;

    public static List<List<String>> partition(String s) {
        res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
            return res;

        helper(s, 0, new ArrayList<>());
        return res;
    }

    private static void helper(String s, int index, List<String> path) {
        // Base
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
        }

        // Recurse
        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (isPalindrome(subStr)) {

                // action
                path.add(subStr);

                // Recurssion
                helper(s, i + 1, path);

                path.remove(path.size() - 1);
            }

        }
    }

    private static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaba";
        System.out.println((partition(s)));
        // output: [[a, a, b, a], [a, aba], [aa, b, a]]
    }
}
