package BackTracking;

import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(2^n))
// Space Complexity : O(n)  ->height of thee stack
// Did this code successfully run on Leetcode : Yes

public class PalindromePartitioningUsingForLoopRecursion{
    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path =  new ArrayList<>();
        helper(s, 0);
        return result;
    }

    private boolean isPalindrome(String s)
    {
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
            {
                return false;
            }
            i++;
        }
        return true;
    }

    private void helper(String s, int pivot)
    {
        if(pivot == s.length())
            result.add(new ArrayList<>(path));
        for(int i=pivot; i<s.length(); i++)
        {
            String temp = s.substring(pivot,i+1);
            if(isPalindrome(temp))
            {
                path.add(temp);
                helper(s,i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
