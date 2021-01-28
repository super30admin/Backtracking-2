//Problem 73: Palindrome Partitioning
//Time Complexity: O(something*2^N), which is exponential. N stands for input array length
//Space Complexity : O(N), because I'm using a current path list for storing current elements on each recursive call; 

/*
  Steps : Basically On each traversal find the left part of the string and check if it is palindrome or not. If it is palindrome add it to the current path. Now call recursive function on the remaining part.
 Generic case no validating the palindrome
  Eg: for aab:  []           "a|ab"
               [a]      "ab"
              [a,a] "b"         [aa]   "b"
          [a,a,b] ""          [aa,b] ""   [aab] ""    
*/

import java.util.*;

class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        
        if(s == null || s.length()==0) return res;
        
        helper(s,new ArrayList<>(),0);
        
        return res;    
    }
    
    private void helper(String s,List<String> currPath,int idx){
        
        //base
        if(idx==s.length()){
            res.add(new ArrayList<>(currPath));
            return;
        }
        
        //logic
        for(int i=idx;i<s.length();i++){
            
            String partLeft = s.substring(idx,i+1);
            
            if(isValid(partLeft)){
                currPath.add(partLeft);
                helper(s,currPath,i+1);
                currPath.remove(currPath.size()-1);
            }
            
        }
        
    }
    
    private boolean isValid(String s){
        
        int p1=0;
        int p2=s.length()-1;
        
        while(p1<=p2){
          if(s.charAt(p1)!=s.charAt(p2)) return false; 
            p1++;
            p2--;
        }
        
        return true;
    }
    
}