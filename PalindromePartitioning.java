
/**
 * Time Complexity: O(n * 2^n) palindrome and recursion tree 
 * Space Complexity: O(n) recursion stack
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> result;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // action
                currentPartition.add(s.substring(start, end + 1));
                // recurse
                backtrack(s, end + 1, currentPartition, result);
                // backtrack
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

}
