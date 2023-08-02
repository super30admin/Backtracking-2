package BackTracking;

// Time Complexity : O(2^n))
// Space Complexity : O(n)  ->height of thee stack
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class SubSetUsing01Recursion {

    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(nums,0);
        return result;
    }

    public void helper(int[] nums, int i)
    {
        if(i == nums.length)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        //not choose
        helper(nums,i+1);

        //choose
        path.add(nums[i]);
        helper(nums,i+1);
        path.remove(path.size()-1);
    }
}
