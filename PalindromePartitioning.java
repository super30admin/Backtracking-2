// Time complexity:- O(n * 2^n), where n is the length of the string.
// Space complexity:-  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * This problem is about finding all possible ways to partition a string such that every substring is a palindrome.
 * I used a backtracking approach to explore all valid partitions by checking each substring from the current index.
 * If a substring is a palindrome, I add it to the path, recurse on the rest of the string, and backtrack to explore other combinations.
 */
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        helper(s, 0, s.length()-1, new ArrayList<>());

        return result;
    }

    private void helper(String str, int startIndex, int endIndex, List<String> path) {
        // Base case: if startIndex goes past endIndex, we have a complete partition
        if (startIndex > endIndex) {
            // Add a copy of the current path to the result
            result.add(new ArrayList<>(path));
            return;
        }

        // Try all substrings starting from startIndex up to endIndex
        for (int i=startIndex;i<=endIndex;i++) {
            // Check if the substring from startIndex to i is a palindrome
            if (isPalindrome(str, startIndex, i)) {
                // If it is, add it to the current path
                path.add(str.substring(startIndex, i+1));
                // Recurse with the next index (i+1)
                helper(str, i+1, str.length()-1, path);
                 // Backtrack: remove the last added substring
                path.remove(path.size()-1);

            }
        }
    }
    // Helper function to check if a substring is a palindrome.
    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            int chSt = str.charAt(start);
            int chEnd = str.charAt(end);

            if (chSt != chEnd) return false;

            start++;
            end--;
        }

        return true;

    }
}
