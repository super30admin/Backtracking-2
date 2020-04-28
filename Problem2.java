import java.util.ArrayList;
import java.util.List;

// Time Complexity :O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> output = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0,new ArrayList<String>());
        return output;
        
    }
    private void backtrack(String s,int start,List<String> sub)
    {
        if(start >=s.length())
        {
            output.add(new ArrayList<>(sub));
        }
        for(int i = start;i<s.length();i++)
        {
            String substring = s.substring(start,i+1);
            if(ispalindrome(substring))
            {
                sub.add(substring);
                backtrack(s,i+1,sub);
                sub.remove(sub.size()-1);
            }
            
            
        }
    }
    private boolean ispalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}