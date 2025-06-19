// Time complexity O(2^n)
// Space Complexity O(n) recursive stack
// Runs on leetcode YES

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        helper(nums, new ArrayList<Integer>(), 0);
        return result;
    }

    private void helper(int[] nums, ArrayList<Integer> path, int index) {

        // base
        if (index == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        // not choose
        helper(nums, path, index + 1);

        // choose
        path.add(nums[index]);
        helper(nums, path, index + 1);
        path.remove(path.size() - 1);

    }
}