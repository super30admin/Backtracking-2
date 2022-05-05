// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path) {
        
        // base case
        if(index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        
        // case 0: not picked up case
        helper(nums, index + 1, path);
        
        // action
        path.add(nums[index]);
        
        // case 1: picked up case
        // recurse
        helper(nums, index + 1, path);
        
        //backtrack
        path.remove(path.size() - 1);
        
    }
}