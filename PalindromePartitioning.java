
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  Yes, had to learn

/*
 * 131. Palindrome Partitioning
 * 
 * for loop will take care of don't choose
 * subString will be from pivot(static) to i+1
 * check if subString is palindrome, if palindrome move forward with adding paths., if we reach to end of string we have reached all possible palindromes
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());

        return result;

    }

    private void helper(String s, int pivot, List<String> path) {
        // base case
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic

        for (int i = pivot; i < s.length(); i++) {
            String subString = s.substring(pivot, i + 1);
            if (checkIfPalindrome(subString)) {
                path.add(subString);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }

        }
    }

    // check if palindrome
    private boolean checkIfPalindrome(String s) {
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
