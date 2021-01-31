// Time Complexity : Exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int pivot, List<String> path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = pivot; i < s.length(); i++){
            if(isPalindrome(s, pivot, i)){
                path.add(s.substring(pivot, i+1));
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        if(l == r)return true;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
