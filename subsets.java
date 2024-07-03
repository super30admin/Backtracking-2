// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>()); // recursive call
        return res;
    }

    private void recurse(int[] nums, int index, List<Integer> path) {
        res.add(new ArrayList<>(path)); // adding to the result
        for(int i = index; i < nums.length; i++){ // i starts from index as we don't have infinite supply
            List<Integer> temp = new ArrayList<>(path); // new array list, copy path to it.
            temp.add(nums[i]); // adding current integer from array
            recurse(nums, i + 1, temp); // recursive call
        }
    }
}