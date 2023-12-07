// Time complexity : O(2^N)
// Space complexity : O(n)

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> result) {

        // base
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // not choose
        helper(nums, idx + 1, path, result);

        // choose
        path.add(nums[idx]);
        helper(nums, idx + 1, path, result);

        // Backtrack
        path.remove(path.size() - 1);
    }
}