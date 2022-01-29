package backtracking2;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	//Time Complexity : O(n*2^n), where n is length of string s
	//Space Complexity : O(n), for internal stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
            if(s == null || s.length() == 0)
                return res;
        helper(s, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void helper(String s, List<List<String>> res, List<String> path, int idx) {
        // base
        if(idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        // logic
        for(int i=idx; i<s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if(isPalindrome(s, idx, i)) {
                path.add(sub);
                helper(s, res, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        
        return true;
    }
}
