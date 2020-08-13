// Time Complexity : O(n*2^n)
//      n: length of the string
// Space Complexity : O(n)
//      n: length of the string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
// Using DFS + backtracking
class Problem2 {

    // global 
    List<List<String>> result;

    /** find partition */
    public List<List<String>> partition(String s) {

        // initialize
        result = new ArrayList<>();
        //edge case
        if(s== null|| s.length() == 0)
            return result;
        // back tracking
        backTracking(s,new ArrayList<String>(), 0);

        // return result
        return result;
        
    }
    
    /** Helper */
    private void backTracking(String s, List<String> temp, int index){
        
        // base case
        if(index == s.length()){  
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // iterate all the characters
        for(int i=index; i<s.length(); i++){
           
            // check if range is palindrome
            if(isPalindrome(s, index, i)){
                
                // ACTION: add to temp
                temp.add(s.substring(index, i+1));
                
                // RECURESE: go to next index location
                backTracking(s, temp, i+1);
                
                // BACKTRACK: remove
                temp.remove(temp.size()-1);
            }
        }
    }
    
    /** finds if a given string is Palindrome */
    private boolean isPalindrome(String inputStr, int start, int end){
        
        // check in range
        while(start < end){

            // not Palindrome(not equal)
            if(inputStr.charAt(start) != inputStr.charAt(end))
                return false;
            start++;
            end--;
        }
        // it is palindrome
        return true;
    }
}