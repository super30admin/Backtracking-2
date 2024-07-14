// Time Complexity : Exponential
// Space Complexity : O(n) due to recursive stack space where n is the length of nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Added base conditions which was giving wrong result

/*
Approach: Used for-loop recursive backtracking approach by passing index & path to the recusrive function. Start from loop from i = index, as an action add the nums[i] to the path, the call recurse() by passing index as i + 1 and then backtrack by undo the action i.e. remove the last added element
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> path){

        result.add(new ArrayList<>(path));

        //logic

        for(int i = index; i < nums.length; i++){

            //action
            path.add(nums[i]);

            //recurse
            backtrack(nums, i+1, path);

            //backtrack
            path.remove(path.size() - 1);
        }

    }
}