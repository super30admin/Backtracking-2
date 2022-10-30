// Time Complexity:O(2^n * n) - check palindrome condition + recursive solution
// Space Complexity: 
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * We maintain a pivot using which partitions are created and substrings will be created between pivot and index
 * + 1. These substrings will be then passed to the isPalindrome check and if they pass the check - they will be
 * added to the path. In the end, we check if the index is at the last charatcer and add the path to the 
 * the result
 */
import java.util.ArrayList;

public class PP {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        if(s.length() == 0 || s == null)
            return result;
        
        helper(s,0,new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int index, List<String> path)
    {
        //base
        if(index == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = index ; i < s.length(); i++)
        {
            String sub = s.substring(index,i+1);
            if(isPalindrome(sub)){
            //action
                path.add(sub);
            //recurse
            helper(s,i+1,path);
            //backtrack
            path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s)
    {
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
