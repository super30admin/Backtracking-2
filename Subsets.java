import java.util.*;
public class Subsets {
    // TC: O(N * 2 ^ N) where N is length of nums
    // SC: O(N) where N is length of nums
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> curr, int start) {
        res.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(res, nums, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
