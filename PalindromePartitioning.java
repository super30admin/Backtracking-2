package Backtracking2;
// Time Complexity :O(n*2^n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    class Solution {
        List<List<String>> result = new ArrayList<>();
        public List<List<String>> partition(String s) {
            backtrack(s, 0, new ArrayList<>());
            return result;
        }
        private void backtrack(String s, int index, List<String> path){
            //base
            if(index == s.length()){
                result.add(new ArrayList<>(path));
            }
            //logic
            for(int i=index; i<s.length(); i++){
                String currStr = s.substring(index, i+1);
                if(isPalindrome(currStr)){
                    path.add(currStr);
                    backtrack(s, i+1, path);
                    path.remove(path.size()-1);
                }
            }
        }
        private boolean isPalindrome(String s){
            int i=0, j=s.length()-1;
            while(i < j){
                if(s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }
}
