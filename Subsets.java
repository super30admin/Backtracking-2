// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;        
    }
    public void recurse(int[] nums, int index, List<Integer> path){
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        
        path.add(nums[index]);
        recurse(nums, index + 1, path);
        path.remove(path.size() - 1);
        recurse(nums, index + 1, path);
    }
}