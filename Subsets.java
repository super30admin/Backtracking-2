import java.util.*;

// O(n * 2^n) time, O(n) space
class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>());
        return ans;
    }

    private void helper(int idx, int[] nums, List<Integer> path) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // choose idx
        path.add(nums[idx]);
        helper(idx+1, nums, path);

        //backtrack
        path.remove(path.size() - 1);

        // dont choose idx
        helper(idx+1, nums, path);
    }
}