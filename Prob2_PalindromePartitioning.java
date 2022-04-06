// Time Complexity : 2^N (For-Loop recursion) + (N + N) (For creating substring  + Checking if it is palindrome or not) => O(N + 2^N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        if(s == null || s.length() == 0)    return result;
        
        helper(s, 0, new ArrayList<>());

        return result;
    }
    
    public void helper(String s, int index, List<String> list){
        //Base case
        if(index == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            String subStr = s.substring(index, i + 1); //Substring from pivot-index to i
            if(isPalinDrome(subStr)){
                //Add SubString in list if it is palindrome
                list.add(subStr);
                
                //Recursion
                helper(s, i + 1, list);
                //Backtracking
                list.remove(list.size() - 1);
                
                /*
                //No Backtracking here
                List<String> temp = new ArrayList<>(list);
                temp.add(subStr);
                
                //Recursion
                helper(s, i + 1, temp);
                */
            }
        }
        
        //  -- If we use substring itself for recursion - Not need the index 
        
        // public void helper(String s, List<String> list){
        // //Base case
        // if(index == s.length()){
        //     result.add(new ArrayList<>(list));
        //     return;
        // }
        
        // for(int i = 0; i < s.length(); i++){ //. ---> Then everytime we will start checking from beginning becasue here s will be substring bydefault
        //     String subStr = s.substring(index, i + 1); //Substring from pivot-index to i
        //     if(isPalinDrome(subStr)){
        //         //Add SubString in list if it is palindrome
        //         list.add(subStr);
                
        //         //Recursion
        //         helper(s.substring(i+1, list);
        //         //Backtracking
        //         list.remove(list.size() - 1);
                
        //         /*
        //         //No Backtracking here
        //         List<String> temp = new ArrayList<>(list);
        //         temp.add(subStr);
                
        //         //Recursion
        //         helper(s, i + 1, temp);
        //         */
        //     }
        // }
        
        
        
    }
    
    public boolean isPalinDrome(String s){
        int i = 0, j = s.length() - 1;
        if(s == null)   return true;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))  return false;
            
            i++; j--;
        }
        
        return true;
    }
}