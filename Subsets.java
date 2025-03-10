// Time Complexity : O(2^n) where n is the no of elements in the array.
// Space Complexity : O(2^(n)) recursive stack space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Approach - This is a 0-1 recursion with backtracking solution.
import java.util.*;

class Solution {
    private void generate(int i, int[] nums, List<Integer> path, List<List<Integer>> result)
    {
        if(i < 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        generate(i-1, nums, path, result);

        path.add(nums[i]);
        generate(i-1, nums, path, result);
        path.remove(path.size()-1);
        
        return;

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums.length-1, nums, new ArrayList<>(), result);
        return result;
    }
}