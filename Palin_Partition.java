// Time Complexity : O(2^n)
// Space Complexity :   O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        recurse(s, 0, 0,new ArrayList<>());
        return result;
    }

    public void recurse(String s, int pivot, int count, List<String> path){
        if(pivot == s.length()){
            if(count == s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i=pivot; i<s.length(); i++){
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                recurse(s, i+1, count + sub.length(), path);
                path.remove(path.size() - 1);
            }
           
        }
    }


    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}