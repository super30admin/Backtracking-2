/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome. Return all possible palindrome partitioning of s.
 * 
 * Idea: Use backtracking to generate the partitions and recurse if the token is
 * a palindrome. Go left to right. Check if current substring in window
 * left...right is palindrome and recursively call palindromePartioning on
 * remaining part.
 * 
 * Space Complexity:
 * Time Complexity:
 * 
 * Leetcode Attempts: 2
 * 
 * Leetcode Results:
 * Runtime: 3 ms, faster than 53.10% of Java online submissions for Palindrome Partitioning.
 * Memory Usage: 39.9 MB, less than 86.36% of Java online submissions for Palindrome Partitioning.
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        List<String> state = new LinkedList<>();
        backtrack(result, state, s, 0, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> state, String s, int start, int end) {
        if (start == s.length()) { // end of string reached
            result.add(new LinkedList<>(state));
            return;
        }

        if (isPalindrome(s, start, end)) { // if token start..end is palindrome
            state.add(s.substring(start, end + 1));
            backtrack(result, state, s, end + 1, end + 1);
            state.remove(state.size() - 1);
        }

        if (end < s.length() - 1) { // increase window and recurse
            backtrack(result, state, s, start, end + 1);
        }
    }

    /**
     * 
     * @param s
     * @param start     
     * @param end
     * @return true is s[start...end] is palindrome, false otherwise
     */ 
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}