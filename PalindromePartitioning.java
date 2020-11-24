package S30.BackTracking_2;

/*
Time Complexity : O(N*2^N) - worse case, 2^N possible substrings, and all are palindromes, N is length of original string
Space Complexity : O(N), N is length of string
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        backtrack(s,new ArrayList<String>(),0);
        return result;
    }

    private void backtrack(String s, List<String> tempList, int index){
        if(index == s.length()){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                tempList.add(s.substring(index,i+1));
                backtrack(s,tempList,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r){

        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
