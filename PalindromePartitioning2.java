import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning (Variant)
 * LeetCode: https://leetcode.com/problems/palindrome-partitioning/
 *
 * Approach:
 * - Uses backtracking to explore all possible partitions of the input string.
 * - Tracks the count of characters included in the current path to ensure full coverage.
 * - At each step, checks if the current substring is a palindrome and recursively partitions the remaining string.
 * - Backtracking ensures all possible partitions are explored.
 *
 * Time Complexity: O(N * 2^N)
 *   - There are 2^(N-1) possible ways to partition a string of length N.
 *   - For each partition, checking if a substring is a palindrome takes O(N) time in the worst case.
 *   - So, overall complexity is O(N * 2^N).
 *
 * Space Complexity: O(N * 2^N)
 *   - The result list can contain up to 2^(N-1) partitions, each with up to N substrings.
 *   - The recursion stack can go up to N levels deep.
 */

public class PalindromePartitioning2 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, int povit, int idx, int count, List<String> path, List<List<String>> result) {
        //base
        if (idx == s.length()) {
            if (count == s.length()) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        helper(s, povit, idx + 1, count, path, result);
        String current = s.substring(povit, idx+1);
        if (isPalindrome(current)) {
            count += current.length();
            //action
            path.add(current);
            //recursion
            helper(s, idx + 1, idx + 1, count, path, result);
            //backtrack
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning2().partition("aab"));
    }
}
