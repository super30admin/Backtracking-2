// Time Complexity :O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//For loop based recursion

class Solution {
    //Declaring result in global scope
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        //Initializing result
        result = new ArrayList<>();

        //Calling helper recursively
        helper(nums, 0, new ArrayList<>());
        return result;
        
    }

    private void helper(int[] nums, int pivot, List<Integer> path){
        //base
        //At every node, a unique list is created. Adding that to result
        //If we have no more number left in nums, end recursion
        if(pivot > nums.length) return;
        result.add(new ArrayList<>(path));

        //logic
        //Run for loop for all nums
        for(int i = pivot; i<nums.length; i++){
            //Action
            path.add(nums[i]);
            //Recurse
            helper(nums, i+1, path);
            //Backtrack
            path.remove(path.size()-1);
        }
    }
}