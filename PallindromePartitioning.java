// Time Complexity : Not sure 
// Space Complexity : O(n) where n is the length of the string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class PallindromePartitioning {
class Solution {
    
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        backtrack(s,0,new ArrayList<>());
        return result;
    }
    
    public void backtrack(String s, int start,  List<String> currList)
    {
        if(start>=s.length()){
        
            result.add(new ArrayList<>(currList));
            return;
        }
        
        for(int end = start; end<s.length();end++)
        {
            if(isPallindrome(s,start,end))
            {
                currList.add(s.substring(start,end+1));
                backtrack(s,end+1,currList);
                currList.remove(currList.size()-1);
            }
        }
        
        
    }
    
    
    public boolean isPallindrome(String s, int low, int high)
    {
        while(low<high)
        {
            if(s.charAt(low) != s.charAt(high))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    
}    
}
