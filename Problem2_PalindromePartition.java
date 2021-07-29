// Time Complexity : o(2powern)
// Space Complexity : o(n) height and recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 

// using passing orginal string every time with incrementing index
/*
class Solution {
    List<List<String>> result;
     public List<List<String>> partition(String s) {
          result = new ArrayList<>();
     if(s.length() == 0 || s == null) {
        return result;
      }
       helper(s, 0, new ArrayList());
     return result;
 }

    
   

private void helper(String s, int index, List<String> path) 
{
    if(index==s.length())
    {
        result.add(new ArrayList<String>(path));
        return;
    }
    
    
    for(int i=index;i<s.length();i++)
    {
        if(isPalindrome(s,index,i))
        {
            path.add(s.substring(index,i+1));
            helper(s,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
    
    private boolean isPalindrome(String s, int start, int end) {
        if(start == end) {
            return true;
        }
        
        while(start<end)
        {
            if(s.charAt(start)!= s.charAt(end))
            {
                return false;
            }
            else
            {
                start++;
                end--;
            }
        }
        return true;
    }
}
*/

// with out using index and pass substring every recursive call
class Solution {
    List<List<String>> result;
     public List<List<String>> partition(String s) {
          result = new ArrayList<>();
     if(s.length() == 0 || s == null) {
        return result;
      }
       helper(s, new ArrayList());
     return result;
 }

    
   

private void helper(String s, List<String> path) 
{
    if(s.length()==0)
    {
        result.add(new ArrayList<String>(path));
        return;
    }
    
    
    for(int i=0;i<s.length();i++)
    {
        if(isPalindrome(s,0,i))
        {
            path.add(s.substring(0,i+1));
            helper(s.substring(i+1),path);
            path.remove(path.size()-1);
        }
    }
}
    
    private boolean isPalindrome(String s, int start, int end) {
        if(start == end) {
            return true;
        }
        
        while(start<end)
        {
            if(s.charAt(start)!= s.charAt(end))
            {
                return false;
            }
            else
            {
                start++;
                end--;
            }
        }
        return true;
    }
}