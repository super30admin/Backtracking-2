// Time Complexity: O(2^n) where n is the length of the string, as we explore all possible partitions.
// Space Complexity: O(n) for the recursion stack and the result list, where n is the length of the string.
// LeetCode: https://leetcode.com/problems/palindrome-partitioning/

/**
 * Generates all possible palindrome partitions of a given string.
 * Uses backtracking to explore every substring and includes it if it's a palindrome.
 * Returns a list of all valid partition combinations where each substring is a palindrome.
 */


import java.util.*;

public class PalindromePartioning {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<List<String>>();
        helper(s, 0, new ArrayList<String>());
        return result;
    }

    public void helper(String s, int pivot, ArrayList<String> path) {

        if(pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot, i + 1);
            if (isPalindrome(subStr)) {
                //action
                path.add(subStr);

                //recurse
                helper(s, i + 1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
