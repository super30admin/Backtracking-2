// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

import java.util.*;

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(int[] nums, int startIdx, List<Integer> path){
        //logic
        res.add(new ArrayList<>(path));
        for(int i = startIdx; i < nums.length; i++){
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
            
        }
    }
}