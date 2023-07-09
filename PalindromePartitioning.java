// Time Complexity : O(2^n) where n is the length of the string
// Space Complexity :O(2^n) where n is the length of the string
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());

        return result;

    }

    private void helper(String s, int pivot, List<String> path){

        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = pivot; i<s.length(); i++){

            sb.append(s.charAt(i));

            if(!isPalindrome(sb.toString())){
                continue;
            }

            path.add(sb.toString());
            helper(s, i+1, path);
            path.remove(path.size()-1);

        }
    }

    private boolean isPalindrome(String str){

        if(str == null || str.length() < 1){
            return false;
        }

        int i = 0;
        int j = str.length() -1;

        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
