// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Approach :
// Use backtracking to explore all ways to split the string
// At each step, pick substrings starting from index 0 to i, and check if it's a palindrome
// If it is, add to the current list and recurse on the remaining string
// Backtrack after recursive call by removing the last added substring


import java.util.*;

public class palindromePartitioning  {
    List<List<String>> op =  new ArrayList<>();
    public void helper(List<String> li,String palin)
    {
        if(palin.length()== 0)
        {
            op.add(new ArrayList<>(li));
        }
        if(palin.length()>0)
        {
            for(int i=0;i<palin.length();i++)
            {
                String sub = palin.substring(0,i+1);
                if(isPalin(sub))
                {
                    li.add(sub);
                    helper(li,palin.substring(i+1));
                    li.remove(li.size()-1);
                }
            }
        }
    }
    public boolean isPalin(String s)
    {
        char[] ch = s.toCharArray();
        int i =0;
        int j =ch.length-1;
        while(i<j)
        {
            if(ch[i]!=ch[j])
            {
                return false;
            }

        i++;
        j--;
        } 
        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> li = new ArrayList<>();
        helper(li,s);
        return op;
    }
}