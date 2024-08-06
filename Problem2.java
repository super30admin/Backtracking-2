// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * In this problem, we want to find the subsets of substrings of s that are palindrome.
 * At every recursive call, we check if the current substring is a palindrome. If it is,
 * we add it to the path and recurse. When we backtrack, we remove the last element from the path.
 */

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper(String s, int idx, List<String> path) {
        //base
        if(idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)) {
                //action
                path.add(sub);
                //recurse
                helper(s, i + 1, path);
                //backtrack
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left <= right) {
            char atLeft = s.charAt(left);
            char atRight = s.charAt(right);
            if(atLeft != atRight) return false;
            left++;
            right--;
        }
        return true;
    }
}
