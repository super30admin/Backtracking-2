// Time Complexity : O(2^n) -- exponential
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Backtrack approach, maintain teh index and ioncrement it in the recursive call
 * Check the generated substring is a plindrome or not and add it to the result list 
 */
import java.util.*;
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if(s.length() == 0 || s == null)
            return new ArrayList<>();
        result = new ArrayList<>();
        recurse(s, 0, new ArrayList<>());
        return result;
    }
    void recurse(String s, int index, List<String> path){
        if(index == s.length()){
            result.add(path);
            return;
        }
        for(int i=index; i< s.length();i++){
            if(checkPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                recurse(s, i+1, new ArrayList<>(path));
                path.remove(path.size()-1);
            }
        }
    }
    boolean checkPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}