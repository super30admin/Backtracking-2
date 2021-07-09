import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N * 2 ^ N)
// Space Complexity : O(N) [Considering callstack space in the recusrsion]

// We perform recursion with backtracking of the path
// At every recursion we have 2 choice - whether to choose or not to choose the current nums[i]
// If we choose then we need to add it to path and after recursion is done the backtrack the path to // // previous state
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        // base
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic

        // choose
        path.add(nums[index]);
        helper(nums, index + 1, path);
        path.remove(path.size() - 1);

        // not choose
        helper(nums, index + 1, path);
    }
}