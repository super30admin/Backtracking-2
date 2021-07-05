class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums, int i, List<Integer> path) {
        if(i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // choose
        path.add(nums[i]);
        backtrack(nums, i + 1, path);
        path.remove(path.size() - 1);

        // don't choose
        backtrack(nums, i + 1, path);

    }
}