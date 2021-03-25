// Time Complexity :O(N*2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//In this approach we are implementing backtracking.

class Solution {
    public List<List<String>> partition(String s) {
      if(s==null || s.length()==0)
      {
        return output;
      }
      backTrack(s,0,new ArrayList<>());
       return output;
        
    }
    
    private List<List<String>> output = new ArrayList<>();
    //backtracking function in which we are passing the current string we are working on , the progression to drive the recursion and the path that we have taken at any point
    private void backTrack(String s ,int index,List<String> path)
    {
      //base case to see if we have reached the end of the string
      if(index>= s.length())
      {
        output.add(new ArrayList<>(path));
        return;
      }
        
      for(int i = index;i<s.length();i++)
      {
        String current = s.substring(index,i+1);
        
        if(checkPalindrome(current))
        {
          path.add(current);
          //pass the input string , increment the index as the current is already done and the path
          backTrack(s,i+1,path);
          //undo the change
          path.remove(path.size()-1);
        }
      }
    }
    //to check if the current substring is palindrome or not
    private boolean checkPalindrome(String s)
    {
        int l =0;
        int r =s.length()-1;

        while(l<r)
        {
          if(s.charAt(l)!=s.charAt(r))
          {
            return false;
          }
          else
          {
            l++;
            r--;
          }
        }
        return true; 
    }
}