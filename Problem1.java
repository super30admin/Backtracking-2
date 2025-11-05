class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null|| nums.length == 0) return result;

        backtrack(nums, new ArrayList<>(), 0);

        return result;
    }

    public void backtrack(int[] nums, List<Integer> set, int idx) {
        result.add(new ArrayList<>(set));

        for (int i=idx; i<nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                backtrack(nums, set, i + 1);
                set.remove(set.size() - 1);
            }
        }
    }
}
