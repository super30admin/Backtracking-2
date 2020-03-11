// Time Complexity : O(N2^n) , O(N) for checking palindrome, O(2^n)  T(n) = T(n-1) + T(n-2) + … + T(0) => T(n)=2 * (T(n-2) + T(n-3) + …) = 4 * (T(n-3) + …) = 8 * (T(n-4) + …) = 2^(n-1)
//total O(2^n) recursive calls.
// Space Complexity : O(n), due to recursion tree (which depth is at most n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solved.


// Your code here along with comments explaining your approach

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> solution = new ArrayList<>();
        List<String> state = new ArrayList<>();
        backtrack(solution, state, s, 0);
        
        return solution;
    }
    
    private void backtrack(List<List<String>> solution, List<String> state, String s, int start){
        
        //when to add solution
        if(start == s.length()){
            solution.add(new ArrayList<>(state));
        }
        
        for(int end = start; end<s.length(); end++){
        	//make the next call only if it's a vlid palindrome
            if(ValidPalindrome(s, start, end)){
                state.add(s.substring(start, end+1));
                backtrack(solution, state, s, end+1);
                state.remove(state.size()-1);
            }
        }
        
    }
    
    //function to check palindrome
    private boolean ValidPalindrome(String s, int start, int end){
        
        while(start<= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}