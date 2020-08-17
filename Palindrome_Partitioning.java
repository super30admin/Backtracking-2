import java.util.ArrayList;
import java.util.List;
//Approach: Backtracking
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0)
            return result;
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(String s, int index, List<String> temp)
    {
        //base case
        if(index >= s.length())
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        //logic
        //   System.out.println("checking "+ index);
            for(int i=index;i<s.length();i++)
            {
          //      System.out.println("checking loop "+ index +"-ith-"+i);
            //    System.out.println("is palindrome check till "+ index +"--"+i);
            	
            	//Checking if the left part is palindrome
                if(isPalindrome(s, index, i))
                {             
              //      System.out.println("adding to list "+ s.substring(index,i+1));
                	
                	//adding substring to temp
                    temp.add(s.substring(index,i+1));
                    
                    //recurse
                    backtrack(s, i+1, temp);
                    
                //    System.out.println("removing to list "+ temp.get(temp.size()-1)); 
                    
                    //backtracking and removing what we added
                    temp.remove(temp.size()-1);
                }
            }
        
    }
    private boolean isPalindrome(String s, int l, int r)
    {
        if(l == r)
            return true;
        while(l <= r)
        {
            if(s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            l++;r--;
        }
        return true;
    }
}
//Time Complexity : O(2 ^ n) 
//Space Complexity : O(n)  
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :