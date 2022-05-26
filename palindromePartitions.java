/*
Problem: https://leetcode.com/problems/palindrome-partitioning/
TC: O(exponential)
SC: O(n) -> where n = length of string
*/
class Solution {
    List<List<String>> palindromePartitions = null;
    
    public List<List<String>> partition(String s) {
        palindromePartitions = new ArrayList<>();
        
        if (s == null || s.length() == 0) {
            return palindromePartitions;
        }
        
        helper(s, 0, new ArrayList<>());
        return palindromePartitions;
    }
    
    private void helper(String s, int index, List<String> palindromes) {
        // Base
        if (index == s.length()) {
            palindromePartitions.add(new ArrayList<>(palindromes));
        }
        
        // Logic
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                palindromes.add(s.substring(index, i + 1));
                helper(s, i + 1, palindromes);
                palindromes.remove(palindromes.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
}

// DP for maintaining whether substring is a palindrome
class Solution {
    List<List<String>> palindromePartitions = null;
    public List<List<String>> partition(String s) {
        palindromePartitions = new ArrayList<>();
        boolean dp[][] = new boolean[s.length()][s.length()];
        backtrack(s, 0, new ArrayList<>(), dp);
        return palindromePartitions;
    }
    
    private void backtrack(String s, int index, List<String> curPalindromes, boolean[][] dp) {
        // Base
        if (index == s.length()) {
            palindromePartitions.add(new ArrayList<>(curPalindromes));
            return;
        }
        
        // Logic
        for (int i = index; i < s.length(); ++i) {
            // 0 1 2 3 4 
            // a a a b a
            // index = 0 and i = 4, we want to check if the string from index 1 - 3 is a palindrome too
            if (s.charAt(index) == s.charAt(i) && (i - index <= 2 || dp[index+1][i-1])) {
                dp[index][i] = true;
                curPalindromes.add(s.substring(index, i + 1));
                backtrack(s, i + 1, curPalindromes, dp);
                curPalindromes.remove(curPalindromes.size() - 1);
            }
        }
    }
}

// Similar palindrome logic for longest palindromic substring - https://leetcode.com/submissions/detail/698373227/