// Time Complexity : exponential
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

import java.util.*;
class palPart {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0)
            return res;
        
        helper(s, new ArrayList<String>());
        return res;
    }
    
    private void helper(String s, List<String> path){
        //base
        if(s.length() == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s, 0, i)){
                path.add(s.substring(0, i + 1));
                helper(s.substring(i + 1), path);
                path.remove(path.size() - 1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        if(l == r)
            return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            else{
                l++;
                r--;
            }
                
        }
        return true;
    }
}