/*
* Approach:
*  1. Explore all possibilites by for-loop based recursion using pivot.
* 
*  2. Iterate index from pivot to length of nums.
        add index to path,
        recurse from index+1,
        backtrack by remove last added element to path.
* 
*  3. Finally when pivot reaches end, 
        add path to result.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2^n)
* 
* Space Complexity: O(n)
    n - levels of recursion
* 
*/

import java.util.ArrayList;
import java.util.List;

public class SubsetsForloopBased {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        result.add(new ArrayList<>(path));

        if (pivot == nums.length) {
            return;
        }

        for (int index = pivot; index < nums.length; index++) {
            path.add(nums[index]);
            helper(nums, index + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
