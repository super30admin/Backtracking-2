// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    //create a list of list final array
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        //initialize res;
        res = new ArrayList<>();
        //edge
        if(nums == null || nums.length == 0) return res;
        //call helper functions for recursion and backtrack
        helper(nums, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int [] nums, List<Integer> path, int index){
        //base 
        //if the index is the same as the length of the array then we have gone through it all
        if(index == nums.length){
            //add the path to the fianlly array but a copy of it becasue you will be just erasing the path if you add the path
            res.add(new ArrayList<>(path));
            return;
        }

        //logic
        //dont choose
        //call the helper by increasing the index and not choseing and same path and not adding anything to the path
        helper(nums, path, index + 1);
        //choose
        //add the current num into the path that you will choose
        path.add(nums[index]);
        //call the helper and move the index over becasue you chose that num
        helper(nums, path, index+1);
        //backtrack
        //remove the last element you added because we are back trakcing our action so we don't have to create a new array each time
        path.remove(path.size()-1);
    }
}