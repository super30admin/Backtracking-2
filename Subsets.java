// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class Subsets {
    // Using 0/1 recursion with backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path, result);
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        // base
        if (index == nums.length) {
            result.add(path);
            return;
        }
        // choose scenario
        // action
        path.add(nums[index]);
        // Recurse
        helper(nums, index + 1, new ArrayList<>(path), result);
        // backtrack
        path.remove(path.size() - 1);
        // no choose scenario
        helper(nums, index + 1, new ArrayList<>(path), result);
    }
}