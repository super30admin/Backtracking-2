//T : O (2^n)
//S : O (array.length) // call stack
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, int index) {

        // logic
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
