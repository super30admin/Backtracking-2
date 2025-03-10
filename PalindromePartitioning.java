// Time Complexity : O(n*2^n) where n is the no of elements in the array.
// Space Complexity : O(2^(n)) recursive stack space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Approach - This is a for loop based recursion with backtracking solution.
import java.util.*;
class Solution {
    private void dfs(int pivot, String s, List<String> path, List<List<String>> result)
    {
        if(pivot >= s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=pivot; i<s.length(); i++)
        {
            String curr = s.substring(pivot, i+1);
            if(isPalindrome(curr))
            {
                path.add(curr);
                dfs(i+1, s, path, result);
                path.remove(path.size()-1);
            }  
        }
        return;
    }
    private boolean isPalindrome(String s)
    {
        int start=0, end = s.length()-1;
        while(start < end)
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), result);
        return result;
    }
}