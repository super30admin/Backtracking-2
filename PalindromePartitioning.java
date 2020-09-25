// Time Complexity : O(n * Math.pow(2,n))
// Space Complexity : O(n * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    List<List<String>> output = new ArrayList();
    List<String> path = new ArrayList();
    
    public List<List<String>> partition(String s) {
        
        if(s == null || s.length() == 0)    return new ArrayList();
        
        backtrack(s, 0, path);
        
        return output;
    }
    
    private void backtrack(String s, int index, List<String> path){
        
        //base case 
        //adds path to the output string when index reaches the length of the string
        if(index == s.length()){
            output.add(path);
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            
            //checks whether a string is a palindrome
            if(isPalindrome(s.substring(index, i+1))){
                
                //references to current path
                List<String> p = new ArrayList(path);
                
                //add
                p.add(s.substring(index, i+1));
                
                //backtrack
                backtrack(s, i + 1, p);
            }
            
        }

    }
    
    private boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--))  return false;
        }
        
        return true;
    }
    
}
