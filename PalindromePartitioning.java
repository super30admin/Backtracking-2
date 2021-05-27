// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(2powern) since we have two choices (choose or not choose) that are being selected exponentially
//Space Complexity: O(n) where n is the height of the choices tree
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0 ) return result;
        backtrack(s, new ArrayList<>(), 0);
        return result;       
    }
    
    private void backtrack(String s, List<String> path, int i){
        
        //base case
        if(i == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int k = i ; k < s.length(); k++)
        {
          if(isPalindrome(s, i, k))
            {
                //action
                path.add(s.substring(i, k+1));
                
                //recurse
                backtrack(s, path, k+1);
                
                //backtrack
                path.remove(path.size()-1);
            }            
        }
    }
  
    private boolean isPalindrome(String s, int left, int right){
        if(left == right) return true;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }
}