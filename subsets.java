import java.util.*;

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        result = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());

        return result;

    }

    private void helper(int[] nums, int index, List<Integer> path) {
        // base
        if (index == nums.length) {
            result.add(path);
            return;
        }

        // do not choose case
        helper(nums, index + 1, new ArrayList<>(path));

        // choose case
        path.add(nums[index]);
        helper(nums, index + 1, new ArrayList<>(path));
    }
}