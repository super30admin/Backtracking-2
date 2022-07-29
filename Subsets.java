import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(2^n), n=no. of numbers
//Space complexity: Recursive stack space

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper(nums, 0, new ArrayList<>());
        return result;

        // for loop based backtracking solution

    }

    private void helper(int[] nums, int index, List<Integer> path) {
        // logic
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            // action
            path.add(nums[i]);
            // recurse
            helper(nums, i + 1, path);
            // backtrack
            path.remove(path.size() - 1);
        }
    }
}