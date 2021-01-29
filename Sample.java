# BackTracking-1

## Problem1 
Subsets (https://leetcode.com/problems/subsets/)

Approach#1: Recursion:
// Time Complexity : Exponential
// Space Complexity : Exponential
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        helper(nums,0, new ArrayList<Integer>());
        return result;
    }
    private void helper(int nums[], int index, List<Integer> path){
        //base
        if(index==nums.length){
            result.add(path);
            return;  
        } 
        
        //dont choose
        helper(nums, index+1,new ArrayList(path));
        
        //choose
        path.add(nums[index]);
        helper(nums, index+1, new ArrayList(path));
        
        
    }
}

Approach#2: BackTracking:
// Time Complexity : Exponential
// Space Complexity : Exponential
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        helper(nums,0, new ArrayList<Integer>());
        return result;
    }
    private void helper(int nums[], int index, List<Integer> path){
        //base
        if(index==nums.length){
            result.add(new ArrayList(path));
            return;  
        } 
        
        //dont choose
        helper(nums, index+1,path);
        
        //choose
        //action
        path.add(nums[index]);
        //recurse
        helper(nums, index+1, path);
        //backtrack
        path.remove(path.size()-1);
    }
}

