import java.util.ArrayList;
import java.util.List;

/*
## Problem1:    Subsets (https://leetcode.com/problems/subsets/)

Time Complexity :   O (2 ^ N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (78. Subsets)
Any problem you faced while coding this :       No

 */
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

class subsetsRecursive {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int i, List<Integer> path){
        // base
        if(i == nums.length){
            result.add(path);
            return;
        }
        
        //logic
        //don't choose
        helper(nums, i+1, new ArrayList<>(path));
        
        // choose
        path.add(nums[i]);
        helper(nums, i+1, new ArrayList<>(path));
    }
}