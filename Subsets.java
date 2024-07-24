// Time Complexity : O(l * 2^l) where l - length of string
// Space Complexity : O(l)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;

        dfs(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> result) {
        // base
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // don't choose
        dfs(nums, idx + 1, path, result);

        // choose
        // action
        path.add(nums[idx]);
        // recurse
        dfs(nums, idx + 1, path, result);
        // backtrack
        path.remove(path.size() - 1);
    }
}