// TC: O(2^n)
// SC: O(2^n)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    private void helper(int[] nums, int pivot, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for(int i=pivot; i<nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return result;
    }
}