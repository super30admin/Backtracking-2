import java.util.*;
// Time Complexity : O(n^2 * 2^n)
//   Explanation: At each index we can either cut or extend, yielding ~2^(n-1) partitioning branches in the worst case.
//   For each candidate substring we check palindrome in O(len) time; amortized across the tree this is O(n * 2^n).
// Space Complexity : O(n) auxiliary (recursion stack + current path), excluding the output list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Managing indices (pivot and i) and remembering to backtrack the path

// Your code here along with comments explaining your approach
// Approach:
// - Use backtracking starting from a pivot index.
// - For each pivot, try all substrings s[pivot..i]. If the substring is a palindrome, choose it,
//   append to the current path, recurse from i+1, and then backtrack.
// - When pivot reaches s.length(), we've formed a complete partition; add a copy of path to result.
// - Palindrome check is done with two pointers (left/right) without extra space.


class PalindromePartitioning {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    // Backtracking helper:
    // pivot: start index of the next substring to consider
    // path: current list of chosen palindromic substrings
    private void helper(String s, int pivot, List<String> path){
        // Base case: consumed the entire string => one valid partition found
        if (pivot == s.length()){
            result.add(new ArrayList<>(path)); // add a copy of current path
            return;
        }

        // Try all substrings starting at 'pivot' and ending at i
        for (int i = pivot; i < s.length(); i++){
            // Candidate substring s[pivot..i]
            String sub = s.substring(pivot, i + 1);

            // Proceed only if the candidate is a palindrome
            if (isPalindrome(sub)){
                // Choose
                path.add(sub);

                // Explore: move pivot to the next position after i
                helper(s, i + 1, path);

                // Unchoose (backtrack) so we can try a different cut
                path.remove(path.size() - 1);
            }
        }
    }

    // Two-pointer palindrome check in O(len)
    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromePartitioning sol = new PalindromePartitioning();
        String input = "aab";
        List<List<String>> partitions = sol.partition(input);

        System.out.println("Palindrome partitions of \"" + input + "\":");
        for (List<String> p : partitions) {
            System.out.println(p);
        }
    }
}
