// Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not sure about time complexity


// Your code here along with comments explaining your approach
//1 using recursion in for loop along with backtracking

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        
        helper(s, 0,new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(String s , int pivot, List<String> path )
    {
       if(pivot == s.length())
       { 
           result.add(new ArrayList<>(path));
           return;
       }
        

       
        for(int i = pivot; i< s.length(); i++)
        {
              if( isPalindrome(s, pivot,i))
                   {
                             path.add(s.substring(pivot,i+1));
                    helper(s,i+1,path);
                     path.remove(path.size()-1);      
                   }
      }
  }
    
    public boolean isPalindrome(String s , int l , int r)
    {
        while(l<r)
        {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
        
    }
}