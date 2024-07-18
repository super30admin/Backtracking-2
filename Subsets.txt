import java.util.*;

class Solution {
    // Tc: O(n * 2^n) Sc: O(n * 2^n)
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int ind, List<Integer> path) {

        res.add(new ArrayList<>(path));

        for (int i = ind; i < nums.length; i++) {
            path.add(nums[i]);

            helper(nums, i + 1, path);

            path.remove(path.size() - 1);
        }
    }

}

/*
 * //Using 0-1 Recursion and backtrack
 * class Solution {
 * // Tc: O(n * 2^n) Sc: O(n * 2^n)
 * List<List<Integer>> res;
 * 
 * public List<List<Integer>> subsets(int[] nums) {
 * res = new ArrayList<>();
 * helper(nums, 0, new ArrayList<>());
 * return res;
 * }
 * 
 * private void helper(int[] nums, int index, List<Integer> path) {
 * if (index == nums.length) {
 * res.add(new ArrayList<>(path));
 * return;
 * }
 * 
 * helper(nums, index + 1, path);
 * path.add(nums[index]);
 * helper(nums, index + 1, path);
 * path.remove(path.size() - 1);
 * }
 * }
 * 
 */