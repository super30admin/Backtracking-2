// Time Complexity : O(2^n), where n is the number of elements in the input array
//   - Each element can either be included or excluded, resulting in 2^n subsets
// Space Complexity : O(n) for the recursion stack and O(2^n * n) for storing all subsets in the result list
//   - Each path uses up to O(n) space, and there are 2^n such paths

// This solution uses backtracking to explore all subset combinations.
// At each recursive call, we decide whether to include the current element (via the for loop).
// We build subsets incrementally using a path list and backtrack after exploring each possibility.

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path) {
        // Add the current subset (path) to the result
        result.add(new ArrayList<>(path));

        // Explore further elements to add to the current path
        for (int i = pivot; i < nums.length; i++) {
            path.add(nums[i]); // Action
            helper(nums, i + 1, path); // Recurse
            path.remove(path.size() - 1); // Backtrack
        }
    }
}
