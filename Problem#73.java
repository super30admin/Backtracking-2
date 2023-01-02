// Subsets

// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }
    public void helper(int[] nums, int pivot, List<Integer> path){
        //base
        result.add(new ArrayList<>(path));
        //logic
        for(int i = pivot; i < nums.length; i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums, i + 1, path);
            //backtrack
            path.remove(path.size() - 1);
        }

    }
}