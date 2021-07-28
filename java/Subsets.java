// Time Complexity : exponential O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
choose or dont choose at every step to create the subsets
add it to the list and remove the last element  at end of each path to use backtracking technique where we re-use the same list.
 */
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        //base
        if (index <= nums.length)
            res.add(new ArrayList<>(path));
        //logic
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}