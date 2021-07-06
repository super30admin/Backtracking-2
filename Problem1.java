// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        //null case
        if(nums == null || nums.length == 0) return result;
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    private void helper(int[] nums , int index, List<Integer> path){
        //base
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose
        helper(nums ,index + 1, path);
        //choose
        path.add(nums[index]);
        helper(nums ,index + 1, path);
        //backtrack
        path.remove(path.size() - 1);
    }
}