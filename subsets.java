// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. We have two options at each index, either we choose or not choose.
 * 2. If we choose, we move to next index and add the element to the subset.
 * 3. If we dont choose, we move to next index and dont add the element to the subset.
 * 4. If index is out of bounds, we add the subset to the result.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result, List<Integer> subset){
        if(index == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        helper(nums, index+1, result, subset);
        subset.add(nums[index]);
        helper(nums, index+1, result, subset);
        subset.remove(subset.size()-1);
    }
}