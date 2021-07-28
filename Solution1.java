//Time complexity: O(2^N), where N is the length of nums.
//Space complexity: O(N)

import java.util.*;

class Solution1 {
    List<List<Integer>> output;

    public void backtrack(int[] nums, int start, List<Integer> subset) {
        //add to result
        output.add(new ArrayList<>(subset)); 
        for (int i = start; i < nums.length; i++) {
            //add
            subset.add(nums[i]);
            //recurse
            backtrack(nums, i + 1, subset);
            //backtrack
            subset.remove(subset.size()-1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        output = new ArrayList<>();
        if(nums == null || nums.length == 0) return output;
        backtrack(nums, 0, new ArrayList<>()); 
        return output;
    }
}