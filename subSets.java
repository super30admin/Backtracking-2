class subSets {

    // TC: O(2^n) SC: O(n)
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        // base
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        // not choose
        helper(nums, index + 1, path);

        path.add(nums[index]);
        // chosse
        helper(nums, index + 1, path);
        // backtracking
        path.remove(path.size() - 1);
    }
}