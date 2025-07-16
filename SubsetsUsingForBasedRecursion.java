// Time Complexity: O(2^n) where n is the number of elements in nums
// Space Complexity: O(n) for recursion stack and current path

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// This solution uses a backtracking + for-loop approach to generate all subsets.
// At each recursive level, we add the current path to the result.
// We then iterate over all remaining elements starting from the pivot index,
// include each one, recurse forward, and backtrack by removing the last element.
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums,0,new ArrayList<Integer>());
        return result;

    }

    private void helper(int[] nums, int pivot, List<Integer> path) {

        result.add(new ArrayList<>(path));

        for (int i = pivot; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums,i+1, path);
            path.removeLast();

        }
    }
}