// tc: O(N*2^N) where N is length of input array
// sc: O(N) where N is length of input array

import java.util.*;
public class PalindromePartition {
    
}

class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        helper(s, 0, new ArrayList<>());
        return res;
    }
    private void helper(String s, int idx, List<String> path){
        //base
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
        }
        
        //logic
        for(int i=idx; i<s.length(); i++){
            String temp = s.substring(idx, i+1);
            if(isPalindrome(temp)){
                path.add(temp);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
