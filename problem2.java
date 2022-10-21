package Backtracking-2;

public class problem2 {
        // Time Complexity : O(2^n), n is no. of elements in an array
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        
        if(s == null || s.length() == 0) return result;
        
        helper(s, 0, new ArrayList<>());
        
        return result;
    }
    public void helper(String s, int index, List<String> path){
        //base
        if(index == s.length()){
            result.add(new ArrayList<>(path));
        }
        //logic
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                //action
                path.add(s.substring(index, i+1));
                //recursion
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int left, int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
