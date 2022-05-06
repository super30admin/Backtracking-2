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