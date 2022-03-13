// Time Complexity : O(2^n * n) where n is length of string. Extra n work to check palindrome
// Space Complexity : O(n) where n is length of string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

import java.util.*;

class Solution {
    
    private List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        
        partition(s, 0, new ArrayList<>());
        
        return result;
    }
    
    private void partition(String s, int index, List<String> paths) {
        
        // base
        if (index == s.length()) {
            result.add(new ArrayList<>(paths));
            return;
        }
        
        // recurse
        for (int i = index; i < s.length(); i++) {
            
            String substring = s.substring(index, i+1);
            
            if (isPalindrome(substring)) {
                
                paths.add(substring); // action
                
                partition(s, i+1, paths); // recurse
                    
                paths.remove(paths.size()-1); // backtrack
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        
        // 2 pointers
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}