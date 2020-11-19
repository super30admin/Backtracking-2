package Nov18;

import java.util.ArrayList;
import java.util.List;

class PalindromePartitioning {
    
/*    
     Exponential time complexity because we are doing backtracking.
    
     Space complexity: 
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
     
     Approach: 
     Backtracking solution given.
      
*/
    
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        
        // edge
        if (s == null || s.length() == 0) {
            return result;
        }
        
        helper(s, new ArrayList<>(), 0);
        return result;
    }
 
    // helper function for backtracking
    public void helper(String s, List<String> temp, int index) {
        
        // base
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // logic
        for (int i = index; i < s.length(); i++) {
            // action
            // check if current substring between 'index' and 'i' indexes is palindrome or not
            // if yes, then only make the recursive call and backtrack 
            // if no, check for next FOR iteration to get another substring 
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i+1));
                // recurse
                helper(s, temp, i+1);
                // backtrack
                temp.remove(temp.size()-1);
            }
            
        }
    }
    
    // helper function to check if a string is palindrome
    public boolean isPalindrome(String s, int start, int end) {
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