import java.util.*;

//TC is O(n^2)
//SC is O(h)
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
        // we don't write base case as for loop already checks it

        // logic
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {

            path.add(nums[i]);
            helper(nums, i + 1, path);

            // backtrack
            path.remove(path.size() - 1);
        }

    }
}