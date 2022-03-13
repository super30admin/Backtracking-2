// Time Complexity : O(2^n * n) where n is length of nums arr. Extra n work to clone into subset arrlist
// Space Complexity : O(n) where n is length of nums arr
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

import java.util.*;

class Solution {
    
    private List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        
        subSets(nums, 0, new ArrayList<>());
        
        return result;
        
    }
    
    private void subSets(int[] nums, int index, List<Integer> subset) {
        
        // base
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        
        // recurse
        
        // choose case
        subset.add(nums[index]); // action
        
        subSets(nums, index+1, subset); // recurse
        
        subset.remove(subset.size()-1); // backtrack
        
        // not choose case
        subSets(nums, index+1, subset); // recurse
    }
}