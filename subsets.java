// Time Complexity : O(n * 2^n)
// Space Complexity : O(n * 2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> result; //Creates a result list
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>(); //Initialize result
        helper(nums, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] nums, int pivot, List<Integer> path){
        //base
        if(nums.length == 0) return; //If the input is empty
        // if(pivot == nums.length) return; No need handled by for loop

        //logic
        for(int i = pivot; i < nums.length; i++){
            path.add(nums[i]); //Add that element where i is, to the path
            helper(nums, i+1, new ArrayList<>(path)); //Move i to the next step, as we don't want duplicate elements
            path.remove(path.size() - 1); //Backtracking to explore other subsets
        }
        result.add(new ArrayList<>(path)); //Add the path to the result
    }
}