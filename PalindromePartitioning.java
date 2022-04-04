//Time Complexity O(2^N*N)
//Space Complexity O(N)
//LeetCode tested

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return result;
    }
    private void dfs(String s, int start,List<String> list){
        if(start == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                dfs(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end){
        while (start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
