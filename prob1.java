class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path)); // Fix: Add a deep copy of `path`
            return;
        }

        // Exclude current element
        backtrack(nums, index + 1, path);

        // Include current element
        path.add(nums[index]);
        backtrack(nums, index + 1, path);

        // Backtrack: Remove the last added element
        path.remove(path.size() - 1);
    }
}
