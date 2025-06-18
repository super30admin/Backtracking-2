// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Using 0-1 based recursion, for each character, either try to create substring from pivot to i (if it is palindrome,
// add to path else return) or just go to next element. This way we get app possible substring partitions of input string
// and if the resultant substring is palindrome, we add it to result.

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, 0, new ArrayList<String>(), result);
        return result;
    }
    public void helper(String s, int pivot, int i, ArrayList<String> path, List<List<String>> result){
        //base
        if(pivot == s.length() && path.size()!=0){
            result.add(new ArrayList<String>(path));
            return;
        }
        if(i==s.length()){
            return;
        }
        //logic
        helper(s, pivot, i+1, path, result);
        String currStr = s.substring(pivot, i+1);
        if(palindrome(currStr)){
            path.add(currStr);
            helper(s, i+1, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
    boolean palindrome(String s){
        int start = 0, end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}