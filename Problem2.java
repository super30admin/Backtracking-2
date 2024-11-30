//Time Complexity :O(2 pow n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return res;
    }

    private void helper(String s, int pivot, List<String> path){
        if(pivot==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=pivot; i<s.length(); i++){
            String subStr= s.substring(pivot,i+1);
            if(isPalindrome(subStr)){
                path.add(subStr);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String subStr){
        int l=0; int r= subStr.length()-1;

        while(l<r){
            if(subStr.charAt(l)!=subStr.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return true;
    }
}
