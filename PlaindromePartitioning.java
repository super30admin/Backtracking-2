
// Time Complexity : O(2*N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach
/*Approach:
1) we start with the string
2) we first check if the current string is a palindrome or not
3) if yes we move ahead and extract the first character from the string (1 single character can always be a palindrome). once we extract the character, we need to exclude it from the original string and continue the string. we use the same list
4) as we use the same list, after completing the recursion, we remove the last element added in the list. 
5) lst.add(s.substring(0,i+1));
    -> add string in the list -> "a", "ab,"aba"
                
                // recursion
6) helper(s.substring(i+1),lst);
   -> we keep on decreasing the size of the string, original string -> "aaa", it becomes "aa", then "a", then "" (empty)

*/

import java.util.*;
class PalindromePartitioning {
    
    List<List<String>> res;
    public List<List<String>> partition(String s) {
       
        res = new ArrayList<>();
        
        if(s==null || s.length()==0)
        {
            return res;
        }
        
        helper(s,new ArrayList<>());
        
        return res;
        
    }
    
    public void helper(String s, List<String> lst)
    {
        // base case 
        if(s.length()==0)
        {
            res.add(new ArrayList<>(lst));
            return;
        }
        
        // logic
        for(int i=0;i<s.length();i++)
        {
            if(isPalindrome(s,0,i))
            {
                // action add
                lst.add(s.substring(0,i+1));
                
                // recursion
                helper(s.substring(i+1),lst);
                
                // bactrack
                lst.remove(lst.size()-1);
                
            }
            
            
        }
        
    }
    
    public boolean isPalindrome(String s,int left, int right)
    {
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
            
            
        }
        return true;
    }
    
    
    
}