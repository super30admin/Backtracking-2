    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/palindrome-partitioning/
    Time Complexity for operators : o(n^n) .. n is the length of the string
    Extra Space Complexity for operators : o(n) for (List<String> path) without recursive stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Backtracking
                    A) Call the backtracking function from main fucntion with initial values.
                    B) The backtracking function will contains input as string candidates, taregt, path, index.
                    C) Base case, index >= s.length() then we passed index then return.
                    F) In the main backtracking for loop(temp = to get the substring), check if it is palindrom and then add element to the list
                    E) then do backtracking, call backtracking function by passi for index+1.
                    F) At the end, remove last element from the String.
                    G) In main function, return final output.


                    Palindrome function - just checl the first and last element and deduct right and increase left.
    */  

class Solution {
    public List<List<String>> partition(String s) {
        
        backtracking(s,new ArrayList<>(),0);
        
        return answer;
    }
    
    List<List<String>> answer = new ArrayList<>();
    
    private void backtracking(String s, List<String> path, int index){
        
        if(index >= s.length()){
            answer.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            
            String temp = s.substring(index,i+1);
            if(isPalidrome(temp)){
                path.add(temp);
                
                backtracking(s,path,i+1);
                
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalidrome(String str){
        int left = 0;
        int right = str.length()-1;
        
        while(left < right){
            if(str.charAt(left) != str.charAt(right))
                return false;
            
            left = left + 1;
            right = right - 1;
        }
        
        return true;
    }
}