// Time Complexity : O(n * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

public class PalindromePartitioning {
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        
        if (s == null || s.length() == 0) return result;
        
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int index, List<String> path) {
        if(index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            
            if(isPalindrome(temp)) {
                path.add(temp);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        
        return true;
    }
}
