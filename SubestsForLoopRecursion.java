// Time Complexity : Exponential
// Space Complexity : O(n) due to recursive stack space where n is the length of nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Added base conditions which was giving wrong result

/*
Approach: Used for-loop recursive approach by passing index & path to the recusrive function. Start from loop from i = index, the create a new list copy all the elements from path and add nums[i]. Then call recurse() method again by passing index as i +1
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        recurse(nums, 0, new ArrayList<>());

        return result;
    }

    private void recurse(int[] nums, int index, List<Integer> path){

        result.add(path);

        //logic

        for(int i = index; i < nums.length; i++){

            List<Integer> newList = new ArrayList<>(path);
            newList.add(nums[i]);
            recurse(nums, i+1, newList);
        }

    }
}