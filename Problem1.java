// Time Complexity : O(2^n) *n where n is the size of the input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using backtracking approach to create a subset at every level with fixed pivot and moving i based for loop.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path, List<List<Integer>> result) {

        result.add(new ArrayList<>(path));

        for (int i = pivot; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}