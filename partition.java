// Time Complexity : O(n * 2^n)
// Space Complexity :O(n * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    List<List<String>> result;
    List<String > path ;
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        path = new ArrayList();
        if(s == null || s.length() == 0) return result;
        backtrack(s,0,path);
        return result;
    }
    
    private void backtrack(String s,int index,List<String > path ){
        //base case
        if(index == s.length()) {
            result.add(path);
            return;
        }
        
        //progression
        for(int i=index+1 ; i <= s.length(); i++){
            //add to path
            if(isPalindrome(s.substring(index, i))){
                List<String> temp = new ArrayList(path);
                temp.add(s.substring(index, i));
                // backtracking 
                backtrack(s, i, temp);
            }
        }  
    }
    
    private boolean isPalindrome(String s){
        int left = 0 , right =s.length()-1;
        
        while(left < right ){
            if(s.charAt(left++) != s.charAt(right-- )) {
                return false;
            }
        }
        
        return true;
    }
}
