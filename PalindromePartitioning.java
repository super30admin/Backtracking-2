/**
 * Time Complexity :  O(n*2^n) (Ignoring the complexity of checking if its palindrome)
 * Space Comlexity : O(n*2^n) where n = String length
 */

import java.util.*;
public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s,new ArrayList<String>(),0);
        return result;
    }
    
    private void backtrack(String s, List<String> temp, int index){
        //base
        if(index == s.length())
        {
            result.add(new ArrayList<>(temp));
        }
        
        //logic
        for(int i=index;i<s.length();i++){
            
            if(isPalindrome(s,index,i)){
                //action
                temp.add(s.substring(index,i+1));

                //recurse
                backtrack(s,temp,i+1);
            
                //backtrack
                temp.remove(temp.size()-1);
            }
            
            
        }
    }
    
    private boolean isPalindrome(String s, int left, int right){
        if(left==right) return true;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}