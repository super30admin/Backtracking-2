// Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes

/*
 * Approach
 * here are we using recursion to solve the problem,
 * basically at each step we have to choose between pick or not pick a number
 * for this we are using recurion
 * 
 * we are going to use the for loop based recursion and we are using backtrack clean up path
 * and we will make a deepcopy of the path when pointer it to the result
 * so that we avoid return null result. 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path, List<List<Integer>> result) {
        // base
        if (pivot > nums.length) {
            return;
        }

        // logic
        result.add(new ArrayList<>(path));
        for (int i = pivot; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path, result);

            path.remove(path.size() - 1);

        }

    }
}