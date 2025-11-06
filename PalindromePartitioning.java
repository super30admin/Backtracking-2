import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 * LeetCode: https://leetcode.com/problems/palindrome-partitioning/
 *
 * Approach:
 * - Uses backtracking to explore all possible partitions of the input string.
 * - At each step, it checks if the current substring is a palindrome.
 * - If it is, it adds the substring to the current path and recursively partitions the remaining string.
 * - When the end of the string is reached, the current path is added to the result.
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
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;

    }

    private void helper(String s, int pivot, List<String> path, List<List<String>> result) {
        //base
        if (pivot == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for (int i = pivot; i < s.length(); i++) {
            String current = s.substring(pivot, i + 1);
            if (isPalindrome(current)) {
                //action
                path.add(current);
                //recurse
                helper(s, i + 1, path, result);
                //backtrack
                path.remove(path.size() - 1);
            }
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
        System.out.println(new PalindromePartitioning().partition("aabbb"));
    }
}
