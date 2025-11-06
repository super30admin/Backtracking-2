/**
 * Subsets (Backtracking)
 * LeetCode: https://leetcode.com/problems/subsets/
 *
 * Approach:
 * - Uses backtracking to generate all possible subsets of the input array.
 * - At each step, chooses to include or exclude the current element.
 * - Recursively explores both choices and adds each subset to the result.
 *
 * Time Complexity: O(N * 2^N)
 *   - There are 2^N possible subsets for an array of length N.
 *   - Each subset can take up to O(N) time to copy.
 *
 * Space Complexity: O(N * 2^N)
 *   - The result list contains 2^N subsets, each with up to N elements.
 *   - The recursion stack can go up to N levels deep.
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> result) {
        //base
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        helper(nums, idx + 1, path, result);

        path.add(nums[idx]);
        helper(nums, idx + 1, path, result);
        path.removeLast();
    }
}
