class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums, int i, List<Integer> path) {
        // base
        if(i == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        // choose
        path.add(nums[i]);
        helper(nums, i + 1, path);
        path.remove(path.size() - 1);
        // don't choose
        helper(nums, i + 1, path);
    }
}