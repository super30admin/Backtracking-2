// Time Complexity : n ^ 2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        helper(s, 0, new ArrayList<>());
        return result;
    }
    private void helper(String s, int idx, List<String> path){
        if(idx == s.length()){
            result.add(new ArrayList<>(path));return;
        }
        for(int i = idx; i < s.length(); i++){
            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
