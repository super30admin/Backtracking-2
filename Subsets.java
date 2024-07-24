class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        // base
        result.add(new ArrayList<>(path));
        //logic
        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            recurse(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
