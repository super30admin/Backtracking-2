// Time Complexity : O(n * (2^n)) --> where n is the size of input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (131): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {        
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        // edge case
        if (s == null || s.length() == 0) return result;
        
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(String s, int start, List<String> temp) {
        // base case
        if (start >= s.length()) {
            result.add(new ArrayList<>(temp));
        }
        
        // logic
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                // action
                temp.add(s.substring(start, i+1));
                
                // recurse
                backtrack(s, i+1, temp);
                
                // backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r) {
        if (l == r) return true;
        
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}