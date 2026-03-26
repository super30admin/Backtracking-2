
    /**
    Time Complexity : O(N * 2^N)
    Explanation:
    - There are 2^N possible ways to partition the string.
    - For each partition, we check substrings for palindrome (O(N)).
    So overall complexity is O(N * 2^N).

    Space Complexity : O(N)
    Explanation:
    Recursion depth can go up to N and path stores at most N substrings.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially had difficulty deciding how to split the string dynamically.
    Fixed it by using backtracking:
        - Try every possible substring starting from current index
        - Check if it is a palindrome
        - If yes, include it in path and recurse
    Also needed to backtrack properly (remove last element)
    and copy the path when adding to result.
    */

    class Solution {


        public List<List<String>> partition(String s) {
    
            List<List<String>> result = new ArrayList<>();
            helper(s, 0, new ArrayList<>(), result);
            return result;
        }
    
        private void helper(String s, int pivot, List<String> path, List<List<String>> result) {
    
            // Base case
            if (pivot == s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }
    
            // Try all possible substrings
            for (int i = pivot; i < s.length(); i++) {
    
                String curr = s.substring(pivot, i + 1);
    
                if (isPalindrome(curr)) {
                    path.add(curr);
                    helper(s, i + 1, path, result);
                    path.remove(path.size() - 1); // backtrack
                }
            }
        }
    
        // Check palindrome
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
    }