import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O (N*2^N)
 * Space Complexity: O(N)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * - explore all possible palindrome partitions of the input string
 * - If a substring is a palindrome, it is added to the current partition, and recursion continues from the next index.
 * - Non-palindromic substrings are pruned. 
 * - Template followed:
 * 1. Action
 * 2. Recurse
 * 3. Backtrack
 */

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {  // Prune non-palindrome substrings
                currentPartition.add(s.substring(start, end + 1));
                backtrack(s, end + 1, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1); // Backtrack
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // Your code here
    }
}