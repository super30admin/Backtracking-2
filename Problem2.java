
//Time Complexity : O(2^n)
//Space Complexity :O(H)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

// This code generates all possible subsets of a given array using backtracking,
// exploring both including and excluding each element to construct the subsets.
import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    //0-1 Recursion
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> path) {

        if (idx == nums.length) {
            result.add(path);
            return;
        }

        helper(nums, idx + 1, new ArrayList<>(path));

        path.add(nums[idx]);
        helper(nums, idx + 1, new ArrayList<>(path));
    }
}