// Time Complexity : O(l*(2^l)) where l is the length of string
// Space Complexity : O(l) where l is the length of string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class PalindromePartition {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(String s, int i, List<String> path){
        //base
        if(i==s.length()){
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s.substring(i,j+1))){
                //action
                path.add(s.substring(i,j+1));
                //recurse
                backtrack(s,j+1,path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String [] args){
        PalindromePartition pp = new PalindromePartition();
        System.out.println(pp.partition("aab"));
    }
}