// Time Complexity : O(2n) (exponantial). At every node we take 2 decisions - chose/not chose
// Space Complexity : O(n) where n is the length of the subsets + O(n) for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Used recursion + backtracking
// Chose and dont chose approach.

class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums == null || nums.length == 0) return result;

        helper(nums, new ArrayList(),0);
        return result;
    }

    private void helper(int[] nums, List<Integer> subsets, int index) {
        if(index >= nums.length ){
            result.add(new ArrayList(subsets));
            return;
        }

        //Chose
        subsets.add(nums[index]);
        helper(nums, subsets, index+1);

        //Backtrack
        subsets.remove(subsets.size()-1);
        //Dont chose
        helper(nums, subsets, index+1);

    }


}
