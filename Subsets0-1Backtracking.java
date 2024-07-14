// Time Complexity : Exponential
// Space Complexity : O(n) due to recursive stack space where n is the length of nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Used 0-1 recursive backtracking approach by passing index & path to the recusrive function. In the base condition checked if index becomes equal to length of nums then add path to result. Start with the case 0 (don't choose) and pass index +1 whereas for case 1 (choose) pass index + 1 (as we cannot have same numbers repeated). In this method action is to add the element in the path, recurse and in the backtrack undo the action
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

        //base
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic

        //case 0
        backtrack(nums, index +1, path);

        //action
        path.add(nums[index]);

        //case 1
        backtrack(nums, index+1, path);

        //recurse
        path.remove(path.size() - 1);

    }
}