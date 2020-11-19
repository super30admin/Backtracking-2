package Nov18;

import java.util.ArrayList;
import java.util.List;

class Subsets {
    
/*
       
     O(2^n) time complexity because we are visiting all elements in the input set and we have 2 choices at each of them to either choose or not choose 
    
     O(n) space complexity because no extra space used in this backtracking solution. Only space used is that by recursive stack. Recursive stack will hold n recursive calls for all the n elements of the given input set. 
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
     
     Approach: 
     Backtracking solution coded.
    
        
*/
    
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        
        // edge
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        helper(nums, new ArrayList<>(), 0);
        return result;
    }
    
    // helper solution for backtracking
    public void helper(int[] nums, List<Integer> temp, int index) {
        
        // base condition
        result.add(new ArrayList<>(temp));
        
        // logic
        for (int i = index; i < nums.length; i++) {
            // action
            temp.add(nums[i]);
            // recurse
            helper(nums, temp, i+1);
            // backtrack
            temp.remove(temp.size()-1);
        }
        
    }
}