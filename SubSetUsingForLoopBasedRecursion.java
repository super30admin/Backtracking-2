package BackTracking;

// Time Complexity : O(2^n))
// Space Complexity : O(n)  ->height of thee stack
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class SubSetUsingForLoopBasedRecursion {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int pivot, List<Integer> path)
    {
        //if(pivot > nums.length)  return;
        result.add(new ArrayList(path));

        for(int i=pivot; i<nums.length; i++)
        {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            helper(nums,i+1, temp);
        }


    }

}
