// Time Complexity: O(2^n)
// Space Complexity: O(n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add current subset

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);                     // Choose
            backtrack(nums, i + 1, current, result);  // Explore
            current.remove(current.size() - 1);       // Unchoose
        }
    }
}
