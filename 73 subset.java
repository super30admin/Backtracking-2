// Time Complexity : O(2^n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // aesha
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, pivot, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, List<Integer> path) {
        // base case
        if (i == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length(); i++) {
            // no choose
            helper(nums, i + 1, path);

            // choose
            path.add(nums[i]);
            helper(nums, pivot + i + 1, path);
            //path.remove(path.size() - 1);
        }
    }
}