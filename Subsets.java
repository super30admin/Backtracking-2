// Time Complexity: O(2 ^ number of decisions)
// SPace Complexity: O(N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        // base case
        if (nums == null || nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        // base case
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // recursion
        // don't choose
        helper(nums, index+1, path);
        // choose
        path.add(nums[index]);
        helper(nums, index+1, path);
        //backtrack
        path.remove(path.size()-1);

    }
}
