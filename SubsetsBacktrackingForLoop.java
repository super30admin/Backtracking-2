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
    private void backtrack(int[] nums, int ind, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for(int i = ind; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}