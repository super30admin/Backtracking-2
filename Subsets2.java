import java.util.ArrayList;
import java.util.List;

/**
 * Subsets (Backtracking with Pivot)
 * LeetCode: https://leetcode.com/problems/subsets/
 *
 * Approach:
 * - Uses backtracking and a pivot index to generate all possible subsets.
 * - At each recursive call, adds the current path to the result.
 * - Iterates from the pivot index, adds each element to the path, and recurses.
 * - Backtracks after each recursion to explore all combinations.
 *
 * Time Complexity: O(N * 2^N)
 *   - There are 2^N possible subsets for an array of length N.
 *   - Each subset can take up to O(N) time to copy.
 *
 * Space Complexity: O(N * 2^N)
 *   - The result list contains 2^N subsets, each with up to N elements.
 *   - The recursion stack can go up to N levels deep.
 */

public class Subsets2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path, List<List<Integer>> result) {
        //base
        if (pivot == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        result.add(new ArrayList<>(path));
        //logic
        for (int i = pivot; i < nums.length; i++) {
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i + 1, path, result);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}
