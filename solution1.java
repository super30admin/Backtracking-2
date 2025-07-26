//TC -O(n * 2^n)

//SC -O(n)
public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Always add a copy of the current subset to result
        result.add(new ArrayList<>(current));

        // Explore further by including one number at a time
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);                          // Choose
            backtrack(i + 1, nums, current, result);       // Explore
            current.remove(current.size() - 1);            // Backtrack
        }
    }
}