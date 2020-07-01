// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes	 	
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        
        result = new ArrayList<>();
        if(s == null || s.length()  == 0)
            return result;
        
        backtrack(s , new ArrayList<>() , 0);
        return result;
    }
    
    private void backtrack(String s , List<String> temp , int start){ 
        
        if(start == s.length())
            result.add(new ArrayList<>(temp));
        
        for( int  i = start; i < s.length() ; i++)
        {   
            if(isPalindrome(s,start,i)){
              //action   
              temp.add(s.substring(start , i +1));
              //recurse
              backtrack(s, temp ,i+1);
              //backtrack
              temp.remove(temp.size() - 1);
          }
        
      }
        
    }   
   private boolean isPalindrome(String s , int start , int end ){
          while(start <= end){
              if(s.charAt(start) != s.charAt(end)){
                  return false;
              }
      
              start++;
              end--;
          }
            return true;
        }
}