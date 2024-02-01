
//Time Complexity : l*(2^l) where l is length of string
//k is the average number of options per position.
//Space Complexity : O(H)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//  This code partitions a given string into all possible palindrome substrings using backtracking,
//  exploring all valid partitioning options.

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int idx, List<String> path){

        //base
        if(idx == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = idx; i<s.length();i++) {
            String subString = s.substring(idx, i+1);
            if(isPalindrome(subString)) {
                //action
                path.add(subString);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}