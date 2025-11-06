// Time Complexity :O(n* 2^n)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(s, path, answer);
        return answer;
    }
    private void helper(String s, List<String> path, List<List<String>> answer){
        if(s.length() == 0){
            answer.add(new ArrayList<>(path));
            return; 
        }
        for(int i=0; i<s.length(); i++){
            String sub = s.substring(0, i+1);
            if(isPalindrome(sub)){
                //action
                path.add(sub);
                //recurse
                helper(s.substring(i+1), path, answer);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++; 
            right--;
        }
        return true;
    }
}