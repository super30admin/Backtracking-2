// Problem 78. Subsets
// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void helper(int[] nums, int i, List<Integer> path, List<List<Integer>> result) {
        // Base case: if we've processed all elements
        if (i == nums.length) {
            result.add(new ArrayList<>(path)); // Add the current subset to result
            return;
        }
        // Recursive case 1: Don't choose the current element at index i
        helper(nums, i + 1, path, result);
        // Recursive case 2: Choose the current element at index i
        path.add(nums[i]); // Include nums[i] in the subset
        helper(nums, i + 1, path, result); // Recurse with the next index
        path.remove(path.size() - 1); // Backtrack by removing the last added element
    }
}
