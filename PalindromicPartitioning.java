// Time Complexity : O( n^2 * 2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtracking(s,new ArrayList<>(),0);
        return result;
    }

    private void backtracking(String s, ArrayList<String> temp, int index){
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int x = index; x < s.length(); x++){
            String substr = s.substring(index, x+1);
            if(isPalindrome(substr)){
                temp.add(substr);
                backtracking(s,temp,x+1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
