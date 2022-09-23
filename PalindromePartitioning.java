import java.util.ArrayList;
import java.util.List;

/*
## Problem2:   Palindrome Partitioning(https://leetcode.com/problems/palindrome-partitioning/)

Time Complexity :   O (N * 2 ^ N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (131. Palindrome Partitioning)
Any problem you faced while coding this :       No

 */
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        helper(s, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(String s, int pivot, List<String> path){
        // base case
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
        }
        
        // logic
        for(int i=pivot; i< s.length(); i++){
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)){
                //action
                path.add(sub);
                
                // recursion
                helper(s, i+1, path);
                
                //backtrack
                path.remove(path.size() -1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int low = 0;
        int high = s.length() - 1;
        
        while(low < high){
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}