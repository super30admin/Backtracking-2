/*
* Approach:
*  1. Explore all possibilites by 0-1 based recursion.
* 
*  2.   not choose case:
            recurse on index+1
        choose case:
            add index to path
            recurse on index+1
            backtrack by removing added element from path.
* 
*  3. Finally when index reaches end, 
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

public class SubsetsZeroOneBased {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // not choose
        helper(nums, index + 1, path);

        // choose
        path.add(nums[index]);
        helper(nums, index + 1, path);
        path.remove(path.size() - 1);
    }
}